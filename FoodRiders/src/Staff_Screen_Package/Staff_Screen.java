package Staff_Screen_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Handler_Package.Handler;
import Handler_Package.Staff;
import MainMenu_Screen_Package.MainMenu;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Staff_Screen {

	private JFrame frame;
	private static JTable table;
	private static int numberOfStaff = 3;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public void toStaffScreen(Handler aData) throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
												UnsupportedLookAndFeelException {
		Handler data = aData;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Screen window = new Staff_Screen(data);
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
	public Staff_Screen(Handler aData) {
		Handler data = aData;
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Handler aData) {
		
		Handler data = aData;
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 559, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Staff - FoodRiders");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 11, 505, 164);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Full Name", "Position", "Age", "Recruitment Day"
			}
		));
		scrollPane.setViewportView(table_1);  
      
        
		JButton addBtn = new JButton("Add");
		addBtn.setBounds(25, 195, 153, 25);
		frame.getContentPane().add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddStaffScreen addStaffScreen  =  new AddStaffScreen(data);
				frame.dispose();
				addStaffScreen.addStaff(data);
				
			}
		});
		
		JButton btnDiagrafi = new JButton("Delete");
		btnDiagrafi.setBounds(199, 195, 153, 25);
		frame.getContentPane().add(btnDiagrafi);
		
		JButton btnEpeksergasia = new JButton("Edit");
		btnEpeksergasia.setBounds(369, 195, 161, 25);
		frame.getContentPane().add(btnEpeksergasia);
		
		JButton button = new JButton("");
		ImageIcon menuImg = new ImageIcon(this.getClass().getResource("/home.png"));
		button.setIcon(menuImg);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu mainMenu = new MainMenu();
				mainMenu.showMainMenu();
				
			}
		});
		button.setBounds(243, 251, 64, 60);
		
	}
}
