/**
 * A collection of web service utilities to add
 * data to the existing database schema. 
 *
 * @author William Courtney
 */
package dbutils;

import java.util.List;
import java.util.Iterator;

import java.util.jar.JarFile;
import java.util.jar.JarEntry;

import java.io.StringReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.IOException;

import dbutils.xcede.schema.*;
import dbutils.DBHandler.Study;
import dbutils.DBHandler.RecruitmentStudy;

public class DBServiceImpl implements DBService{
   DBHandler db = new DBHandler();
   /**
    * Called once all byte packets have been "loaded" to 
    * finalize upload of a jar file.
    *
   public String postSnapshots(String jarName,String recordName){ 
      return postJarData(new SnapshotHandler(),jarName,recordName);
   }
   */
   /**
    * Adds VBM correlation data contained in the XCEDE-formatted 
    * xml document to the database.
    */
   public String postVBM(String jarName,String recordName){
      return "vbm go!";
      //return postJarData(new VBMHandler(),jarName,recordName);
   }
   /**
    * Called repeatedly with successive byte chunks to
    * upload a jar file containing snapshots and their
    * metadata.
    */
   public String loadJar(String jarName,byte[] input){
      String filename = Utilities.buildFileName(jarName);
      try{
         appendJar(filename,input);

         return "Wrote "+input.length+" bytes to '"+filename+"'";
      }
      catch(Exception e){
         return "Cannot open '"+filename+"' for writing.";
      }
   }
   /**
    * Called once all byte packets have been "loaded" to 
    * finalize upload of a jar file with the name described
    * in "jarName". The jar should contain an XCEDE 
    * description on the images in a file at the location
    * within the jar as described by "recordName".
    */
   private String postJarData(PipelineHandler handler,
                              String jarName,
                              String recordName){
      StringBuffer acc = new StringBuffer();
      try{
         JarFile jar = new JarFile(Utilities.buildFileName(jarName));

         // parse the xcede record to get "outputs":
         JarEntry record = (JarEntry)(jar.getEntry(recordName));
         acc.append("got jar record\n");
   
         
         InputStream xmlStream = jar.getInputStream(record);
         Analysis analysis = Utilities.parseXCEDE
                              (new InputStreamReader(xmlStream));
         if(analysis == null) return "Couldn't parse XCEDE document.";
         acc.append("got analysis\n");
         
         // get analysis-specific metadata
         String ursi = null;
         String visitID = null;
         int studyID = -1;
         int pipelineID = -1;
         int processStepID = -1;
         int processID = -1;


         String psr = ProvenanceHandler.addProvenance(analysis).trim();
         try{
            processStepID = Integer.parseInt(psr); 
         } catch(NumberFormatException e){
            return psr;
         } 
         acc.append("provenance added\n");

         ursi = analysis.getSubjectID();
         studyID = db.getStudyID(analysis.getStudyID());
         visitID = db.getVisitID(analysis.getVisitID(),studyID,ursi);
         pipelineID = db.getPipelineID(analysis.getID());
         processID = db.getProcessID(ursi,studyID,visitID,pipelineID);

         // add each "output" (i.e. snapshot) 
         List outputs = analysis.getOutputs();
         Iterator i = outputs.iterator();
         while(i.hasNext()){
            Output data = (Output)i.next();

            acc.append("analysisID: ").append(data.getAnalysisID()).append("\n");
            acc.append("analysisURI: ").append(data.getAnalysisURI()).append("\n");

            // get data stream
            JarEntry entry = 
               (JarEntry)
               (jar.getEntry(data.getAnalysisURI()));

            acc.append("opened a jar entry:\n");
            acc.append("\t").append(entry.toString()).append("\n");
            
            InputStream entryStream = jar.getInputStream(entry);
            String label = data.getAnalysisID();

            acc.append("created entrystream\n");

            //boolean success = 
            acc.append(handler.handleData(entryStream,label,ursi,
                                     studyID,visitID,
                                     processStepID))
                  .append("\n");

/*
            if(success)
               acc.append("Successfully uploaded!\n");
            else acc.append("Unable to upload snapshot!\n");
*/


            entryStream.close();
            acc.append("done\n");
            if(true) return acc.toString();
         } 
         // clean up
         jar.close();
         //Runtime.getRuntime().exec("rm "+Utilities.buildFileName(jarName));

         return acc.toString();
      } catch(IOException e){
         acc.append("Error handling jar: ");
         acc.append(e.getMessage()).append("\n");
      }
      return acc.toString();
   }
   /**
    * Adds bytes to the end of an existing file.
    */
   private void appendJar(String filename,byte[] input) throws IOException{
       // open file to append:
       FileOutputStream out = 
          new FileOutputStream(filename,true);
       out.write(input);
       out.close();
   }
   public String[] getStudies(){
      DBHandler db = new DBHandler();
      List<Study> studies = db.getStudies();

      String[] result = new String[studies.size()];
      Iterator<Study> i = studies.iterator();
      for(int j=0;i.hasNext();j++){
         Study s = i.next();
         result[j] = s.studyNumber+"|"+s.label+"|"+s.pi+"|"+s.description
                     +"|"+s.addToRecruitment
                     +"|"+s.recruitmentStudyPurpose
                     +"|"+s.recruitmentProtocolSummary
                     +"|"+s.recruitmentEligibilityCrit
                     +"|"+s.recruitmentContactName
                     +"|"+s.recruitmentContactEmail
                     +"|"+s.recruitmentContactPhone;
      }
      return result;
   }
   public String[] getRecruitmentStudies(){
      List<RecruitmentStudy> studies = db.getRecruitmentStudies();

      String[] result = new String[studies.size()];
      Iterator<RecruitmentStudy> i = studies.iterator();
      for(int j=0;i.hasNext();j++){
         RecruitmentStudy s = i.next();
         result[j] = s.IRBNumber
                     +"|"+s.recruitmentStudyPurpose
                     +"|"+s.recruitmentProtocolSummary
                     +"|"+s.recruitmentEligibilityCrit
                     +"|"+s.recruitmentContactName
                     +"|"+s.recruitmentContactEmail
                     +"|"+s.recruitmentContactPhone;
      }
      return result;
   }
   public String[] getRadiologistWorklistPaths(String[] excludePIs){
      if(excludePIs == null){ return new String[0]; }

      //make sure all PIs are capitalized:
      for(int i=0;i<excludePIs.length;i++)
         excludePIs[i] = excludePIs[i].toUpperCase();

      List<Integer> scanIDs = db.getWorklist(7,excludePIs); // get worklist for site 7 (MRN)
      String[] paths = new String[scanIDs.size()];

      Iterator<Integer> it = scanIDs.iterator();
      int scanID = 0;
      for(int i=0;it.hasNext();i++){
         scanID = it.next();
         paths[i] = ""+scanID+"|"+db.getScanSessionLocation(scanID);
      }
      return paths;
   }
   public String addToRadiologistQueue(int scanID){
      return db.addToRadiologistQueue(scanID);
   }
   public String[] getSubjectEnrollment(String ursi){
      List<Study> studies = db.getSubjectEnrollment(ursi);
      String[] result = new String[studies.size()]; 

      Iterator<Study> it = studies.iterator();
      for(int i=0;it.hasNext();i++){
         Study temp = it.next();
         result[i] = temp.id+"|"+temp.label+"|"+temp.studyNumber;
      }

      return result;
   }
}
