package Login_Screen_Package;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.*;
import javax.swing.*;

import Restaurants_Screen_Package.Restaurants_Screen;

public class Login_Screen{

	private JFrame frame;
	private JTextField username_textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public void startApplication() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Screen window = new Login_Screen();
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
	public Login_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		
		
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel title_label = new JLabel("UberEats");
		title_label.setFont(new Font("SimSun", Font.ITALIC, 30));
		title_label.setBounds(160, 32, 136, 40);
		frame.getContentPane().add(title_label);
		
		JLabel username_label = new JLabel("Username : ");
		username_label.setForeground(Color.WHITE);
		username_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username_label.setBounds(179, 115, 88, 29);
		frame.getContentPane().add(username_label);
		
		username_textField = new JTextField();
		username_textField.setBounds(152, 155, 130, 20);
		frame.getContentPane().add(username_textField);
		username_textField.setColumns(10);
		
		JLabel password_label = new JLabel("Password :");
		password_label.setForeground(Color.WHITE);
		password_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password_label.setBounds(178, 196, 78, 29);
		frame.getContentPane().add(password_label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 232, 130, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel message_label = new JLabel("");
		message_label.setForeground(new Color(0, 0, 0));
		message_label.setBounds(28, 263, 384, 45);
		frame.getContentPane().add(message_label);
		
		JButton login_btn = new JButton("Login");
		login_btn.setBounds(178, 319, 89, 23);
		frame.getContentPane().add(login_btn);
		
		//ActionListeners 
		
		
		
		login_btn.addActionListener(new ActionListener() {
			
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = username_textField.getText().trim();
				String password = passwordField.getText();
				
				Database db = new Database();
		
				
				if(username.isEmpty() || password.isEmpty()) {
					message_label.setForeground(Color.red);
					message_label.setText("You must fill all the details to proceed! ");
					if(username.isEmpty())
						username_textField.setBackground(Color.red);
					if(password.isEmpty())
						passwordField.setBackground(Color.red);
						
				
				}else if(db.checkData(username, password)) {
						/*username_label.setVisible(false);
						password_label.setVisible(false);
						username_textField.setVisible(false);
						passwordField.setVisible(false);
						login_btn.setVisible(false);
						message_label.setForeground(Color.black);*/
						frame.dispose();
						Restaurants_Screen restScreen = new Restaurants_Screen();
						try {
							restScreen.toRestaurantScreen();
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
								| UnsupportedLookAndFeelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
				
				
				}else {
					message_label.setForeground(Color.red);
					message_label.setText("! Incorrect username or password. Account cannot be found!");
				}
				
				
			}
		});
		
		username_textField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    username_textField.setBackground(Color.white);
			    passwordField.setBackground(Color.white);
			    message_label.setText("");
			  }
			});
		passwordField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    username_textField.setBackground(Color.white);
			    passwordField.setBackground(Color.white);
			    message_label.setText("");
			  }
			});
		
	
		
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}