/**
 * DbutilsSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package dbutils.ws;

import dbutils.DBServiceImpl;

public class DbutilsSoapBindingImpl implements dbutils.ws.DBService{
   DBServiceImpl dbi = new DBServiceImpl();
   public java.lang.String loadJar(java.lang.String in0, byte[] in1) throws java.rmi.RemoteException {
       return dbi.loadJar(in0,in1);
   }

   public java.lang.String postSnapshots(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
       return dbi.postSnapshots(in0,in1);
   }

   public java.lang.String postVBM(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
        return dbi.postVBM(in0,in1);
   }
}
