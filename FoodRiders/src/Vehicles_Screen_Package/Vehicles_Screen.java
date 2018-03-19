package Vehicles_Screen_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Vehicles_Screen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void vehiclesScreen(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehicles_Screen window = new Vehicles_Screen();
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
	public Vehicles_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
