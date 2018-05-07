package Client_Package;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Login_Screen_Package.Login_Screen;

public class Client_Screen {

	private JFrame frame;
	private JTextField timeTextField;
	

	
	
	public static void showClientScreen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Screen window = new Client_Screen();
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
	 * @return 
	 * @wbp.parser.entryPoint
	 */
	public Client_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param rowData 
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Please place the time in seconds and we will be their on time!");
		titleLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		titleLabel.setBounds(228, 0, 200, 66);
		frame.getContentPane().add(titleLabel);
		
		JLabel timeLabel = new JLabel("Ready in :");
		timeLabel.setForeground(SystemColor.text);
		timeLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		timeLabel.setBounds(37, 79, 134, 22);
		frame.getContentPane().add(timeLabel);
		
		timeTextField = new JTextField();
		timeTextField.setBounds(181, 82, 134, 20);
		frame.getContentPane().add(timeTextField);
		timeTextField.setColumns(10);
		
		JButton btnApply = new JButton("Send");
		btnApply.setBounds(336, 243, 89, 23);
		frame.getContentPane().add(btnApply);	
		btnApply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//empty the text-field (ready to send again)
			}
		});	
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();Login_Screen loginScreen;
				try {
					loginScreen = new Login_Screen(null);
					try {
						URL url = getClass().getResource("/MainMenu_Screen_Package/skypeLogOutSound.wav");
						AudioClip clip = Applet.newAudioClip(url);
						clip.play();
						loginScreen.showLoginScreen(null);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnLogout.setBounds(94, 243, 89, 23);
		frame.getContentPane().add(btnLogout);
}
}
