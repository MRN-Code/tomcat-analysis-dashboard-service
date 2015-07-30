package dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Blob;

import oracle.sql.BLOB;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

class BlobHandler{
   public String addSnapshot(String label,String ursi,
                             int studyID,String segint,
                             int processStepID,
                             InputStream in){
      Connection connection;

      String query = "from mrs_snapshots_vw "+
                     "where label='"+label+"'"+
                     " and ursi='"+ursi+"'"+
                     " and study_id="+studyID+""+
                     " and segment_interval='"+segint+"'"+
                     " and process_step_id="+processStepID;

      String insert = "insert into mrsdba.mrs_snapshots"
                     +"(id,label,image,ursi,study_id,"
                     + "segment_interval,"
                     + "process_step_id) "
                     +"values("
                     +"mrsdba.snapshot_counter.nextVal,"
                     +"'"+label+"',"
                     +"empty_blob(),"
                     +"'"+ursi+"',"
                     + studyID+","
                     +"'"+segint+"',"
                     + processStepID+")";
      try{
         connection = DBHandler.getConnection();

         //get old blob
         connection.setAutoCommit(false);
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery("select * "+query);

         if(rs.next()) //already exists
            return label+" is already entered!";//false;

         stmt.executeUpdate(insert);
         stmt.close();
         connection.commit();
         connection.close();
                     
      } catch(Exception e){
         e.printStackTrace();
         return "Exception: "+e.getMessage()+'\n'
                + query + "\n" + insert + "\n"; //false;
      }
       return appendBlob(query,in);
                  
      //return true;
   }
   private String appendBlob(String select,InputStream in){
      String ret = "";
      Connection connection;
      try{
         connection = DBHandler.getConnection();

         //get old blob
         connection.setAutoCommit(false);
         Statement stmt = connection.createStatement();
         String query = "select image "+select+" for update";

               /*        "select image "
                       +"from mrsdba.mrs_snapshots "
                       +"where id="+id
                       +" for update"; 
               */
         ret += "query: "+query+"\n";
         ResultSet rs = stmt.executeQuery(query);
         Blob blob = null;
         if(rs.next()){
            blob = rs.getBlob(1);
         }
         else return ret+"can't find...";
         BLOB oblob = (BLOB)blob; 
         //append to the end of the blob
         OutputStream out = 
            oblob.getBinaryOutputStream(oblob.length()+1);
      
         //prepare file data

         int length = -1;
         long wrote = 0;
         int chunkSize = oblob.getChunkSize();
         byte[] buf = new byte[chunkSize];
         while ((length = in.read(buf)) != -1) {
             out.write(buf, 0, length);
             wrote += length;
         }

         out.close();
         in.close();
         stmt.close();
         connection.commit();


      } catch(Exception e){
         System.out.println("ohno: "+e.getMessage());
         e.printStackTrace();
         return "exception "+e.getMessage();
      }
      return "finished:\n"+ret;
   }
}
