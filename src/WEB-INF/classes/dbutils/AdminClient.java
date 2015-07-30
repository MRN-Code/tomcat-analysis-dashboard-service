import java.security.Security;

public class AdminClient{
   public static void main(String[] args){
         System.setProperty("javax.net.ssl.trustStore","/home/wcourtney/studies/.keystore");
         System.setProperty("java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol");
         Security.addProvider( new com.sun.net.ssl.internal.ssl.Provider());

         org.apache.axis.client.AdminClient.main(args);

   }
}
