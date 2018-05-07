package Restaurants_Screen_Package;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UnsupportedLookAndFeelException;
import Handler_Package.Handler;
import Handler_Package.Restaurant;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;


public class AddRestaurantScreen {

	private JFrame frame;
	private JTextField nameTextField;
	private JLabel lblAddress;
	private JTextField addressTextField;
	private JLabel lblTelephoneNumber;
	private JTextField telephoneNumTextField;
	private JLabel lblEmail;
	private JTextField emailTextField;
	private JLabel lblOtherComments;
	private JLabel timeDistanceLabel;
	private JTextField timeDistanceTextField;
	private JLabel messageLabel;

	/**
	 * Launch the application.
	 */
	public static void addRestaurant(Handler data, Restaurant rowData) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRestaurantScreen window = new AddRestaurantScreen(data, rowData);
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
	public AddRestaurantScreen(Handler data, Restaurant rowData) {
		initialize(data,rowData);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param rowData 
	 */
	private void initialize(Handler data, Restaurant rowData) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Add a Restaurant");
		if (rowData != null) {
			titleLabel.setText("Editing - " + rowData.getName());
		}
		titleLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		titleLabel.setBounds(250, 0, 160, 66);
		frame.getContentPane().add(titleLabel);
		
		JLabel nameLabel = new JLabel("Restaurant Name :");
		nameLabel.setForeground(SystemColor.text);
		nameLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		nameLabel.setBounds(37, 79, 134, 22);
		frame.getContentPane().add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(201, 82, 134, 20);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		if (rowData != null) {
			nameTextField.setText(rowData.getName());
		}
		
		lblAddress = new JLabel("Address :");
		lblAddress.setForeground(SystemColor.text);
		lblAddress.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblAddress.setBounds(37, 200, 550, 14);
		frame.getContentPane().add(lblAddress);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(133, 197, 454, 20);
		frame.getContentPane().add(addressTextField);
		addressTextField.setColumns(10);
		if (rowData != null) {
			addressTextField.setText(rowData.getAddress());
		}
		
		lblTelephoneNumber = new JLabel("Telephone Number : ");
		lblTelephoneNumber.setForeground(SystemColor.text);
		lblTelephoneNumber.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblTelephoneNumber.setBounds(34, 141, 153, 14);
		frame.getContentPane().add(lblTelephoneNumber);
		
		telephoneNumTextField = new JTextField();
		telephoneNumTextField.setBounds(201, 140, 134, 20);
		frame.getContentPane().add(telephoneNumTextField);
		telephoneNumTextField.setColumns(10);
		if (rowData != null) {
			telephoneNumTextField.setText(rowData.getTelephoneNum());
		}
		
		lblEmail = new JLabel("E-mail :");
		lblEmail.setForeground(SystemColor.text);
		lblEmail.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblEmail.setBounds(357, 146, 71, 14);
		frame.getContentPane().add(lblEmail);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(441, 140, 151, 20);
		frame.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		if (rowData != null) {
			emailTextField.setText(rowData.getEmail());
		}
		
		lblOtherComments = new JLabel("Other Comments :");
		lblOtherComments.setForeground(SystemColor.text);
		lblOtherComments.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblOtherComments.setBounds(37, 240, 139, 14);
		frame.getContentPane().add(lblOtherComments);
		
		timeDistanceLabel = new JLabel("Time Distance:");
		timeDistanceLabel.setForeground(SystemColor.text);
		timeDistanceLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		timeDistanceLabel.setBounds(363, 83, 127, 14);
		frame.getContentPane().add(timeDistanceLabel);
		
		timeDistanceTextField = new JTextField();
		timeDistanceTextField.setBounds(509, 82, 30, 20);
		frame.getContentPane().add(timeDistanceTextField);
		timeDistanceTextField.setColumns(10);
		if (rowData != null) {
			timeDistanceTextField.setText(rowData.getTimeDistance());
		}
		
		JTextArea otherCommentsTextArea = new JTextArea();
		otherCommentsTextArea.setBounds(35, 267, 557, 107);
		frame.getContentPane().add(otherCommentsTextArea);
		if (rowData != null) {
			otherCommentsTextArea.setText(rowData.getComments());
		}
		
		messageLabel = new JLabel("");
		messageLabel.setBounds(207, 405, 231, 14);
		frame.getContentPane().add(messageLabel);
		
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ID = Restaurant.getIDsetter();
				if (rowData != null) {
					ID = rowData.getId();
				}
				String name = nameTextField.getText().trim();
				String timeDistance = timeDistanceTextField.getText().trim();
				String telephoneNum = telephoneNumTextField.getText().trim();
				String email = emailTextField.getText().trim();
				String address = addressTextField.getText().trim();
				String comments = otherCommentsTextArea.getText().trim();
				
				if(name.isEmpty() || timeDistance.isEmpty() || telephoneNum.isEmpty() || email.isEmpty() || address.isEmpty()) {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("You must fill all the blanks in order to proceed! ");
					if(name.isEmpty())
						nameTextField.setBackground(Color.red);
					if(timeDistance.isEmpty())
						timeDistanceTextField.setBackground(Color.red);
					if(telephoneNum.isEmpty())
						telephoneNumTextField.setBackground(Color.red);
					if(email.isEmpty())
						emailTextField.setBackground(Color.red);
					if(address.isEmpty())
						addressTextField.setBackground(Color.red);
				
				}else {
					if (rowData != null) { //If it is an edit !
						data.deleteRestaurant(ID);
					}
					data.addRestaurant(new Restaurant(ID, name, address, telephoneNum, email, timeDistance, comments));
					System.out.println("size of arrayList: " + data.getRestaurantsList().size());
					frame.dispose();
					Restaurants_Screen restaurantScreen = new Restaurants_Screen(data);
					try {
						restaurantScreen.toRestaurantScreen(data);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		nameTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    nameTextField.setBackground(Color.white);
			    timeDistanceTextField.setBackground(Color.white);
			    telephoneNumTextField.setBackground(Color.WHITE);
			    emailTextField.setBackground(Color.WHITE);
			    addressTextField.setBackground(Color.white);
			    messageLabel.setText("");
			  }
			});
		timeDistanceTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  nameTextField.setBackground(Color.white);
				    timeDistanceTextField.setBackground(Color.white);
				    telephoneNumTextField.setBackground(Color.WHITE);
				    emailTextField.setBackground(Color.WHITE);
				    addressTextField.setBackground(Color.white);
				    messageLabel.setText("");
			  }
			});
		
		telephoneNumTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  nameTextField.setBackground(Color.white);
				    timeDistanceTextField.setBackground(Color.white);
				    telephoneNumTextField.setBackground(Color.WHITE);
				    emailTextField.setBackground(Color.WHITE);
				    addressTextField.setBackground(Color.white);
				    messageLabel.setText("");
			  }
			});
		
		emailTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  nameTextField.setBackground(Color.white);
				    timeDistanceTextField.setBackground(Color.white);
				    telephoneNumTextField.setBackground(Color.WHITE);
				    emailTextField.setBackground(Color.WHITE);
				    addressTextField.setBackground(Color.white);
				    messageLabel.setText("");
			  }
			});
		
		addressTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  nameTextField.setBackground(Color.white);
				    timeDistanceTextField.setBackground(Color.white);
				    telephoneNumTextField.setBackground(Color.WHITE);
				    emailTextField.setBackground(Color.WHITE);
				    addressTextField.setBackground(Color.white);
				    messageLabel.setText("");
			  }
			});
		
		
		
		btnApply.setBounds(503, 401, 89, 23);
		frame.getContentPane().add(btnApply);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Restaurants_Screen restScreen = new Restaurants_Screen(data);
				try {
					restScreen.toRestaurantScreen(data);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnCancel.setBounds(37, 401, 89, 23);
		frame.getContentPane().add(btnCancel);
	
		frame.setBounds(100, 100, 641, 480);
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
