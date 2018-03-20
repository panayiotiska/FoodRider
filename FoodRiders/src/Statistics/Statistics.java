package Statistics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;

public class Statistics {
	
	private int n;
	
	private double mean;
	
	private ImageIcon barplot;
	
	private ArrayList<Integer> freq; // Temp, θα περνάει ως όρισμα στην κλάση
	
	private ArrayList<Integer> interv; // Temp, θα περνάει ως όρισμα στην κλάση
	
	private int[] frequency;
	
	private int[] interval;
	
	public Statistics() throws IOException {
		
		this.interv = new ArrayList<>(Arrays.asList(24,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23));
		
		this.freq = new ArrayList<>(Arrays.asList(4,5,10,30,10,20,23,25,27,21,3,45,78,23,12,45,23,12,34,23,1,2,34));
			
		// Μετατροπή από ArrayList σε πίνακα, για να μπορούμε να περάσουμε τα δεδομένα στην R
		this.frequency = convertListToArray(freq);
		
		// Μετατροπή από ArrayList σε πίνακα, για να μπορούμε να περάσουμε τα δεδομένα στην R
		this.interval = convertListToArray(interv);
		
		// Υπολογισμός του n (άθροισμα όλων των συχνοτήτων)
		this.n = calcN();
		
		// Υπολογισμός του μέσου (μέσος όρος παραγγελιών ανά μέρα)
		this.mean = calcMean();
		
		// Δημιουργία του barplot
		this.barplot = drawPlot();
		
	}
	
	
	/* Public Methods */
	
	public int getN() {
		return n;
	}
	
	public double getMean() {
		return mean;
	}

	public ImageIcon getBarplot() {
		return barplot;
	}
	
	/* Private Methods */
	
private int[] convertListToArray(ArrayList<Integer> list) {
		
		/* Η μέθοδος αυτή μετατρέπει ArrayList τύπου int σε πίνακα τύπου int */
		
		int[] array = new int[list.size()];
		
		for(int i=0;i<list.size();i++)
			array[i] = list.get(i);
		
		return array;
		
	}
	
	private int calcN() {
		
		/* 
		 * Η μέθοδος αυτή υπολογίζει το n, το οποίο σε διαστήματα τιμών ισούται με 
		 * το άθροισμα των όλων των συχνοτήτων.
		 */
		
		int n=0;
		
		for(int i=0;i<freq.size();i++)
			n += freq.get(i);
		
		return n;
		
	}

	private double calcMean() {
		
		/* Η μέθοδος υπολογίζει τον μέσο όρο παραγγελιών ανά μέρα. ( sum(frequency*centralValues)/n ) */
		
		// Ένας RCaller για κάθε μέθοδο, για να μην μας εμφανίσει πρόβλημα με τα threads
		RCaller caller = RCaller.create();
				
		// Ένα RCode για κάθε μέθοδο, για να μην μας εμφανίσει πρόβλημα με τα threads
		RCode code = RCode.create();
	
		// Η τιμή που θα επιστραφεί (ο μέσος)
		double mean;
		
		// Υπολογισμός των κεντρικών τιμών
		double[] centralValues = calcCentralValues(interval);
		
		// Ο πίνακας frequency θα αναγνωρίζεται ως freq στην R
		code.addIntArray("freq", frequency);
		
		// Ο πίνακας interval θα αναγνωρίζεται ως interv στην R
		code.addIntArray("interv", interval);	
		
		// Ο πίνακας centralValues θα αναγνωρίζεται ως values στην R
		code.addDoubleArray("values", centralValues);
				
		// Περνάμε το n στην R, το οποίο έχει υπολογιστεί από την calcMean()
		code.addInt("n", n);

		// Υπολογισμός του μέσου στην R		
		code.addRCode("mean <- sum(values*freq)/n");
				
		// Πέρασμα του αντικειμένου του κώδικα R για να κληθεί
		caller.setRCode(code);

		// Εκτέλεση του κώδικα
		caller.runAndReturnResult("mean");
		
		/* 
		 * Ο parser επιστρέφει τα αποτελέσματα πάντα σε πίνακα. Αφού, όμως, ξέρουμε ότι θα έχουμε μόνο
		 * ένα στοιχείο (mean) λαμβάνουμε μόνο την 1η θέση του πίνακα που δημιουργήθηκε και την
		 * εκχωρούμε στο mean.
		 */
		mean = caller.getParser().getAsDoubleArray("mean")[0];
		
		return mean;            

	}
	
	private ImageIcon drawPlot() throws IOException {
		
		// Ένας RCaller για κάθε μέθοδο, για να μην μας εμφανίσει πρόβλημα με τα threads
		RCaller caller = RCaller.create();
		
		// Ένα RCode για κάθε μέθοδο, για να μην μας εμφανίσει πρόβλημα με τα threads
		RCode code = RCode.create();
		
		// Οι ετικέτες που θα περιγράφουν σε ποιο διάστημα αντιστοιχεί κάθε παρατήρηση (συχνότητα)
		String[] names = getNames(interval);
		
		// Ο πίνακας frequency θα αναγνωρίζεται ως freq στην R
		code.addIntArray("freq", frequency);
		
		// Ο πίνακας interval θα αναγνωρίζεται ως interv στην R
		code.addIntArray("interv", interval);	
		
		// Ο πίνακας names θα αναγνωρίζεται ως names.arg στην R
		code.addStringArray("names", names);
		
		// To ραβδόγραμμα αποθηκεύεται σε File
		File plotFile = code.startPlot();
		
		// Εκτέλεση της εντολής του ραβδογράμματος στην R
		code.addRCode("barplot(freq, main=\"\", horiz = T, names=names, las=1, col=\"brown\", cex.names=0.5, ylim = c(0, 24), xlim = c(0, 100))");
		
		// Σταματά η εκτέλεση της εντολής barplot
		code.endPlot();
		
		// Περνάω τον R κώδικα στον caller
		caller.setRCode(code);
		
		// Τρέξιμο του script
		caller.runOnly();
		 code.showPlot(plotFile);
		// Παίρνουμε την εικόνα του ραβδογράμματος σε imageicon αντικείμενο
		ImageIcon plot = code.getPlot(plotFile);

		return plot;
		
	}
	
	private double[] calcCentralValues(int[] interval) {
		
		// Ένας RCaller για κάθε μέθοδο, για να μην μας εμφανίσει πρόβλημα με τα threads
		RCaller caller = RCaller.create();
				
		// Ένα RCode για κάθε μέθοδο, για να μην μας εμφανίσει πρόβλημα με τα threads
		RCode code = RCode.create();
		
		// Πίνακας με τις κεντρικές τιμές του κάθες διαστήματος (για τον υπολογισμό μέσου, διακύμανσης)
		double[] values = new double[n];
								
		// Ο πίνακας interval θα αναγνωρίζεται ως interv στην R
		code.addIntArray("interv", interval);
						
		// Ο πίνακας interval θα αναγνωρίζεται ως interv στην R
		code.addDoubleArray("values", values);
		
		// Υπολογισμός κεντρικών τιμών
		code.addRCode("k <- 1\r\n" + 
								"  while(k < length(interv)){\r\n" + 
								"    values[k] <- (interv[k] + interv[k+1])/2\r\n" + 
								"    k <- k + 1\r\n" + 
								"  }");
		
		// Πέρασμα του κώδικα στον caller
		caller.setRCode(code);
		
		// Εκτέλεση του κώδικα
		caller.runAndReturnResult("values");
		
		// Επιστροφή των κεντρικών τιμών στο διάνυσμα values
		values = caller.getParser().getAsDoubleArray("values");
		
		return values;		
		
	}
	
	private String[] getNames(int[] interval) {
		
		// Ένας RCaller για κάθε μέθοδο, για να μην μας εμφανίσει πρόβλημα με τα threads
		RCaller caller = RCaller.create();
						
		// Ένα RCode για κάθε μέθοδο, για να μην μας εμφανίσει πρόβλημα με τα threads
		RCode code = RCode.create();
		
		String[] names = new String[interval.length-1];
		
		// Ο πίνακας interval θα αναγνωρίζεται ως interv στην R
		code.addIntArray("interval", interval);
		
		// Ο πίνακας interval θα αναγνωρίζεται ως interv στην R
		code.addStringArray("names", names);
		
		code.addRCode("k=1\r\n" + 
				"				  while(k<length(interval)){\r\n" + 
				"				    names[k] = paste(as.character(interval[k]), \":00 - \", (as.character(interval[k+1])), \":00\")\r\n" + 
				"				    k=k+1\r\n" + 
				"				  }");
		
		// Πέρασμα του κώδικα στον caller
		caller.setRCode(code);
		
		// Εκτέλεση του κώδικα
		caller.runAndReturnResult("names");
		
		names = caller.getParser().getAsStringArray("names");
		
		return names;
	
	}

}