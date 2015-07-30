/**
 * TtestCalculatorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ttestcalculator.ws;

public class TtestCalculatorServiceLocator extends org.apache.axis.client.Service implements ttestcalculator.ws.TtestCalculatorService {

    // Use to get a proxy class for ttestcalculator
    private final java.lang.String ttestcalculator_address = "http://jl/webservices/services/ttestcalculator";

    public java.lang.String getttestcalculatorAddress() {
        return ttestcalculator_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ttestcalculatorWSDDServiceName = "ttestcalculator";

    public java.lang.String getttestcalculatorWSDDServiceName() {
        return ttestcalculatorWSDDServiceName;
    }

    public void setttestcalculatorWSDDServiceName(java.lang.String name) {
        ttestcalculatorWSDDServiceName = name;
    }

    public ttestcalculator.ws.TtestCalculator getttestcalculator() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ttestcalculator_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getttestcalculator(endpoint);
    }

    public ttestcalculator.ws.TtestCalculator getttestcalculator(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ttestcalculator.ws.TtestcalculatorSoapBindingStub _stub = new ttestcalculator.ws.TtestcalculatorSoapBindingStub(portAddress, this);
            _stub.setPortName(getttestcalculatorWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ttestcalculator.ws.TtestCalculator.class.isAssignableFrom(serviceEndpointInterface)) {
                ttestcalculator.ws.TtestcalculatorSoapBindingStub _stub = new ttestcalculator.ws.TtestcalculatorSoapBindingStub(new java.net.URL(ttestcalculator_address), this);
                _stub.setPortName(getttestcalculatorWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("ttestcalculator".equals(inputPortName)) {
            return getttestcalculator();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:ttestcalculator", "TtestCalculatorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("ttestcalculator"));
        }
        return ports.iterator();
    }

}
