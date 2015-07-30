/**
 * A utility to add data to the Snapshots
 * table in the database.
 *
 * @author William Courtney
 */
package dbutils;

import java.io.InputStream;;

class SnapshotHandler implements PipelineHandler{
   public String handleData
                (InputStream data,String label,
                 String ursi, int studyID,
                 String visitID, int processStepID){
      return new BlobHandler().addSnapshot(label,ursi,
                               studyID,visitID,
                               processStepID,data);
   }  
}

