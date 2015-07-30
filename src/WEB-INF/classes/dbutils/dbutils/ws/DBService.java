/**
 * DBService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package dbutils.ws;

public interface DBService extends java.rmi.Remote {
    public java.lang.String[] getStudies() throws java.rmi.RemoteException;
    public java.lang.String[] getRecruitmentStudies() throws java.rmi.RemoteException;
    public java.lang.String[] getRadiologistWorklistPaths(java.lang.String[] in0) throws java.rmi.RemoteException;
}
