package Statistics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.ImageIcon;

import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;

public class Statistics {
	
	private int n;
	
	private double mean;
	
	private double variance;
	
	private ImageIcon barplot;
	
	private ArrayList<Integer> freq; // Temp, argument in class
	
	private ArrayList<Integer> interv; // Temp, argument in class
	
	private int[] frequency;
	
	private int[] interval;
	
	public Statistics() throws IOException {
		
		this.interv = new ArrayList<>(Arrays.asList(24,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23));
		
		this.freq = new ArrayList<>(Arrays.asList(4,5,10,30,10,20,23,25,27,21,3,45,78,23,12,45,23,12,34,23,1,2,34));
			
		// Convert from ArrayList to a table, so we can pass the data to R
		this.frequency = convertListToArray(freq);
		
		// Convert from ArrayList to a table, so we can pass the data to R
		this.interval = convertListToArray(interv);
		
		// Calculation of n (sum of all frequencies)
		this.n = calcN();
		
		// Calculation of mean (average of orders)
		this.mean = calcMean();
		
		// Calculation of variance
		this.variance = calcVariance();
		
		// Creation of barplot
		this.barplot = drawPlot();
		
	}
	
	
	/* Public Methods */
	
	public int getN() {
		return n;
	}
	
	public double getMean() {
		return mean;
	}
	
	public double getVariance() {
		return variance;
	}

	public ImageIcon getBarplot() {
		return barplot;
	}
	
	/* Private Methods */
	
private int[] convertListToArray(ArrayList<Integer> list) {
		
		/* This method converts an int-type ArrayList into an int table */
		
		int[] array = new int[list.size()];
		
		for(int i=0;i<list.size();i++)
			array[i] = list.get(i);
		
		return array;
		
	}
	
	private int calcN() {
		
		/* 
		 * This method calculates n, which at time intervals equals
		 * the sum of all frequencies.
		 */
		
		int n=0;
		
		for(int i=0;i<freq.size();i++)
			n += freq.get(i);
		
		return n;
		
	}

	private double calcMean() {
		
		/* The method calculates the average of orders. ( sum(frequency*centralValues)/n ) */
		
		// A RCaller object for each method, so we do not have a problem with the threads
		RCaller caller = RCaller.create();
				
		// A RCode object for each method, so we do not have a problem with the threads
		RCode code = RCode.create();
	
		// Value to be returned (mean)
		double mean;
		
		// Calculating Central Values
		double[] centralValues = calcCentralValues(interval);
		
		// frequency table will be recognized as freq in R
		code.addIntArray("freq", frequency);
		
		// interval table will be recognized as interv in R
		code.addIntArray("interv", interval);	
		
		// centralValues table will be recognized as values in R
		code.addDoubleArray("values", centralValues);
				
		// We pass n to R, calculated by calcMean()
		code.addInt("n", n);

		// Mean calculation inside R	
		code.addRCode("mean <- sum(values*freq)/n");
				
		// Parsing object code
		caller.setRCode(code);

		// Executing R code
		caller.runAndReturnResult("mean");
		
		/* 
		 * Parser always returns the results to a table. But since we know we will only have
		 * an element (mean) we only get the 1st position of the table created and we
		 * assign it to mean variable.
		 */
		mean = caller.getParser().getAsDoubleArray("mean")[0];
		
		return mean;            

	}
	
	private double calcVariance() {
		
		/* The method calculates the variance of orders. ( sum((central.values-mean)^2*frequency)/(sum(frequency)-1) ) */
		
		// A RCaller object for each method, so we do not have a problem with the threads
		RCaller caller = RCaller.create();
				
		// A RCode object for each method, so we do not have a problem with the threads
		RCode code = RCode.create();
	
		// Value to be returned (mean)
		double variance;
		
		// We use mean to calculate variance
		double mean;
		
		// Calculating Central Values
		double[] centralValues = calcCentralValues(interval);
		
		// frequency table will be recognized as freq in R 
		code.addIntArray("freq", frequency);
		
		// interval table will be recognized as interv in R
		code.addIntArray("interv", interval);	
		
		// centralValues table will be recognized as values in R
		code.addDoubleArray("values", centralValues);

		// We use mean to calculate variance	
		mean = this.mean;
		
		// We pass n to R, calculated by calcMean()
		code.addDouble("mean", mean);
		
		// Variance calculation inside R
		code.addRCode("var=format(round(sum((values-mean)^2*freq)/(sum(freq)-1), 2), nsmall = 2)");
		
		// Parsing object code
		caller.setRCode(code);

		// Executing R code
		caller.runAndReturnResult("var");
		
		/* 
		 * Parser always returns the results to a table. But since we know we will only have
		 * an element (var) we only get the 1st position of the table created and we
		 * assign it to variance variable.
		 */
		variance = caller.getParser().getAsDoubleArray("var")[0];
		
		return variance;
				
	}
	
	private ImageIcon drawPlot() throws IOException {
		
		// A RCaller object for each method, so we do not have a problem with the threads
		RCaller caller = RCaller.create();
		
		// A RCode object for each method, so we do not have a problem with the threads
		RCode code = RCode.create();
		
		// Labels that describe how long each observation (frequency)
		String[] names = getNames(interval);
		
		// frequency table will be recognized as freq in R
		code.addIntArray("freq", frequency);
		
		// interval table will be recognized as interv in R
		code.addIntArray("interv", interval);	
		
		// names table will be recognized as names in R
		code.addStringArray("names", names);
		
		// Getting max of frequency table, in order barplot to extend every time frequency max is increasing
		code.addDouble("max", Collections.max(freq));
		
		// Barplot saved in File object
		File plotFile = code.startPlot();
		
		// Executing barplot command in R
		code.addRCode("par(mar=c(3, 7, 5, 1))");
		// xlim = c(0, max+10) -> every time barplot is extending x upper limit to frequency max plus 10
		code.addRCode("barplot(freq, main=\"Order Frequency\", horiz = T, names=names, las=1, col=\"brown\", cex.names=0.8, ylim = c(0, 27), xlim = c(0, max+20))");
		
		// Stop creating the barplot
		code.endPlot();
		
		// Parsing R code
		caller.setRCode(code);
		
		// Executing code
		caller.runOnly();
		// code.showPlot(plotFile); /* Ignore this */
		// Barplot in ImageIcon object (to appear in GUI)
		ImageIcon plot = code.getPlot(plotFile);

		return plot;
		
	}
	
	private double[] calcCentralValues(int[] interval) {
		
		// A RCaller object for each method, so we do not have a problem with the threads
		RCaller caller = RCaller.create();
				
		// A RCode object for each method, so we do not have a problem with the threads
		RCode code = RCode.create();
		
		// Table with the center values ​​of each interval (to calculate mean, variance)
		double[] values = new double[n];
								
		// interval table will be recognized as interv in R
		code.addIntArray("interv", interval);
						
		// values table will be recognized as values in R
		code.addDoubleArray("values", values);
		
		// Calculating central values with R
		code.addRCode("k <- 1\r\n" + 
								"  while(k < length(interv)){\r\n" + 
								"    values[k] <- (interv[k] + interv[k+1])/2\r\n" + 
								"    k <- k + 1\r\n" + 
								"  }");
		
		// Parsing R Code
		caller.setRCode(code);
		
		// Executing Code
		caller.runAndReturnResult("values");
		
		// Get central values
		values = caller.getParser().getAsDoubleArray("values");
		
		return values;		
		
	}
	
	private String[] getNames(int[] interval) {
		
		// A RCaller object for each method, so we do not have a problem with the threads
		RCaller caller = RCaller.create();
						
		// A RCode object for each method, so we do not have a problem with the threads
		RCode code = RCode.create();
		
		String[] names = new String[interval.length-1];
		
		// interval table will be recognized as interv in R
		code.addIntArray("interval", interval);
		
		// names table will be recognized as names in R
		code.addStringArray("names", names);
		
		// Getting names in vector in R
		code.addRCode("k=1\r\n" + 
				"				  while(k<length(interval)){\r\n" + 
				"				    names[k] = paste(as.character(interval[k]), \":00 - \", (as.character(interval[k+1])), \":00\")\r\n" + 
				"				    k=k+1\r\n" + 
				"				  }");
		
		// Parsing R code
		caller.setRCode(code);
		
		// Executing R code
		caller.runAndReturnResult("names");
		
		// Getting names
		names = caller.getParser().getAsStringArray("names");
		
		return names;
	
	}

}