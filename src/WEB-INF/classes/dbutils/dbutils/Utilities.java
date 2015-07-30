package dbutils;

// provenance libraries
import dbutils.xcede.schema.Analysis;

// castor libraries
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.mapping.Mapping;
import org.xml.sax.InputSource;

// core libraries
import java.io.FileReader;
import java.io.Reader;

// exceptions:
import java.io.IOException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.mapping.MappingException;

class Utilities{
   /**
    * Creates an absolute path to a temporary file.
    */
   public static String buildFileName(String filename){
      return System.getProperty("catalina.home")+"/temp/"+filename;
   }
   public static void clearTempDir(){
      try{
         Runtime.getRuntime().exec("rm -rf "+buildFileName("*"));
      }
      catch(IOException e){
         System.err.println("Problem clearing temp directory.");
         e.printStackTrace();
      }
   }
   public static Analysis parseXCEDE(Reader in){
      Unmarshaller u = null; 
      Analysis analysis = null;
      Mapping mapping = new Mapping();

      try{
         u = new Unmarshaller(Analysis.class);
         mapping.loadMapping
            (new InputSource
               (ProvenanceHandler.class
                  .getResourceAsStream("xcede/schema/mapping.xml")));
         u.setMapping(mapping);
         analysis = (Analysis)u.unmarshal(in);
         return analysis;
      }
      catch(MappingException e){
         System.out.println("Error: could not use mapping file.\n"
               + e.getMessage());
      }
      catch(MarshalException e){
         e.printStackTrace();
         System.out.println("Error: could not convert xml!\n"
               + e.getMessage());
      }
      catch(ValidationException e){
         System.out.println("Error: problem creating conversion utility!\n"
               + e.getMessage());
      }
      catch(IOException e){
         System.out.println
                  ("Error: problem loading mapping file to convert xml.\n"
                  + e.getMessage()+"\n");
      }
      return null;
   }
}
