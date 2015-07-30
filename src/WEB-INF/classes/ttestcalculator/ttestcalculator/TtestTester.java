package ttestcalculator;

public class TtestTester 
{
	public static void main(String [] args) throws Exception 
	{		

		// Make a service
		ttestcalculator.ws.TtestCalculatorService service = new ttestcalculator.ws.TtestCalculatorServiceLocator();
		
		// Now use the service to get a stub to the service
		ttestcalculator.ws.TtestCalculator t = service.getttestcalculator();

		double x[] = { 0.0119, 0.3371, 0.1622, 0.7943, 0.3112, 0.5285, 0.1656, 0.6020, 0.2630, 0.6541 };

		/* Sample */
		String outStr = "x = ";
		for (int n = 0; n < x.length; n++)
		{
			outStr = outStr + x[n] + " ";
		}

		System.out.println(outStr);
		System.out.println();
		
		// Make the actual call
		System.out.println("TtestCalculator.ttest() = " + t.ttest(x));	
    }
}