/**
 * TtestcalculatorSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ttestcalculator.ws;

public class TtestcalculatorSoapBindingImpl implements ttestcalculator.ws.TtestCalculator{
	ttestcalculator.TtestCalculatorImpl t = new ttestcalculator.TtestCalculatorImpl();
    public double ttest(double[] in0) throws java.rmi.RemoteException {
        return t.ttest(in0);
    }

}
