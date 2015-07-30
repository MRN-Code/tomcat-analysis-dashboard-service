package dbutils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

class VBMHandler implements PipelineHandler{
   public String handleData
                (InputStream data,String label,
                 String ursi, int studyID,
                 String visitID, int processStepID){
      BufferedReader in = new BufferedReader
                              (new InputStreamReader(data));
      double value;
      try{
         value = Double.parseDouble(in.readLine());
      } catch(NumberFormatException e){
         return "Improperly formatted VBM file:"+e.getMessage();
      }
      catch(IOException e){
         return "Error reading VBM file: "+e.getMessage();
      }
      return ""+value;
   }
}
