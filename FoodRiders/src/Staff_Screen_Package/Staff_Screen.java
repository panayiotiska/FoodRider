package Staff_Screen_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Handler_Package.Staff;
import MainMenu_Screen_Package.MainMenu;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Staff_Screen {

	private JFrame frame;
	private static JTable table;
	private static int numberOfStaff = 3;

	/**
	 * Launch the application.
	 */
	public void toStaffScreen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Screen window = new Staff_Screen();
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
	public Staff_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		List<String> columns = new ArrayList<String>();
        List<String[]> values = new ArrayList<String[]>();
        //Handler temp = new Handler();
        ArrayList<Staff> staffList = new ArrayList<>();
       //staffList = temp.getStaffList(); //ERROR_1

        columns.add("ID");
        columns.add("Name");
        columns.add("Position");
        columns.add("Recruitment Date");

        TableModel tableModel = new DefaultTableModel(staffList.toArray(new Object[][] {}), columns.toArray());
        JTable table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton addBtn = new JButton("Add");
		addBtn.setBounds(25, 195, 153, 25);
		frame.getContentPane().add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddStaffScreen newRest = new AddStaffScreen();
				frame.dispose();
				newRest.addStaff();
				
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
