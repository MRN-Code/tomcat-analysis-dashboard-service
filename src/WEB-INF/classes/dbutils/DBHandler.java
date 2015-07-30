package dbutils;

import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.Calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;

import dbutils.xcede.schema.ProcessStep;

public class DBHandler{
   public final class Question{
      public final String questionID;
      public final String label;
      
      private Question(String questionID,String label){
         this.questionID = questionID;
         this.label = label;
      }
   }
      
   public final class Instrument{
      public final int id;
      public final String label;
      public final String description;

      private Instrument(int id,String label,String description){ 
         this.id = id;
         this.label = label;
         this.description = description;
      }
   }
   public final class RecruitmentStudy{
      public final String IRBNumber;
      public final String recruitmentStudyPurpose;
      public final String recruitmentProtocolSummary;
      public final String recruitmentEligibilityCrit;
      public final String recruitmentContactName;
      public final String recruitmentContactEmail;
      public final String recruitmentContactPhone;

      private RecruitmentStudy(String IRBNumber, 
                    String recruitmentStudyPurpose,
                    String recruitmentProtocolSummary,
                    String recruitmentEligibilityCrit,
                    String recruitmentContactName,
                    String recruitmentContactEmail,
                    String recruitmentContactPhone){ 
         this.IRBNumber = IRBNumber;
         this.recruitmentStudyPurpose = recruitmentStudyPurpose;
         this.recruitmentProtocolSummary = recruitmentProtocolSummary;
         this.recruitmentEligibilityCrit = recruitmentEligibilityCrit;
         this.recruitmentContactName = recruitmentContactName;
         this.recruitmentContactEmail = recruitmentContactEmail;
         this.recruitmentContactPhone = recruitmentContactPhone;
      }
   }
   public final class Study{
      public final int id;
      public final String label;
      public final String pi;
      public final String description;
      public final String studyNumber;
      public final String addToRecruitment;
      public final String recruitmentStudyPurpose;
      public final String recruitmentProtocolSummary;
      public final String recruitmentEligibilityCrit;
      public final String recruitmentContactName;
      public final String recruitmentContactEmail;
      public final String recruitmentContactPhone;


      private Study(int id,String label,String pi,String description,
                    String studyNumber, 
                    String addToRecruitment,
                    String recruitmentStudyPurpose,
                    String recruitmentProtocolSummary,
                    String recruitmentEligibilityCrit,
                    String recruitmentContactName,
                    String recruitmentContactEmail,
                    String recruitmentContactPhone){ 
         this.id = id;
         this.label = label;
         this.pi = pi;
         this.description = description;
         this.studyNumber = studyNumber;
         this.addToRecruitment = addToRecruitment;
         this.recruitmentStudyPurpose = recruitmentStudyPurpose;
         this.recruitmentProtocolSummary = recruitmentProtocolSummary;
         this.recruitmentEligibilityCrit = recruitmentEligibilityCrit;
         this.recruitmentContactName = recruitmentContactName;
         this.recruitmentContactEmail = recruitmentContactEmail;
         this.recruitmentContactPhone = recruitmentContactPhone;
      }
      private Study(int id,String label){ 
         this.id = id;
         this.label = label;
         this.pi = null;
         this.description = null;
         this.studyNumber = null;
         this.addToRecruitment = null;
         this.recruitmentStudyPurpose = null;
         this.recruitmentProtocolSummary = null;
         this.recruitmentEligibilityCrit = null;
         this.recruitmentContactName = null;
         this.recruitmentContactEmail = null;
         this.recruitmentContactPhone = null;
      }
      private Study(int id,String label, String studyNumber){ 
         this.id = id;
         this.label = label;
         this.pi = null;
         this.description = null;
         this.studyNumber = studyNumber;
         this.addToRecruitment = null;
         this.recruitmentStudyPurpose = null;
         this.recruitmentProtocolSummary = null;
         this.recruitmentEligibilityCrit = null;
         this.recruitmentContactName = null;
         this.recruitmentContactEmail = null;
         this.recruitmentContactPhone = null;
      }
   }
   public final class Series{
      public final String seriesLabel;
      public final int sortOrder;
      public final int scanID;
      public final String piID;
      public final String URSI;
      public final String studyDirName;
      public final String hrrcNum;
      public final String scanLabel;
      public final String scannerLabel;
      public final String segmentInterval;
      public final Date scanDate;

      private Series(String seriesLabel,int sortOrder,int scanID, String piID, String URSI, String studyDirName, String hrrcNum, 
                   String scanLabel, String scannerLabel, String segmentInterval, Date scanDate){
         this.seriesLabel = seriesLabel;
         this.sortOrder = sortOrder;
         this.scanID = scanID;
         this.piID = piID;
         this.URSI = URSI;
         this.studyDirName = studyDirName;
         this.hrrcNum = hrrcNum;
         this.scanLabel = scanLabel;
         this.scannerLabel = scannerLabel;
         this.segmentInterval = segmentInterval;
         this.scanDate = scanDate;
      }
   }

   public static Connection getConnection(){
      try{
         Class.forName("org.postgresql.Driver");
         return DriverManager.getConnection("jdbc:postgresql://tesla:6117/postgres","postgres","postgres");
      }
		catch( ClassNotFoundException  e) {
			System.out.println("ClassNotFoundException: " + e + "\n");
			e.printStackTrace();
	
		}
      catch( SQLException e){
         System.out.println(e.getMessage());
         e.printStackTrace();
      }
      return null;
   }
   public int getPipelineID(String pipeline){
      Connection connection = getConnection();
      Statement stmt = null;
      try{
         String qry = "select id "
                    + "from mrs_pipelines_vw "
                    + "where label='"+pipeline+"'";
         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         if(!rs.next()) return -1; // doesn't exist

         return rs.getInt(1);
      } catch(SQLException e){
         e.printStackTrace();
         return -1;
      } finally{
         try{ 
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ return -1; }
      }
   }
   public List<String> getSubjectTypes(String studyNumber){
      Connection connection = getConnection();
      final List<String> result = new Vector<String>();
      Statement stmt = null;
      String qry = null;
      try{
         qry = "select label "
              + "from mrs_subject_types_vw "
              + "where study_id = "
                 + "(select study_id "
                 + " from mrs_studies_vw "
                 + " where hrrc_num='"+studyNumber+"')";


         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         while(rs.next()) 
            result.add(rs.getString(1));

         return result;
      } catch(SQLException e){
         return new Vector<String>();
      } finally{
         try{ 
            if(stmt!=null)stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ 
            return new Vector<String>();
         }
      }
   }
   public List<Series> getStudySeries(String analysis,String studyNumber,  
                                      String subjectType,String gender,
                                      int ageLowerBound,int ageUpperBound){
      Connection connection = getConnection();
      final List<Series> result = new Vector<Series>();
      Statement stmt = null;
      String qry = null;
      
      Calendar dateUpperBound = Calendar.getInstance();
      dateUpperBound.add(Calendar.YEAR,-ageLowerBound);
      Calendar dateLowerBound = Calendar.getInstance();
      dateLowerBound.add(Calendar.YEAR,-ageUpperBound);

      try{
         qry = "select t.label,scan_id,pi_id,ursi,"
              + "study_dir_name,i.hrrc_num,scan_label,"
              + "c.model,segment_interval,scan_date, "
              + "t.sort_order "
              + "from mrs_scan_sessions_vw i "
              + "inner join mrs_studies_vw s "
              + "on i.hrrc_num = s.hrrc_num "
              + "inner join mrs_scanners_vw c "
              + "on c.scanner_id = i.scanner_id "
              + "inner join mrs_series_vw t "
              + "on t.scan_id = i.scan_id "
              + "inner join mrs_subject_details_vw p "
              + "on p.ursi = i.ursi "
              + "where study_dir_name is not null "
              + "and (t.usable = '1' or t.usable='Y') "
              + "and i.study_id = p.study_id "
              + "and p.birth_date >= to_date('"
                  +dateLowerBound.get(Calendar.DAY_OF_YEAR)+","
                  +dateLowerBound.get(Calendar.YEAR)+"','DDD,YYYY') "
              + "and p.birth_date <= to_date('"
                  +dateUpperBound.get(Calendar.DAY_OF_YEAR)+","
                  +dateUpperBound.get(Calendar.YEAR)+"','DDD,YYYY') ";

         if(analysis != null)
            qry += "and t.label like '"+analysis+"%' ";
         if(studyNumber != null)
            qry += "and i.hrrc_num='"+studyNumber+"' ";
         if(subjectType != null)
            qry += "and p.type_label = '"+subjectType+"' ";
         if(gender != null)
            qry += "and p.gender = '"+gender.toUpperCase()+"' ";

         qry += "order by ursi,sort_order desc ";

         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         //result.add(new Series(qry,0,0,qry,qry,qry,qry,qry,qry,qry,null));
         Series previous = new Series(null,0,0,null,null,null,null,null,null,null,null);
         Series current = previous; 
         while(rs.next()){ 
            current = new Series
                      (rs.getString(1),rs.getInt(11),rs.getInt(2),
                       rs.getString(3),rs.getString(4),
                       rs.getString(5),rs.getString(6),rs.getString(7),
                       rs.getString(8),rs.getString(9),rs.getDate(10));
            if(current.scanID != previous.scanID
               || current.seriesLabel != previous.seriesLabel ){
               result.add(current);
               previous = current;
            }
         }
         return result;
      } catch(SQLException e){
         List<Series> error = new Vector<Series>();
         //error.add(new Series(null,0,0,null,null,qry,null,null,null,null,null));
         return error;
      } finally{
         try{ 
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ 
            List<Series> error = new Vector<Series>();
            //error.add(new Series(null,0,0,null,null,qry,null,null,null,null,null));
            return error;
         }
      }
   }
   public String getStudyPI(String studyNumber){
      Connection connection = getConnection();
      Statement stmt = null;
      try{
         String qry = "select pi_id "
                    + "from mrs_studies_vw "
                    + "where hrrc_num='"+studyNumber+"'";
         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         if(!rs.next()) return ""; // doesn't exist
         return rs.getString(1);
      } catch(SQLException e){
         e.printStackTrace();
         return "";
      } finally{
         try{ 
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ return ""; }
      }
   }
   public int getStudyID(String study){
      Connection connection = getConnection();
      Statement stmt = null;
      try{
         String qry = "select study_id "
                    + "from mrs_studies_vw "
                    + "where label='"+study+"'";
         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         if(!rs.next()) return -1; // doesn't exist

         return rs.getInt(1);
      } catch(SQLException e){
         e.printStackTrace();
         return -1;
      } finally{
         try{ 
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ return -1; }
      }
   }
   public boolean existsSubjectInStudy(String ursi,int studyID){
      Connection connection = getConnection();
      Statement stmt = null;
      try{
         String qry = "select * "
                    + "from mrs_subject_details_active_vw "
                    + "where ursi='"+ursi+"'"
                    + "and study_id="+studyID;
         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         return rs.next() ? true:false;
      } catch(SQLException e){
         e.printStackTrace();
         return false;
      } finally{
         try{ 
            if(stmt!=null) stmt.close();
            connection.close(); 
         }
         catch(SQLException e){ return false; }
      }
   }
   /**
    * @return the subject_type_id of the ursi for the
    *         given study, if it exists, -1 if it doesn't,
    *         and other negative values in the event of
    *         and exception.
    */
   public int getSubjectTypeID(String ursi, int studyID){
      Connection connection = getConnection();
      Statement stmt = null;
      String qry = null;
      try{
         qry = "select subject_type_id "
                    + "from mrs_subject_details_active_vw "
                    + "where study_id="+studyID
                    + " and ursi='"+ursi+"'";
         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         if(!rs.next()) return -1; // doesn't exist

         return rs.getInt(1);
      } catch(SQLException e){
         e.printStackTrace();
         return -2;
      } finally{
         try{ 
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ return -3; }
      }
   }
   public String getVisitID(String visit,
                            int studyID,
                            String ursi){
      Connection connection = getConnection();
      int subjectTypeID = getSubjectTypeID(ursi,studyID);
      if(subjectTypeID < 0) return null;

      Statement stmt = null;
      String qry = null;
      try{

         qry = "select unique t.segment_interval "
                    + "from mrs_study_intervals_vw i "
                    + "inner join mrs_subject_type_inst_vw t "
                    + "on t.segment_interval = i.segment_interval "
                    + "where label='"+visit+"'"
                    + " and subject_type_id="+subjectTypeID
                    + " and study_id="+studyID;
         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         if(!rs.next()) return null; // doesn't exist

         return rs.getString(1);
      } catch(SQLException e){
         e.printStackTrace();
         return null;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ return null; }
      }
   }
   public int getProcessID(String ursi,
                           int studyID,
                           String visitID,
                           int pipelineID){
      Connection connection = getConnection();
      Statement stmt = null;
      String qry = null;
      try{
         qry = "select process_id "
                    + "from mrs_processes_vw "
                    + "where ursi='"+ursi+"'"
                    + " and study_id="+studyID
                    + " and segment_interval='"+visitID+"'"
                    + " and pipeline_id="+pipelineID
                    + " order by instance desc";
         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         if(!rs.next()) return -1; // doesn't exist

         return rs.getInt(1);
      } catch(SQLException e){
         e.printStackTrace();
         return -1;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ return -1; }
      }
   }
   public int createProcess(String ursi,
                            int studyID,
                            String visitID,
                            int pipelineID){
      Connection connection = getConnection();
      Statement stmt = null;
      String qry = null;
      ResultSet rs = null;

      int processID = getProcessID(ursi,studyID,visitID,pipelineID);
      int instance = 1;
      try{
         stmt = connection.createStatement();

         if(processID  != -1){
            // get instance from process.
            qry = "select instance "
                + "from mrs_processes_vw "
                + "where process_id="+processID
                + " order by process_id desc";

            
            rs = stmt.executeQuery(qry);
            if(!rs.next()) return -1; //error!
            instance = 1 + rs.getInt(1);
         }
         qry = "insert into mrsdba.mrs_processes "
                     +"(process_id,segment_interval,ursi,instance,"
                     +" pipeline_id,notes,study_id)"
                     +"values "
                     +"(mrs_process_counter.nextval,"
                     +" '"+visitID+"',"
                     +" '"+ursi+"',"
                     +instance+","
                     +pipelineID+","
                     +"null,"
                     +studyID+")";
                     
         stmt.executeUpdate(qry);
         connection.commit();

         qry = "select mrs_process_counter.currval "
              +" from dual";
         rs = stmt.executeQuery(qry);
         if(!rs.next()) return -1; // error!

         return rs.getInt(1);
      } catch(SQLException e){
         e.printStackTrace();
         return -1;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ return -1; }
      }
   }
   public int createProcessStep(ProcessStep ps,
                                int processID,
                                String pipeline,
                                int pipelineSegment){
      Connection connection = getConnection();
      PreparedStatement stmt = null;
      String qry = null;
      try{
         qry = "insert into mrsdba.mrs_process_steps "
                     +"(pr_step_id,process_id,pipe_seg_id,"
                     +" software,cpu_host,cpu_env,user_name,"
                     +" start_timedate,end_timedate,notes)"
                     +"values "
                     +"(mrs_process_step_counter.nextval,"
                     +" "+processID+","
                     +" "+pipelineSegment+","
                     +" '"+pipeline+"',"
                     +" '"+ps.getHostName()+"',"
                     +" '"+ps.getArchitecture()+"',"
                     +" '"+ps.getUser()+"',"
                     +" ?,?,"
                     +" "+null+")";
                     
         stmt = connection.prepareStatement(qry);
         java.sql.Date date = new java.sql.Date
                               (Long.parseLong(ps.getTimeStamp()));
         stmt.setDate(1,date);
         stmt.setDate(2,date);
         stmt.executeUpdate();
         connection.commit();

         stmt = connection.prepareStatement
                  ("select mrs_process_step_counter.currval "
                  +" from dual");
         ResultSet rs = stmt.executeQuery();
         if(!rs.next()) return -1; // doesn't exist
         return rs.getInt(1);
      } catch(SQLException e){
         return -1;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ return -1; }
      }
   }
   public List getValidVisits(String ursi,int studyID){
      Connection connection = getConnection();
      Vector acc = new Vector();
      String qry = null;
      Statement stmt = null;
      try{
         qry = "select unique label "
               + "from mrs_study_intervals_vw i "
               + "inner join mrs_subject_type_inst_vw s "
               + "on i.segment_interval = s.segment_interval "
               + "where subject_type_id="
                  + getSubjectTypeID(ursi,studyID) 
               + " and study_id="+studyID;

         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         while(rs.next() == true){
            acc.add(rs.getString(1));
         }

         return acc;
      } catch(SQLException e){
         e.printStackTrace();
         acc.add(e.getMessage()+"\n"+qry);
         return acc;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ //return acc; }
            acc.add(e.getMessage()+"\n"+qry);
            return acc;
         }
      }
   }
   public List getValidPipelines(){
      Connection connection = getConnection();
      Vector acc = new Vector();
      Statement stmt = null;
      try{
         String qry = "select unique label "
                    + "from mrs_pipelines_vw";

         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         while(rs.next()){
            acc.add(rs.getString(1));
         }

         return acc;
      } catch(SQLException e){
         e.printStackTrace();
         return acc;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ return acc; }
      }
   }
   public List<Question> getInstrumentQuestions(int instrumentID){
      Connection connection = getConnection();
      final List<Question> result = new Vector<Question>();
      Statement stmt = null;
      String qry = null;
      
      try{
         qry = "select question_id,label "
              +"from mrs_inst_questions_vw,"
                   +"mrs_inst_section_details_vw "
              +"where mrs_inst_questions_vw.section_id "
                 +"= mrs_inst_section_details_vw.section_id "
              +"and instrument_id = "+instrumentID;

         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         //result.add(new Question("Test",qry));
         while(rs.next()){ 
            result.add(new Question(rs.getString(1),rs.getString(2)));
         }
         return result;
      } catch(SQLException e){
         List<Question> error = new Vector<Question>();
         error.add(new Question("Error",qry));
         return error;
      } finally{
         try{ 
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ 
            List<Question> error = new Vector<Question>();
            error.add(new Question("Error",qry));
            return error;
         }
      }
   }
   public List<Study> getStudies(){
      Connection connection = getConnection();
      Statement stmt = null;
      String qry = null;
      List<Study> result = new Vector<Study>();
      try{
         qry = "select s.study_id,s.label,s.description,s.pi_id,s.hrrc_num,"
		+ "s.irb_number,s.recruitment_study_purpose,"
		+ "s.recruitment_protocol_summary,s.recruitment_eligibility_crit,"
		+ "s.recruitment_contact_name,s.recruitment_contact_email,"
		+ "s.recruitment_contact_phone" 
		+" from mrsdba.mrs_studies_vw s "
		+" where add_to_recruitment='Y' "
		+" and site_id='7' "
		+" and expiration_date > now()";


         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         //result.add(new Question("Test",qry));
         while(rs.next()){ 
            result.add(new Study(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
         }
         return result;
      } catch(SQLException e){
         List<Study> error = new Vector<Study>();
         return error;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ 
            List<Study> error = new Vector<Study>();
            return error;
         }
      }
      
   }
   public List<RecruitmentStudy> getRecruitmentStudies(){
      Connection connection = getConnection();
      Statement stmt = null;
      String qry = null;
      List<RecruitmentStudy> result = new Vector<RecruitmentStudy>();
      try{
         qry = "select s.irb_number,"
		+ "s.recruitment_study_purpose,"
		+ "s.recruitment_protocol_summary,s.recruitment_eligibility_crit,"
		+ "s.recruitment_contact_name,s.recruitment_contact_email,"
		+ "s.recruitment_contact_phone" 
		+" from mrsdba.mrs_studies_vw s "
		+" where add_to_recruitment='Y' "
		+" and expiration_date > now()";

         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         //result.add(new Question("Test",qry));
         while(rs.next()){ 
            result.add(new RecruitmentStudy(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
         }
         return result;
      } catch(SQLException e){
         List<RecruitmentStudy> error = new Vector<RecruitmentStudy>();
         return error;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ 
            List<RecruitmentStudy> error = new Vector<RecruitmentStudy>();
            return error;
         }
      }
      
   }
   public List<Study> getStudiesWithInstruments(){
      Connection connection = getConnection();
      Statement stmt = null;
      String qry = null;
      List<Study> result = new Vector<Study>();
      try{
         qry = "select unique s.study_id,s.label "
              +"from mrsdba.mrs_studies_vw s "
              +"inner join mrsdba.mrs_inst_studies_vw i "
              +"on s.study_id = i.study_id "
              +"where s.expiration_date is null "
              +"or s.expiration_date > sysdate";

         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         //result.add(new Question("Test",qry));
         while(rs.next()){ 
            result.add(new Study(rs.getInt(1),rs.getString(2)));
         }
         return result;
      } catch(SQLException e){
         List<Study> error = new Vector<Study>();
         return error;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ 
            List<Study> error = new Vector<Study>();
            return error;
         }
      }
   }
   public List<Instrument> getStudyInstruments(int studyID){
      Connection connection = getConnection();
      Statement stmt = null;
      String qry = null;
      List<Instrument> result = new Vector<Instrument>();
      try{
         qry = "select instrument_id,label,description "
              +"from mrs_inst_studies_vw where study_id = "
              +studyID;

         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         //result.add(new Question("Test",qry));
         while(rs.next()){ 
            result.add(new Instrument(rs.getInt(1),
                                      rs.getString(2),
                                      rs.getString(3)));
         }
         return result;
      } catch(SQLException e){
         List<Instrument> error = new Vector<Instrument>();
         return error;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ 
            List<Instrument> error = new Vector<Instrument>();
            return error;
         }
      }
   }
   public List<Integer> getWorklist(int siteID,String[] excludePIs){
      Connection connection = getConnection();
      Statement stmt = null;
      String qry = null;
      List<Integer> result = new Vector<Integer>();
      try{
         qry = "select session_scan_id "
              +" from mrsdba.mrs_scan_sessions_review_vw r "
              +" inner join mrsdba.mrs_studies_vw s "
              +"  on s.study_id = r.study_id "
              +" where review_scan_id is null "
              +" and r.site_id = '"+siteID+"' ";

         for(String pi : excludePIs){
            qry += " and s.pi_id != '"+pi+"'";
         }

         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         while(rs.next()){ 
            result.add(rs.getInt(1));
         }
         return result;
      } catch(SQLException e){
         List<Integer> error = new Vector<Integer>();
         return error;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ 
            List<Integer> error = new Vector<Integer>();
            return error;
         }
      }
   }
   public String getScanSessionLocation(int scanID){

      Connection connection = getConnection();
      String path = new String();
      Statement stmt = null;

      String qry = "select"
		    +" series.series_id, "
		    +" '/human/dicom', "
		    +" lower(scanner.model) as devicedirectory, "
		    +" scansession.PI_DIR_NAME as pidirectory, "
		    +" scansession.STUDY_DIR_NAME as studydirectory, "
		    +" REPLACE(study.hrrc_num, '-', '') as irbnum, "
		    +" scansession.ursi subjectdirectory,   "
		    +" scansession.scan_label as scandirectory, "
		    +" series.label as protocoldirectory, "
		    +" to_char(series.sort_order, '0000') as run, "
	+" scansession.notes "
		+" from  "
		    +" mrsdba.mrs_studies_vw study, "
		    +" mrsdba.mrs_all_scanners_vw scanner, "
		    +" mrsdba.mrs_scan_sessions_vw scansession "
		     +" left outer join  mrsdba.mrs_series_vw series "
		     +" on series.scan_id = scansession.scan_id "
		+" where "
		    +" study.study_id = scansession.study_id "
		    +" and "
		    +" scanner.scanner_id = scansession.scanner_id "
                   +" and scansession.scan_id = "+scanID
                   +" order by run ";

      try{
         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         if(!rs.next()) return "The path couldn't be built.";

         // 3T study
         path = "/"+rs.getString("devicedirectory")+"/"
                   +rs.getString("pidirectory")+"/"
                   +rs.getString("studydirectory")+"/"
                   +rs.getString("subjectdirectory")+"/"
                   +rs.getString("scandirectory");

         return path;

      } catch(SQLException e){
         return "error making query: "+e.getMessage();
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ 
            return "error closing connection: "+e.getMessage();
         }
      }
   }
   public String addToRadiologistQueue(int scanID){
      Connection connection = getConnection();
      CallableStatement stmt = null;
      String qry = null;
      try{
         qry = "{?=call mrs_add_scan_for_review_f(?)}";
         stmt = connection.prepareCall(qry);
         stmt.registerOutParameter(1,java.sql.Types.VARCHAR);
         stmt.setInt(2,scanID);
         stmt.execute();
         connection.commit(); 
         int result = stmt.getInt(1);
         if(result == 1) return "Scan "+scanID+" successfully added.";
         else if(result == 2) return "Scan "+scanID+" is already in queue.";
         else return "Failed to add scan "+scanID+" to queue.";
      } catch(SQLException e){ return "Failed to add scan "+scanID+" to queue."; } 
      finally{
         try{ 
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ return "Failed to add scan "+scanID+" to queue."; }
      }
   }
   public List<Study> getSubjectEnrollment(String ursi){
      Connection connection = getConnection();
      Statement stmt = null;
      String qry = null;
      List<Study> result = new Vector<Study>();
      try{
			qry = "select "
             +" sub.study_id, sub.study_label, "
				 +" study.hrrc_num "
				 +" from "
				 +" mrs_subject_details_active_vw sub, "
				 +" mrs_studies_vw study "
			    +" where "
             +"  sub.study_id = study.study_id "
             +" and "
             +"  sub.ursi = '" + ursi + "'";

         stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(qry);

         while(rs.next()){ 
            result.add(new Study(rs.getInt("study_id"),
                                 rs.getString("study_label"),
                                 rs.getString("hrrc_num")));
         }
         return result;
      } catch(SQLException e){
         List<Study> error = new Vector<Study>();
         return error;
      } finally{
         try{
            if(stmt!=null) stmt.close(); 
            connection.close(); 
         }
         catch(SQLException e){ 
            List<Study> error = new Vector<Study>();
            return error;
         }
      }
   }
}
