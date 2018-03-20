package Statistics;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class StatisticsGUI extends JFrame {

	private JPanel contentPane;
	private JLabel image;	
	private JTextPane statsd;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public StatisticsGUI() throws IOException {
		setTitle("\u03A3\u03C4\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setBounds(100, 100, 505, 674);
		
		Statistics stats = new Statistics();
		
		image = new JLabel("");
		image.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(image, BorderLayout.CENTER);
		image.setIcon(stats.getBarplot());
		
		JLabel statisticsTitle = new JLabel("\u03A3\u03C4\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03AC");
		statisticsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		statisticsTitle.setFont(new Font("Arial", Font.PLAIN, 32));
		contentPane.add(statisticsTitle, BorderLayout.NORTH);
		
		statsd = new JTextPane();
		statsd.setEditable(false);
		statsd.setText("Αριθμός Παραγγελιών: "+stats.getN()+System.lineSeparator()+"Σημερινός μέσος όρος παραγγελιών: "+String.format("%.3g", stats.getMean()));
		contentPane.add(statsd, BorderLayout.SOUTH);
		
	}

}
