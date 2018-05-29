package MainMenu_Screen_Package;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import Handler_Package.Current_Status;
import Handler_Package.Handler;
import Login_Screen_Package.Database;
import Login_Screen_Package.Login_Screen;
import Orders_Screen_Package.Orders_Screen;
import Restaurants_Screen_Package.Restaurants_Screen;
import Staff_Screen_Package.Staff_Screen;
// import Statistics.StatisticsGUI;
import Statistics.StatisticsGUI;
import Vehicles_Screen_Package.Vehicles_Screen;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class MainMenu {

	private JFrame frameFoodRiders;

	private Current_Status lockedWindow = null;

	/**
	 * Launch the application.
	 */
	public void showMainMenu(Handler aData) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu(aData);
					window.setLockedWindow(lockedWindow);
					window.frameFoodRiders.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/**
	 * @wbp.parser.constructor
	 */

	public MainMenu(Handler aData) {
		initialize(aData);
	}
 
	
	/**
	 * Initialize the contents of the frame.
	 * @param db 
	 */
	
	
	
	private void initialize(Handler aData) {
		
		Handler data = aData;
		
		
		frameFoodRiders = new JFrame();
		frameFoodRiders.getContentPane().setBackground(SystemColor.textHighlight);
		frameFoodRiders.setBackground(SystemColor.textHighlight);
		frameFoodRiders.setResizable(false);
		frameFoodRiders.setTitle("Food Riders");
		frameFoodRiders.setBounds(100, 100, 425, 494);
		
	    WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            	if (JOptionPane.showConfirmDialog(null, "Are You Sure to Close Application?", "WARNING",
            	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            	    System.exit(0);
            	} else {
            	    // no option
            	}
            }
        };
        frameFoodRiders.addWindowListener(exitListener);
        frameFoodRiders.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameFoodRiders.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Main Menu");
		label.setBounds(157, 11, 120, 64);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frameFoodRiders.getContentPane().add(label);
		
		JButton btnTrexousa = new JButton("Current Status");
		btnTrexousa.setBounds(39, 92, 126, 47);
		btnTrexousa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameFoodRiders.dispose();
				if(!(lockedWindow == null)) {
					lockedWindow.getFocus();
					System.out.println("Not null");
				}else {
					Current_Status curr_stat = new Current_Status(data);
					Thread t1 = new Thread(curr_stat);
					t1.start();
					System.out.println("Null");
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 0, 0);
		frameFoodRiders.getContentPane().add(separator);
		frameFoodRiders.getContentPane().add(btnTrexousa);
		
		JButton btnEstiatoria = new JButton("Restaurants");
		btnEstiatoria.setBounds(250, 92, 126, 47);
		btnEstiatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameFoodRiders.dispose();
				Restaurants_Screen restaurants = new Restaurants_Screen(data);
				try {
					restaurants.toRestaurantScreen(data);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		frameFoodRiders.getContentPane().add(btnEstiatoria);
		
		JButton btnParaggelies = new JButton("Orders History");
		btnParaggelies.setBounds(39, 204, 126, 47);
		btnParaggelies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameFoodRiders.dispose();
				Orders_Screen ordersSreen = new Orders_Screen(data);
				try {
					ordersSreen.toOrderScreen(data);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frameFoodRiders.getContentPane().add(btnParaggelies);
		
		JButton btnYpalliloi = new JButton("Staff");
		btnYpalliloi.setBounds(250, 204, 126, 47);
		btnYpalliloi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameFoodRiders.dispose();
				Staff_Screen staffScreen = new Staff_Screen(data);
				try {
					staffScreen.toStaffScreen(data);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frameFoodRiders.getContentPane().add(btnYpalliloi);
		
		JButton btnVehicles = new JButton("Vehicles");
		btnVehicles.setBounds(250, 305, 126, 47);
		btnVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameFoodRiders.dispose();
				Vehicles_Screen vehiclesScreen = new Vehicles_Screen(data);
				try {
					vehiclesScreen.toVehiclesScreen(data);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frameFoodRiders.getContentPane().add(btnVehicles);
		
		JButton btnStatistika = new JButton("Statistics");
		btnStatistika.setBounds(39, 305, 126, 47);
		frameFoodRiders.getContentPane().add(btnStatistika);
		btnStatistika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				StatisticsGUI statisticsScreen = new StatisticsGUI(data);	
				statisticsScreen.toStatisticsScreen(data);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frameFoodRiders.dispose();
			}
		});   
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 0, 0);
		frameFoodRiders.getContentPane().add(separator_1);
		
		JButton btnAposindesi = new JButton("Log out");
		btnAposindesi.setBounds(157, 411, 106, 44);
		btnAposindesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameFoodRiders.dispose();
				Login_Screen loginScreen;
				try {
					loginScreen = new Login_Screen(data);
					try {
						URL url = getClass().getResource("/MainMenu_Screen_Package/skypeLogOutSound.wav");
						AudioClip clip = Applet.newAudioClip(url);
						clip.play();
						loginScreen.showLoginScreen(data);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
			}
		});
		frameFoodRiders.getContentPane().add(btnAposindesi);
	}

	public Current_Status getLockedWindow() {
		return lockedWindow;
	}
	public void setLockedWindow(Current_Status aLockedWindow) {
		lockedWindow = aLockedWindow;
	}

}
