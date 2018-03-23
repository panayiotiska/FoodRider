package Statistics;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Handler_Package.Handler;
import MainMenu_Screen_Package.MainMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class StatisticsGUI extends JFrame {

	private JPanel contentPane;
	private JLabel image;	
	private JTextPane statsd;
	private JFrame frame;
	private JButton mainMenuBtn;
	private JPanel panel;
	private JButton btnToday;
	private JButton btnThisWeek;
	private JButton btnThisMonth;
	private JButton btnTotal;
	private JButton btnThisYear;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel underSouthPanel;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	
	public void toStatisticsScreen(Handler aData) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticsGUI window = new StatisticsGUI(aData);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public StatisticsGUI(Handler aData) throws IOException {
		
		Handler data = aData;
		frame = new JFrame();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setBounds(100, 100, 580, 760);
		frame.setResizable(false);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		frame.setContentPane(contentPane);
		
		northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		
		underSouthPanel = new JPanel();
		southPanel.add(underSouthPanel, BorderLayout.SOUTH);

		frame.setTitle("Statistics");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Statistics stats = new Statistics();
				
		JLabel statisticsTitle = new JLabel("Statistics");
		statisticsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		statisticsTitle.setFont(new Font("Arial", Font.PLAIN, 32));
		northPanel.add(statisticsTitle, BorderLayout.NORTH);	 
	 
		image = new JLabel("");
		image.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(image, BorderLayout.CENTER);
		image.setIcon(stats.getBarplot());
		southPanel.setLayout(new BorderLayout(0, 0));
		
		statsd = new JTextPane();
		statsd.setLayout(new BorderLayout(0, 0));
		statsd.setFont(new Font("Arial", Font.BOLD, 14));
		statsd.setBackground(frame.getBackground());
		statsd.setEditable(false);
		statsd.setText(System.lineSeparator()+"Total Number of Orders: "+stats.getN()+System.lineSeparator()+System.lineSeparator()+"Orders' Mean (x): "+String.format("%.3g", stats.getMean())+System.lineSeparator()+System.lineSeparator());
		statsd.setText(statsd.getText()+"Standard Deviation (s): "+String.format("%.3g", Math.sqrt(stats.getVariance()))+System.lineSeparator());
		southPanel.add(statsd, BorderLayout.CENTER); 
		
		panel = new JPanel();
		southPanel.add(panel, BorderLayout.NORTH);
		
		btnTotal = new JButton("Total");
		panel.add(btnTotal);
		
		btnToday = new JButton("Today");
		panel.add(btnToday);
		
		btnThisWeek = new JButton("This Week");
		panel.add(btnThisWeek);
		
		btnThisMonth = new JButton("This Month");
		panel.add(btnThisMonth);
		
		btnThisYear = new JButton("This Year");
		panel.add(btnThisYear);
		
		underSouthPanel = new JPanel();
		southPanel.add(underSouthPanel, BorderLayout.SOUTH);
		
		mainMenuBtn = new JButton();
		ImageIcon menuImg = new ImageIcon(this.getClass().getResource("/home.png"));
		mainMenuBtn.setIcon(menuImg);
		mainMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	
				MainMenu mainMenu = new MainMenu(data);
				mainMenu.showMainMenu(data);
			}
		});
		
		underSouthPanel.add(mainMenuBtn);
		
	}

}