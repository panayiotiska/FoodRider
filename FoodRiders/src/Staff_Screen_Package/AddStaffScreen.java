package Staff_Screen_Package;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.UnsupportedLookAndFeelException;

import Handler_Package.Handler;
import Handler_Package.Staff;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class AddStaffScreen {

	private JFrame frame;
	private JTextField fullNameTextField;
	private JLabel lblBday;
	private JTextField birthDateTextField;
	private JLabel lblTelephoneNumber;
	private JTextField telephoneNumTextField;
	private JLabel lblPosition;
	/**
	 * Launch the application.
	 * @param rowData 
	 */
	public void addStaff(Handler data, Staff rowData) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaffScreen window = new AddStaffScreen(data, rowData);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param rowData 
	 */
	public AddStaffScreen(Handler data, Staff rowData) {
		initialize(data,rowData);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Handler data, Staff rowData) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Add a Staff member");
		if (rowData != null) {
			titleLabel.setText("Editing - " + rowData.getName());
		}
		titleLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		titleLabel.setBounds(228, 0, 200, 66);
		frame.getContentPane().add(titleLabel);
		
		JLabel nameLabel = new JLabel("Full Name :");
		nameLabel.setForeground(SystemColor.text);
		nameLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		nameLabel.setBounds(37, 79, 134, 22);
		frame.getContentPane().add(nameLabel);
		
		fullNameTextField = new JTextField();
		fullNameTextField.setBounds(181, 82, 134, 20);
		frame.getContentPane().add(fullNameTextField);
		fullNameTextField.setColumns(10);
		if (rowData != null) {
			fullNameTextField.setText(rowData.getName());
		}
		
		lblBday = new JLabel("Date of birth :");
		lblBday.setForeground(SystemColor.text);
		lblBday.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblBday.setBounds(329, 85, 111, 16);
		frame.getContentPane().add(lblBday);
		
		birthDateTextField = new JTextField();
		birthDateTextField.setBounds(441, 82, 151, 20);
		frame.getContentPane().add(birthDateTextField);
		birthDateTextField.setColumns(10);
		if (rowData != null) {
			birthDateTextField.setText(rowData.getDateOfBirth());
		}
		
		lblTelephoneNumber = new JLabel("Telephone Number : ");
		lblTelephoneNumber.setForeground(SystemColor.text);
		lblTelephoneNumber.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblTelephoneNumber.setBounds(34, 159, 153, 14);
		frame.getContentPane().add(lblTelephoneNumber);
		
		telephoneNumTextField = new JTextField();
		telephoneNumTextField.setBounds(191, 158, 127, 20);
		frame.getContentPane().add(telephoneNumTextField);
		telephoneNumTextField.setColumns(10);
		if (rowData != null) {
			telephoneNumTextField.setText(rowData.getTelephoneNumber());
		}
		
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
		
		JLabel messageLbl = new JLabel("");
		messageLbl.setBounds(178, 358, 315, 26);
		frame.getContentPane().add(messageLbl);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(503, 358, 89, 23);
		frame.getContentPane().add(btnApply);	
		btnApply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int ID = data.getStaffList().size(); //BUG MUST FIX (REPLACE WITH METRITI)
				if (rowData != null) {
					ID = rowData.getId(); // so the ID remains the same
				}
				String fullName = fullNameTextField.getText().trim();
				String position = cmbPositionList.getSelectedItem().toString();
				String dateOfBirth = birthDateTextField.getText().trim();
				String telephoneNum = telephoneNumTextField.getText().trim();
				String recruitmentDate = null;
				
				if(rowData == null) { //if its an add and not an edit
					recruitmentDate = "Error Occurred";
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //set Current local date as recruitmentDate
					LocalDate localDate = LocalDate.now();
					recruitmentDate = dtf.format(localDate).toString();
				}
				else {
					recruitmentDate = rowData.getRecruitmentDate();
				}
				
				if(fullName.isEmpty() || dateOfBirth.isEmpty() || telephoneNum.isEmpty()) {
					messageLbl.setForeground(Color.red);
					messageLbl.setText("You must fill all the blanks in order to proceed! ");
					if(fullName.isEmpty())
						fullNameTextField.setBackground(Color.red);
					if(dateOfBirth.isEmpty())
						birthDateTextField.setBackground(Color.red);
					if(telephoneNum.isEmpty())
						telephoneNumTextField.setBackground(Color.red);
				}else {
					
					if (rowData != null) { //If it is an edit !
						data.deleteStaff(ID);
					}
					data.addStaff(new Staff(ID, fullName, position, dateOfBirth, recruitmentDate, telephoneNum));
					System.out.println("size of arrayList: " + data.getStaffList().size());

				frame.dispose();
				Staff_Screen restScreen = new Staff_Screen(data);
				try {
					restScreen.toStaffScreen(data);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				
			}
		});
		
		
		fullNameTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    fullNameTextField.setBackground(Color.white);
			    birthDateTextField.setBackground(Color.white);
			    telephoneNumTextField.setBackground(Color.WHITE);
			    messageLbl.setText("");
			  }
			});
		birthDateTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  fullNameTextField.setBackground(Color.white);
				  birthDateTextField.setBackground(Color.white);
				  telephoneNumTextField.setBackground(Color.WHITE);
				  messageLbl.setText("");
			  }
			});
		
		telephoneNumTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  fullNameTextField.setBackground(Color.white);
				  birthDateTextField.setBackground(Color.white);
				  telephoneNumTextField.setBackground(Color.WHITE);
				  messageLbl.setText("");
			  }
			});
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Staff_Screen restScreen = new Staff_Screen(data);
				try {
					restScreen.toStaffScreen(data);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnCancel.setBounds(37, 358, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		frame.getRootPane().setDefaultButton(btnApply); // Allowing the “Enter” key to press the login button
		
		frame.setBounds(100, 100, 641, 430);
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
        frame.addWindowListener(exitListener);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
