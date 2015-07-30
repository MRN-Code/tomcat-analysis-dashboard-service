/**
 * DbutilsSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package dbutils.ws;

public class DbutilsSoapBindingSkeleton implements dbutils.ws.DBService, org.apache.axis.wsdl.Skeleton {
    private dbutils.ws.DBService impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("getStudies", _params, new javax.xml.namespace.QName("", "getStudiesReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:dbutils", "ArrayOf_soapenc_string"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:dbutils", "getStudies"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getStudies") == null) {
            _myOperations.put("getStudies", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getStudies")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("getRecruitmentStudies", _params, new javax.xml.namespace.QName("", "getRecruitmentStudiesReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:dbutils", "ArrayOf_soapenc_string"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:dbutils", "getRecruitmentStudies"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getRecruitmentStudies") == null) {
            _myOperations.put("getRecruitmentStudies", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getRecruitmentStudies")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:dbutils", "ArrayOf_soapenc_string"), java.lang.String[].class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getRadiologistWorklistPaths", _params, new javax.xml.namespace.QName("", "getRadiologistWorklistPathsReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:dbutils", "ArrayOf_soapenc_string"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:dbutils", "getRadiologistWorklistPaths"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getRadiologistWorklistPaths") == null) {
            _myOperations.put("getRadiologistWorklistPaths", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getRadiologistWorklistPaths")).add(_oper);
    }

    public DbutilsSoapBindingSkeleton() {
        this.impl = new dbutils.ws.DbutilsSoapBindingImpl();
    }

    public DbutilsSoapBindingSkeleton(dbutils.ws.DBService impl) {
        this.impl = impl;
    }
    public java.lang.String[] getStudies() throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.getStudies();
        return ret;
    }

    public java.lang.String[] getRecruitmentStudies() throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.getRecruitmentStudies();
        return ret;
    }

    public java.lang.String[] getRadiologistWorklistPaths(java.lang.String[] in0) throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.getRadiologistWorklistPaths(in0);
        return ret;
    }

}
