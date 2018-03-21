package Restaurants_Screen_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import Handler_Package.Handler;
import Handler_Package.Staff;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRestaurantScreen {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblAddress;
	private JTextField textField_1;
	private JLabel lblTelephoneNumber;
	private JTextField textField_2;
	private JLabel lblEmail;
	private JTextField textField_3;
	private JLabel lblOtherComments;

	/**
	 * Launch the application.
	 */
	public static void addRestaurant() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRestaurantScreen window = new AddRestaurantScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddRestaurantScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Add a Restaurant");
		titleLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		titleLabel.setBounds(228, 0, 160, 66);
		frame.getContentPane().add(titleLabel);
		
		JLabel nameLabel = new JLabel("Restaurant Name :");
		nameLabel.setForeground(SystemColor.text);
		nameLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		nameLabel.setBounds(37, 79, 134, 22);
		frame.getContentPane().add(nameLabel);
		
		textField = new JTextField();
		textField.setBounds(181, 82, 134, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setForeground(SystemColor.text);
		lblAddress.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblAddress.setBounds(345, 85, 83, 14);
		frame.getContentPane().add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(441, 82, 151, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblTelephoneNumber = new JLabel("Telephone Number : ");
		lblTelephoneNumber.setForeground(SystemColor.text);
		lblTelephoneNumber.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblTelephoneNumber.setBounds(34, 159, 153, 14);
		frame.getContentPane().add(lblTelephoneNumber);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 158, 127, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblEmail = new JLabel("E-mail :");
		lblEmail.setForeground(SystemColor.text);
		lblEmail.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblEmail.setBounds(357, 164, 71, 14);
		frame.getContentPane().add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(441, 158, 151, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		lblOtherComments = new JLabel("Other Comments :");
		lblOtherComments.setForeground(SystemColor.text);
		lblOtherComments.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblOtherComments.setBounds(37, 213, 139, 14);
		frame.getContentPane().add(lblOtherComments);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(503, 358, 89, 23);
		frame.getContentPane().add(btnApply);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Restaurants_Screen restScreen = new Restaurants_Screen();
				try {
					restScreen.toRestaurantScreen();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnCancel.setBounds(37, 358, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(35, 240, 557, 107);
		frame.getContentPane().add(textArea);
		frame.setBounds(100, 100, 641, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
