package Restaurants_Screen_Package;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import Main.Main;
import MainMenu_Screen_Package.MainMenu;

public class Restaurants_Screen { 

	private JFrame frame;
	private JTable table;

	/**							//Jtattoo library: library for round buttons
	 * Launch the application. //exception in order the jtattoo library to work
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void toRestaurantScreen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{

		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurants_Screen window = new Restaurants_Screen();
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
	public Restaurants_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 487, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddRestaurantScreen newRest = new AddRestaurantScreen();
				frame.dispose();
				newRest.addRestaurant();
				
			}
		});
		addBtn.setBounds(105, 311, 89, 23);
		frame.getContentPane().add(addBtn);
		
		JButton editBtn = new JButton("Edit");
		editBtn.setBounds(275, 311, 89, 23);
		frame.getContentPane().add(editBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 24, 437, 234);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID code", "Name", "Address", "Telephone"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(2).setPreferredWidth(102);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		scrollPane.setViewportView(table);
		
		JButton btnMainMenu = new JButton("Main Menu");
		/*ImageIcon menuImg = new ImageIcon(this.getClass().getResource("/home.png"));
		btnMainMenu.setIcon(menuImg);*/
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainMenu mainMenu = new MainMenu();
				mainMenu.showMainMenu();
				
			}
		});
		btnMainMenu.setBounds(189, 386, 98, 23);
		frame.getContentPane().add(btnMainMenu);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
