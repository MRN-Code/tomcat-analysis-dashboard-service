package dbutils;

public interface DBService{

/*
   public String loadJar(String jarName,byte[] input);
   public String postSnapshots(String jarName,String recordName);
   public String postVBM(String jarName,String recordName);
*/

   public String[] getStudies();
   public String[] getRecruitmentStudies();
   public String[] getRadiologistWorklistPaths(String[] excludePIs);
}

/*
   public String addToRadiologistQueue(int scanID);
   public String[] getSubjectEnrollment(String ursi);
*/
