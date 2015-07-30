package dbutils.xcede.schema;

public class ProcessStep{
   private String program;
   private String programArguments;
   private String timeStamp;
   private String user;
   private String hostName;
   private String architecture;
   private String platform;
   private String cvs;
   private String pkg;

   public ProcessStep(){}

   public String getProgram(){ return program; }
   public String getProgramArguments(){ return programArguments; }
   public String getTimeStamp(){ return timeStamp; }
   public String getUser(){ return user; }
   public String getHostName(){ return hostName; }
   public String getArchitecture(){ return architecture; }
   public String getPlatform(){ return platform; }
   public String getCvs(){ return cvs; }
   public String getPackage(){ return pkg; }

   public void setProgram(String program){ this.program = program; }
   public void setProgramArguments(String programArguments){ this.programArguments = programArguments; }
   public void setTimeStamp(String timeStamp){ this.timeStamp = timeStamp; }
   public void setUser(String user){ this.user = user; }
   public void setHostName(String hostName){ this.hostName = hostName; }
   public void setArchitecture(String architecture){ this.architecture = architecture; }
   public void setPlatform(String platform){ this.platform = platform; }
   public void setCvs(String cvs){ this.cvs = cvs; }
   public void setPackage(String pkg){ this.pkg = pkg; }
}
