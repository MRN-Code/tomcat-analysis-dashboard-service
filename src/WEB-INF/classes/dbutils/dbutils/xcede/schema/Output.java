package dbutils.xcede.schema;

public class Output{
   private String analysisID;
   private String analysisURI;

   public Output(){}

   public String getAnalysisID(){ return analysisID; }
   public String getAnalysisURI(){ return analysisURI; }

   public void setAnalysisID(String analysisID){ 
      this.analysisID = analysisID; 
   }
   public void setAnalysisURI(String analysisURI){
      this.analysisURI = analysisURI; 
   }
}
