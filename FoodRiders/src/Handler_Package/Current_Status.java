package Handler_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Handler_Package.Handler;
import MainMenu_Screen_Package.MainMenu;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Current_Status {

	private JFrame frame;
	
	private JLabel runningOrders;
	private JLabel ordersInQueue; 
	private JLabel totalVehicles;
	private JLabel vehiclesAvailable;
	private JLabel totalStuffNumber;
	private JLabel staffAvailable;
	private JLabel MoneyIn;
	private JLabel MoneyOut;
	
	private Handler data;
	
	/**
	 * Launch the application.
	 */
	public void Current_Screen (Handler aData) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Current_Status window = new Current_Status(aData);
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Current_Status(Handler aData) {
		initialize(aData);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Handler aData) {
		data = aData;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel CurrentStatusLbl = new JLabel("Current Business Status");
		CurrentStatusLbl.setForeground(SystemColor.controlText);
		CurrentStatusLbl.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		CurrentStatusLbl.setBounds(145, 11, 218, 52);
		frame.getContentPane().add(CurrentStatusLbl);
		
		JLabel runningOrdersLabel = new JLabel("Running orders :");
		runningOrdersLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		runningOrdersLabel.setForeground(SystemColor.text);
		runningOrdersLabel.setBounds(51, 117, 123, 14);
		frame.getContentPane().add(runningOrdersLabel);
		
		JLabel ordersComplLabel = new JLabel("Orders in queue :");
		ordersComplLabel.setForeground(SystemColor.text);
		ordersComplLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		ordersComplLabel.setBounds(284, 117, 128, 14);
		frame.getContentPane().add(ordersComplLabel);
		
		JLabel totalVehiclesLabel = new JLabel("Total vehicles :");
		totalVehiclesLabel.setForeground(SystemColor.text);
		totalVehiclesLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		totalVehiclesLabel.setBounds(54, 192, 120, 14);
		frame.getContentPane().add(totalVehiclesLabel);
		
		JLabel vehiclesAvailableLabel = new JLabel("Vehicles available : ");
		vehiclesAvailableLabel.setForeground(SystemColor.text);
		vehiclesAvailableLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		vehiclesAvailableLabel.setBounds(284, 193, 144, 12);
		frame.getContentPane().add(vehiclesAvailableLabel);
		
		JLabel totalStaffNumLabel = new JLabel("Total staff number :");
		totalStaffNumLabel.setForeground(SystemColor.text);
		totalStaffNumLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		totalStaffNumLabel.setBounds(37, 274, 156, 14);
		frame.getContentPane().add(totalStaffNumLabel);
		
		JLabel staffAvailableLabel = new JLabel("Staff available :");
		staffAvailableLabel.setForeground(SystemColor.text);
		staffAvailableLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		staffAvailableLabel.setBounds(292, 274, 112, 14);
		frame.getContentPane().add(staffAvailableLabel);
		
		JLabel moneyInLabel = new JLabel("Money In :");
		moneyInLabel.setForeground(SystemColor.text);
		moneyInLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		moneyInLabel.setBounds(69, 351, 75, 12);
		frame.getContentPane().add(moneyInLabel);
		
		JLabel moneyOutLabel = new JLabel("Money Out :");
		moneyOutLabel.setForeground(SystemColor.text);
		moneyOutLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		moneyOutLabel.setBounds(301, 350, 103, 14);
		frame.getContentPane().add(moneyOutLabel);
		
		runningOrders = new JLabel(String.valueOf(data.getRunningOrders().size()));
		runningOrders.setForeground(SystemColor.text);
		runningOrders.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		runningOrders.setBounds(184, 117, 46, 14);
		frame.getContentPane().add(runningOrders);
		
		ordersInQueue = new JLabel(String.valueOf(data.getOrdersInQueue().size()));
		ordersInQueue.setForeground(SystemColor.text);
		ordersInQueue.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		ordersInQueue.setBounds(422, 117, 46, 14);
		frame.getContentPane().add(ordersInQueue);
		
		totalVehicles = new JLabel(String.valueOf(data.getVehicles().size()));
		totalVehicles.setForeground(SystemColor.text);
		totalVehicles.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		totalVehicles.setBounds(177, 194, 53, 14);
		frame.getContentPane().add(totalVehicles);
		
		vehiclesAvailable = new JLabel(String.valueOf(data.getVehiclesAvailable().size()));
		vehiclesAvailable.setForeground(SystemColor.text);
		vehiclesAvailable.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		vehiclesAvailable.setBounds(433, 192, 53, 19);
		frame.getContentPane().add(vehiclesAvailable);
		
		totalStuffNumber = new JLabel(String.valueOf(data.getStaffList().size()));
		totalStuffNumber.setForeground(SystemColor.text);
		totalStuffNumber.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		totalStuffNumber.setBounds(192, 276, 46, 14);
		frame.getContentPane().add(totalStuffNumber);
		
		staffAvailable = new JLabel(String.valueOf(data.getStaffAvailable().size()));
		staffAvailable.setForeground(SystemColor.text);
		staffAvailable.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		staffAvailable.setBounds(412, 276, 46, 14);
		frame.getContentPane().add(staffAvailable);
		
		MoneyIn = new JLabel("");
		MoneyIn.setBounds(154, 352, 46, 14);
		frame.getContentPane().add(MoneyIn);
		
		MoneyOut = new JLabel("");
		MoneyOut.setBounds(396, 352, 46, 14);
		frame.getContentPane().add(MoneyOut);
		
		
		
		
		JButton btnMainMenu = new JButton("");
		ImageIcon menuImg = new ImageIcon(this.getClass().getResource("/home.png"));
		btnMainMenu.setIcon(menuImg);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainMenu mainMenu = new MainMenu(data);
				mainMenu.showMainMenu(data);
				
			}
		});
		btnMainMenu.setBounds(196, 382, 64, 60);
		frame.getContentPane().add(btnMainMenu);

		frame.setBounds(100, 100, 512, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}


