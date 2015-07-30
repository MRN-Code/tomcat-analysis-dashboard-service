/**
 * DbutilsSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package dbutils.ws;

import dbutils.DBServiceImpl;

public class DbutilsSoapBindingImpl implements dbutils.ws.DBService{
    DBServiceImpl db = new DBServiceImpl();

/*
    public java.lang.String loadJar(java.lang.String in0, byte[] in1) throws java.rmi.RemoteException {
        return db.loadJar(in0,in1);
    }

    public java.lang.String postSnapshots(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
        return db.postSnapshots(in0,in1);
    }

    public java.lang.String postVBM(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
        return db.postVBM(in0,in1);
    }
*/

    public java.lang.String[] getStudies() throws java.rmi.RemoteException {
        return db.getStudies();
    }
 
    public java.lang.String[] getRecruitmentStudies() throws java.rmi.RemoteException {
        return db.getRecruitmentStudies();
    }

    public java.lang.String[] getRadiologistWorklistPaths(java.lang.String[] in0) throws java.rmi.RemoteException {
        return db.getRadiologistWorklistPaths(in0);
    }
/*
    public java.lang.String addToRadiologistQueue(int in0) throws java.rmi.RemoteException {
        return db.addToRadiologistQueue(in0);
    }

    public java.lang.String[] getSubjectEnrollment(java.lang.String in0) throws java.rmi.RemoteException {
        return db.getSubjectEnrollment(in0);
    }
*/
}
