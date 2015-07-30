package dbutils.xcede.schema;

import java.util.ArrayList;
import java.util.List;

public class Provenance{
   List processSteps = new ArrayList();

   public Provenance(){}

   public void addProcessStep(ProcessStep ps){
      processSteps.add(ps);
   }
   public List getProcessSteps(){ return processSteps; }
}
