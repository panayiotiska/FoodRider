package Restaurants_Screen_Package;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import Handler_Package.Handler;
import Handler_Package.Restaurant;
import Handler_Package.Staff;
import MainMenu_Screen_Package.MainMenu;

public class Restaurants_Screen { 

	private JFrame frame;
	private JTable table;

	/**	//Jtattoo library: library for round buttons
	 * Launch the application. //exception in order the jtattoo library to work
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void toRestaurantScreen(Handler aData) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{

		Handler data = aData;
		
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurants_Screen window = new Restaurants_Screen(data);
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
	public Restaurants_Screen(Handler aData) {
		Handler data = aData;
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize(Handler aData) {
		
		Handler data = aData;
		
		frame = new JFrame();
		frame.setResizable(false);
		
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 555, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Restaurants - FoodRiders");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 24, 505, 236);
		frame.getContentPane().add(scrollPane);
		
		//Filling up the JTable
		ArrayList<Restaurant> restaurantsList = new ArrayList<>();
		restaurantsList = data.getRestaurantsList();
			
		String col[] = {"ID", "Name", "Address", "Telephone", "Email", "Time Distance", "Comments"};	
			
		DefaultTableModel model = new DefaultTableModel(col, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false (non editable cells by double-clicking on them)
		       return false;
		    }
		};
		JTable table = new JTable(model);
		
		for(int i = 0 ; i < restaurantsList.size(); i++) {
			model.addRow(new Object[]{restaurantsList.get(i).getId(),restaurantsList.get(i).getName(),restaurantsList.get(i).getAddress(),
									  restaurantsList.get(i).getTelephoneNum(),restaurantsList.get(i).getEmail(),
									  restaurantsList.get(i).getTimeDistance(),restaurantsList.get(i).getComments()});
		}
		scrollPane.setViewportView(table);
		
		//Buttons
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddRestaurantScreen newRest = new AddRestaurantScreen(data);
				frame.dispose();
				newRest.addRestaurant(data);
				
			}
		});
		addBtn.setBounds(118, 311, 89, 23);
		frame.getContentPane().add(addBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(330, 311, 89, 23);
		frame.getContentPane().add(deleteBtn);
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0; //ID column
				int row = table.getSelectedRow();
				int id = -1;
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + table.getModel().getValueAt(row, 1), "Delete?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					id = (int) table.getModel().getValueAt(row, column);
					data.deleteRestaurant(id);
					((DefaultTableModel)table.getModel()).removeRow(row);
				}
			}
		});
		
		JButton btnMainMenu = new JButton("");
		ImageIcon menuImg = new ImageIcon(this.getClass().getResource("/home.png"));
		btnMainMenu.setIcon(menuImg);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainMenu mainMenu = new MainMenu(data);
				mainMenu.showMainMenu(data);
				
			}
		});
		btnMainMenu.setBounds(239, 367, 64, 60);
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
