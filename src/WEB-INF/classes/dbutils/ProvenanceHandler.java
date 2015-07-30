package dbutils;

// provenance libraries
import dbutils.xcede.schema.Analysis;
import dbutils.xcede.schema.ProcessStep;

// castor libraries
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.mapping.Mapping;
import org.xml.sax.InputSource;

// core libraries
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

// exceptions:
import java.io.IOException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.mapping.MappingException;

class ProvenanceHandler{
   public static String addProvenance(Analysis analysis){
      
      if(analysis == null) return "Error: empty analysis!";

      List steps = null;
      if(analysis.getProvenance() == null
         || (steps = analysis.getProvenance()
                            .getProcessSteps())
             .size() < 1)
         return "Error: There are no process steps "
               +"in the provided provenance!";

      String study = analysis.getStudyID();
      String ursi = analysis.getSubjectID();
      String visit = analysis.getVisitID();
      String pipeline = analysis.getID();

      DBHandler db = new DBHandler();

      // Throw out bad inputs
      int studyID = db.getStudyID(study);
      if(studyID == -1)
         return "'"+study+"' is not a known study.";

      if(!db.existsSubjectInStudy(ursi,studyID))
         return "URSI '"+ursi+"' not enrolled in study '"
               +study+"'.";

      int pipelineID = db.getPipelineID(pipeline);
      if(pipelineID < 0){
         StringBuffer ret = new StringBuffer();

         ret.append("No such pipeline: '")
            .append(pipeline)
            .append("'.\n");

         ret.append("Valid pipelines are: \n");

         Iterator i = db.getValidPipelines().iterator();
         while(i.hasNext()){
            ret.append("\t - ")
               .append(i.next())
               .append("\n"); 
         }
         return ret.toString();
      }

      String visitID = db.getVisitID(visit,studyID,ursi);
      if(visitID == null){
         StringBuffer ret = new StringBuffer();

         ret.append("No such visit: '")
            .append(visit)
            .append("'.\n");

         ret.append("Valid visits for '")
            .append(ursi)
            .append("' in study '")
            .append(study)
            .append("' are: \n");

         List l = db.getValidVisits(ursi,studyID);
         Iterator i = l.iterator();
         while(i.hasNext()){
            ret.append("\t - ")
               .append(i.next())
               .append("\n"); 
         }
         return ret.toString();
      }

      int processID = db.createProcess(ursi,studyID,visitID,pipelineID);

      // add process steps to process
      Iterator i = steps.iterator();
      StringBuffer acc = new StringBuffer();
      while(i.hasNext()){
         ProcessStep p = (ProcessStep)(i.next());
         acc.append(db.createProcessStep(p,processID,pipeline,1))
            .append("\n");
      }

      return acc.toString();
   }
}
