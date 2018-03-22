package Staff_Screen_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import Handler_Package.Handler;
import Handler_Package.Staff;
import Restaurants_Screen_Package.AddRestaurantScreen;
import Restaurants_Screen_Package.Restaurants_Screen;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class AddStaffScreen {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblBday;
	private JTextField textField_1;
	private JLabel lblTelephoneNumber;
	private JTextField textField_2;
	private JLabel lblPosition;
	private JTextField textField_3;
	private JLabel lblOtherComments;

	/**
	 * Launch the application.
	 */
	public void addStaff() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaffScreen window = new AddStaffScreen();
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
	public AddStaffScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Add a Staff Member");
		titleLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		titleLabel.setBounds(228, 0, 160, 66);
		frame.getContentPane().add(titleLabel);
		
		JLabel nameLabel = new JLabel("Full Name :");
		nameLabel.setForeground(SystemColor.text);
		nameLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		nameLabel.setBounds(37, 79, 134, 22);
		frame.getContentPane().add(nameLabel);
		
		textField = new JTextField();
		textField.setBounds(181, 82, 134, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblBday = new JLabel("Date of birth :");
		lblBday.setForeground(SystemColor.text);
		lblBday.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblBday.setBounds(345, 85, 83, 14);
		frame.getContentPane().add(lblBday);
		
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
		
		lblPosition = new JLabel("Position :");
		lblPosition.setForeground(SystemColor.text);
		lblPosition.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblPosition.setBounds(357, 164, 71, 14);
		frame.getContentPane().add(lblPosition);
		
		String[] positionStrings = {"Manager","Driver"};
		JComboBox cmbPositionList = new JComboBox(positionStrings);
		cmbPositionList.setBounds(441, 158, 151, 20);
		cmbPositionList.setSelectedIndex(1);
		frame.getContentPane().add(cmbPositionList);
		frame.getContentPane().add(lblPosition);
		
		
		
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(503, 358, 89, 23);
		frame.getContentPane().add(btnApply);	
		Staff newStaffMember = new Staff(0, null, null, null, null);
		Handler newStaff = new Handler();
		
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//newStaffMember.setId(newID.getStaffList().size() + 1); //in order to get the next ID
				newStaffMember.setId(0); //JUST FOR TEST , LINE ABOVE NEEDS TO BE FIXED
				newStaffMember.setName(textField.getText());
				newStaffMember.setDateOfBirth(textField_1.getText());
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd"); //Current local date
				LocalDate localDate = LocalDate.now();
				newStaffMember.setRecruitmentDate(dtf.format(localDate));
				newStaffMember.setPosition(cmbPositionList.getSelectedItem().toString());
				
				newStaff.addStaff(newStaffMember); //ERROR_2
				
				frame.dispose();
				Staff_Screen restScreen = new Staff_Screen();
				try {
					restScreen.toStaffScreen();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Staff_Screen restScreen = new Staff_Screen();
				try {
					restScreen.toStaffScreen();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnCancel.setBounds(37, 358, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		frame.setBounds(100, 100, 641, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
