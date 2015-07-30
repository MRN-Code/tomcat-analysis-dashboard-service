/**
 * DBServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package dbutils.ws;

public interface DBServiceService extends javax.xml.rpc.Service {
    public java.lang.String getdbutilsAddress();

    public dbutils.ws.DBService getdbutils() throws javax.xml.rpc.ServiceException;

    public dbutils.ws.DBService getdbutils(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
