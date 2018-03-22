package MainMenu_Screen_Package;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import Login_Screen_Package.Login_Screen;
import Restaurants_Screen_Package.Restaurants_Screen;
import Staff_Screen_Package.Staff_Screen;
// import Statistics.StatisticsGUI;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class MainMenu {

	private JFrame frmFoodRiders;

	/**
	 * Launch the application.
	 */
	public void showMainMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmFoodRiders.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoodRiders = new JFrame();
		frmFoodRiders.getContentPane().setBackground(SystemColor.textHighlight);
		frmFoodRiders.setBackground(SystemColor.textHighlight);
		frmFoodRiders.setResizable(false);
		frmFoodRiders.setTitle("Food Riders");
		frmFoodRiders.setBounds(100, 100, 690, 461);
		frmFoodRiders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{432, 0};
		gridBagLayout.rowHeights = new int[]{16, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		frmFoodRiders.getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("Main Menu");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		frmFoodRiders.getContentPane().add(label, gbc_label);
		
		JButton btnTrexousa = new JButton("Current Status");
		btnTrexousa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		frmFoodRiders.getContentPane().add(separator, gbc_separator);
		GridBagConstraints gbc_btnTrexousa = new GridBagConstraints();
		gbc_btnTrexousa.insets = new Insets(0, 0, 5, 0);
		gbc_btnTrexousa.fill = GridBagConstraints.BOTH;
		gbc_btnTrexousa.gridx = 0;
		gbc_btnTrexousa.gridy = 2;
		frmFoodRiders.getContentPane().add(btnTrexousa, gbc_btnTrexousa);
		
		JButton btnEstiatoria = new JButton("Restaurants");
		btnEstiatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFoodRiders.dispose();
				Restaurants_Screen restaurants = new Restaurants_Screen();
				try {
					restaurants.toRestaurantScreen();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		GridBagConstraints gbc_btnEstiatoria = new GridBagConstraints();
		gbc_btnEstiatoria.insets = new Insets(0, 0, 5, 0);
		gbc_btnEstiatoria.fill = GridBagConstraints.BOTH;
		gbc_btnEstiatoria.gridx = 0;
		gbc_btnEstiatoria.gridy = 3;
		frmFoodRiders.getContentPane().add(btnEstiatoria, gbc_btnEstiatoria);
		
		JButton btnParaggelies = new JButton("Orders");
		GridBagConstraints gbc_btnParaggelies = new GridBagConstraints();
		gbc_btnParaggelies.insets = new Insets(0, 0, 5, 0);
		gbc_btnParaggelies.fill = GridBagConstraints.BOTH;
		gbc_btnParaggelies.gridx = 0;
		gbc_btnParaggelies.gridy = 4;
		frmFoodRiders.getContentPane().add(btnParaggelies, gbc_btnParaggelies);
		
		JButton btnYpalliloi = new JButton("Staff");
		btnYpalliloi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFoodRiders.dispose();
				Staff_Screen staffScreen = new Staff_Screen();
				try {
					staffScreen.toStaffScreen();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnYpalliloi = new GridBagConstraints();
		gbc_btnYpalliloi.insets = new Insets(0, 0, 5, 0);
		gbc_btnYpalliloi.fill = GridBagConstraints.BOTH;
		gbc_btnYpalliloi.gridx = 0;
		gbc_btnYpalliloi.gridy = 5;
		frmFoodRiders.getContentPane().add(btnYpalliloi, gbc_btnYpalliloi);
		
		JButton btnStatistika = new JButton("Statistics");
		GridBagConstraints gbc_btnStatistika = new GridBagConstraints();
		gbc_btnStatistika.insets = new Insets(0, 0, 5, 0);
		gbc_btnStatistika.fill = GridBagConstraints.BOTH;
		gbc_btnStatistika.gridx = 0;
		gbc_btnStatistika.gridy = 6;
		frmFoodRiders.getContentPane().add(btnStatistika, gbc_btnStatistika);
	/*	btnStatistika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				StatisticsGUI statisticsScreen = new StatisticsGUI();	
				statisticsScreen.toStatisticsScreen();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmFoodRiders.dispose();
			}
		}); */
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(5, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 7;
		frmFoodRiders.getContentPane().add(separator_1, gbc_separator_1);
		
		JButton btnAposindesi = new JButton("Log out");
		btnAposindesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFoodRiders.dispose();
				Login_Screen loginScreen;
				try {
					loginScreen = new Login_Screen();
					try {
						URL url = getClass().getResource("/MainMenu_Screen_Package/skypeLogOutSound.wav");
						AudioClip clip = Applet.newAudioClip(url);
						clip.play();
						loginScreen.showLoginScreen();
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
		GridBagConstraints gbc_btnAposindesi = new GridBagConstraints();
		gbc_btnAposindesi.fill = GridBagConstraints.VERTICAL;
		gbc_btnAposindesi.gridx = 0;
		gbc_btnAposindesi.gridy = 8;
		frmFoodRiders.getContentPane().add(btnAposindesi, gbc_btnAposindesi);
	}
}
