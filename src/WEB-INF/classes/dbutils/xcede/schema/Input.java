package dbutils.xcede.schema;

public class Input{
   private String projectID;
   private String subjectID;
   private String visitID;
   private String studyID;
   private String episodeID;
   private String acquisitionID;

   public Input(){}

   public String getProjectID(){ return projectID; }
   public String getSubjectID(){ return subjectID; }
   public String getVisitID(){ return visitID; }
   public String getStudyID(){ return studyID; }
   public String getEpisodeID(){ return episodeID; }
   public String getAcquisitionID(){ return acquisitionID; }

   public void setProjectID(String projectID){ this.projectID = projectID; }
   public void setSubjectID(String subjectID){ this.subjectID = subjectID; }
   public void setVisitID(String visitID){ this.visitID = visitID; }
   public void setStudyID(String studyID){ this.studyID = studyID; }
   public void setEpisodeID(String episodeID){ this.episodeID = episodeID; }
   public void setAcquisitionID(String acquisitionID){ 
      this.acquisitionID = acquisitionID; }
}
