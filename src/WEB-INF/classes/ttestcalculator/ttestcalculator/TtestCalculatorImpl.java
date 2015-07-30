package ttestcalculator;

import java.util.*;

/* T-test calculator */
public class TtestCalculatorImpl implements TtestCalculator
{
	/* Compute sum of sample x */
	public double sum(double[] x)
	{
		double sum_x = 0.0;
		
		for(int i = 0; i < x.length; i++)
		{
			sum_x = sum_x + x[i]; 
		}		
		
		return sum_x;
	}
	/* End for computing sum of sample x */
	
	/* Compute mean of sample x */
	public double mean(double[] x)
	{
		
		double mean_x = 0.0;		
		mean_x = (sum(x)) / (x.length);		
		return mean_x;		
		
	}
	/* End for computing mean of sample */
	
	/* Compute std of sample x */
	public double std(double[] x)
	{
		
		double std_x = 0.0;						
		    
		if (x.length > 1)
		{
			double mean_x = mean(x);
			
			for(int n = 0; n < x.length; n++)
			{
				std_x = std_x + (Math.pow(x[n] - mean_x, 2));
			}
			std_x = Math.sqrt(std_x/(x.length - 1));
		}		
		
		return std_x;	
		
	}
	/* End for computing std of sample */
	
	/* Compute ttest of sample x */
	public double ttest(double[] x)
	{
		double t_value = 0.0;
		
		t_value = mean(x) / (std(x) / Math.sqrt(x.length));
		
		return t_value;
	}
	/*End for computing ttest of sample x */
	
}
/* End for t-test calculator */