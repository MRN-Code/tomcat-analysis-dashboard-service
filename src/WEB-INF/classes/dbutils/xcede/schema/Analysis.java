package dbutils.xcede.schema;

import java.util.ArrayList;
import java.util.List;

public class Analysis{
   private String ID;
   private String type;
   private String projectID;
   private String subjectID;
   private String visitID;
   private String studyID;
   private String episodeID;
   private List inputs = new ArrayList();
   private List outputs = new ArrayList();
   private Provenance provenance;
    

   public Analysis(){}

   public void setID(String ID){ this.ID = ID; }
   public void setType(String type){ this.type = type; }
   public void setProjectID(String projectID){ this.projectID = projectID; }
   public void setSubjectID(String subjectID){ this.subjectID = subjectID; }
   public void setVisitID(String visitID){ this.visitID = visitID; }
   public void setStudyID(String studyID){ this.studyID = studyID; }
   public void setEpisodeID(String episodeID){ this.episodeID = episodeID; }

   public void setProvenance(Provenance provenance){ 
      this.provenance = provenance; }

   public void addInput(Input input){ this.inputs.add(input); }
   public void addOutput(Output output){ this.outputs.add(output); }
    
   public String getID(){ return this.ID; }
   public String getType(){ return this.type; }
   public String getProjectID(){ return this.projectID; }
   public String getSubjectID(){ return this.subjectID; }
   public String getVisitID(){ return this.visitID; }
   public String getStudyID(){ return this.studyID; }
   public String getEpisodeID(){ return this.episodeID; }

   public Provenance getProvenance(){ return this.provenance; }

   public List getInputs(){ return this.inputs; }
   public List getOutputs(){ return this.outputs; }
}
