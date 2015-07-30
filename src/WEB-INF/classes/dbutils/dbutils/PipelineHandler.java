package dbutils;

import java.io.InputStream;

interface PipelineHandler{
   public String handleData
                (InputStream data,String label,
                 String ursi, int studyID,
                 String visitID, int processStepID);
}
