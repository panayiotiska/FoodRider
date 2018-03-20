package Login_Screen_Package;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

import MainMenu_Screen_Package.MainMenu;
import Restaurants_Screen_Package.Restaurants_Screen;

public class Login_Screen{

	private JFrame frame;
	private JTextField username_textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public void showLoginScreen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
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
	 * @throws MalformedURLException 
	 */
	public Login_Screen() throws MalformedURLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws MalformedURLException 
	 */
	private void initialize() throws MalformedURLException {
		
		
		
		frame = new JFrame();
		
		
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel title_label = new JLabel("FoodRiders");
		title_label.setFont(new Font("SimSun", Font.ITALIC, 30));
		title_label.setBounds(109, 44, 173, 40);
		frame.getContentPane().add(title_label);
		
		JLabel username_label = new JLabel("Username : ");
		username_label.setForeground(Color.WHITE);
		username_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username_label.setBounds(146, 115, 88, 29);
		frame.getContentPane().add(username_label);
		
		username_textField = new JTextField();
		username_textField.setBounds(126, 154, 130, 20);
		frame.getContentPane().add(username_textField);
		username_textField.setColumns(10);
		
		JLabel password_label = new JLabel("Password :");
		password_label.setForeground(Color.WHITE);
		password_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password_label.setBounds(156, 192, 78, 29);
		frame.getContentPane().add(password_label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 232, 130, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel message_label = new JLabel("");
		message_label.setForeground(new Color(0, 0, 0));
		message_label.setBounds(28, 263, 384, 45);
		frame.getContentPane().add(message_label);
		
		JButton login_btn = new JButton("Login");
		login_btn.setBounds(145, 319, 89, 23);
		frame.getContentPane().add(login_btn);
		
		
		URL url = this.getClass().getResource("ghostRider.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
		
		label.setBounds(-30, 132, 456, 355);
		frame.getContentPane().add(label);
		
		//ActionListeners 
		
		
		
		login_btn.addActionListener(new ActionListener() {
			
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = username_textField.getText().trim();
				String password = passwordField.getText();
				
				Database db = new Database();
		
				
				if(username.isEmpty() || password.isEmpty()) {
					message_label.setForeground(Color.red);
					message_label.setText("You must fill all the blanks in order to proceed! ");
					if(username.isEmpty())
						username_textField.setBackground(Color.red);
					if(password.isEmpty())
						passwordField.setBackground(Color.red);
						
				
				}else if(db.checkData(username, password)) {
						
					
					if(db.getLoginType()==1) {
						frame.dispose();
						MainMenu mainMenu = new MainMenu();
						URL url = getClass().getResource("/Login_Screen_Package/SkypeLogInSound.wav");
						AudioClip clip = Applet.newAudioClip(url);
						clip.play();
						mainMenu.showMainMenu();
					}
						
				
				
				}else {
					message_label.setForeground(Color.red);
					message_label.setText("Incorrect username or password. Account cannot be found!");
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
		
	
		
		frame.setBounds(100, 100, 403, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
