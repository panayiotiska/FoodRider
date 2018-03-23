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
	
	public Statistics() throws IOException, ExceptionInInitializerError {
		
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
	
	public int getN(){
		return n;
	}
	
	public double getMean() throws ExceptionInInitializerError{
		return mean;
	}
	
	public double getVariance() throws ExceptionInInitializerError{
		return variance;
	}

	public ImageIcon getBarplot() throws ExceptionInInitializerError{
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

	private double calcMean() throws ExceptionInInitializerError{
		
		/* The method calculates the average of orders. ( sum(frequency*centralValues)/n ) */
	
		// Value to be returned (mean)
		double mean=0;
		
		// Calculating Central Values
		ArrayList<Double> centralValues = calcCentralValues(interv);
		
		// Calculation
		for(int i=0;i<centralValues.size();i++)
			mean += centralValues.get(i)*freq.get(i);
		mean /= n;
		
		return mean;

	}
	
	private double calcVariance() throws ExceptionInInitializerError{
		
		/* The method calculates the variance of orders. ( sum((central.values-mean)^2*frequency)/(sum(frequency)-1) ) */
	
		// Value to be returned (mean)
		double variance=0;
		
		// We use mean to calculate variance
		double mean = getMean();
		
		// Calculating Central Values
		ArrayList<Double> centralValues = calcCentralValues(interv);
		
		// Calculating
		for(int i=0;i<centralValues.size();i++)
			variance += (centralValues.get(i)-mean)*(centralValues.get(i)-mean)*freq.get(i);
		variance /= getN()-1;
		
		return variance;
				
	}
	
	private ImageIcon drawPlot() throws IOException, ExceptionInInitializerError{
		
		/* This method creates & returns barplot. */
		
		// A RCaller object for each method, so we do not have a problem with the threads
		RCaller caller = RCaller.create();
		
		// A RCode object for each method, so we do not have a problem with the threads
		RCode code = RCode.create();
		
		// Labels that describe how long each observation (frequency)
		String[] names = getNames(interv);
		
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
	
	private ArrayList<Double> calcCentralValues(ArrayList<Integer> interv) throws ExceptionInInitializerError{
		
		/* This method calculates & returns central values of given interval. */
		
		// Table with the center values ​​of each interval (to calculate mean, variance)
		ArrayList<Double> values = new ArrayList<>();
		
		// Used in calculation;
		double tmp;
		
		// Calculation
		for(int i=0;i<interv.size()-1;i++){ 
			tmp = interv.get(i) + interv.get(i+1);
			tmp /= 2;
			values.add(tmp); 
		}
		
		return values;		
		
	}
	
	private String[] getNames(ArrayList<Integer> interv){
		
		/* This method gets interval as arraylist and returns it as string array for barplot's labels. */
		
		String[] names = new String[interv.size()-1];
		
		// Calculation
		for(int i=0;i<interval.length-1;i++)
			names[i] = interv.get(i) + ":00 - " + interv.get(i+1) + ":00";
		
		return names;
	
	}

}