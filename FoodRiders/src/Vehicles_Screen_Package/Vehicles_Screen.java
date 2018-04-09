package Vehicles_Screen_Package;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import Handler_Package.Handler;
import Handler_Package.Vehicle;
import MainMenu_Screen_Package.MainMenu;

public class Vehicles_Screen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void toVehiclesScreen(Handler aData) throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
	UnsupportedLookAndFeelException {
		Handler data = aData;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehicles_Screen window = new Vehicles_Screen(data);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param data 
	 */
	public Vehicles_Screen(Handler aData) {
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
		frame.setBounds(100, 100, 559, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Vehicles - FoodRiders");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 66, 505, 164);
		frame.getContentPane().add(scrollPane);
		
		//Filling up the JTable
		ArrayList<Vehicle> vehiclesList = new ArrayList<>();
		vehiclesList = data.getVehicles();
		
		String col[] = {"Plate","Type","Brand","Model","Purchase Date","Status"};	
		
		DefaultTableModel model = new DefaultTableModel(col, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false (non editable cells by double-clicking on them)
		       return false;
		    }
		};
		JTable table = new JTable(model);
		
		for(int i = 0 ; i < vehiclesList.size(); i++) {
			//System.out.println(vehiclesList.get(i).getPlate());
			//System.out.println(vehiclesList.get(i).getType());
			//System.out.println(i);
			model.addRow(new Object[]{vehiclesList.get(i).getPlate(),vehiclesList.get(i).getType(),vehiclesList.get(i).getBrand(),
					vehiclesList.get(i).getModel(),vehiclesList.get(i).getPurchaseDate(),vehiclesList.get(i).getStatus()});
		}
		scrollPane.setViewportView(table);
		
		//Buttons
		JButton addBtn = new JButton("Add");
		addBtn.setBounds(25, 250, 153, 25);
		frame.getContentPane().add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddVehicleScreen addVehicleScreen  =  new AddVehicleScreen(data);
				frame.dispose();
				addVehicleScreen.addVehicle(data);
				
			}
		});
		
		JButton btnDiagrafi = new JButton("Delete");
		btnDiagrafi.setBounds(199, 250, 153, 25);
		frame.getContentPane().add(btnDiagrafi);
		btnDiagrafi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0; //Plates Column
				int row = table.getSelectedRow();
				String plate = null;
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + table.getModel().getValueAt(row, 1), "Delete?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					plate = (String) table.getModel().getValueAt(row, column);
					if(!data.deleteVehicle(plate)) { //IF this staff member is unavailable
						JOptionPane.showMessageDialog(frame, "Sorry, this Vehicle is currently on the road.");
					}
					((DefaultTableModel)table.getModel()).removeRow(row);
				}
			}
		});
		
		JButton btnEpeksergasia = new JButton("Edit");
		btnEpeksergasia.setBounds(369, 250, 161, 25);
		frame.getContentPane().add(btnEpeksergasia);
		
		JButton button = new JButton("");
		ImageIcon menuImg = new ImageIcon(this.getClass().getResource("/home.png"));
		button.setIcon(menuImg);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu mainMenu = new MainMenu(data);
				mainMenu.showMainMenu(data);
				
			}
		});
		button.setBounds(243, 306, 64, 60);
		
		JLabel lblBusinessVehicles = new JLabel("Business'  Vehicles");
		lblBusinessVehicles.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblBusinessVehicles.setBounds(210, 11, 142, 44);
		frame.getContentPane().add(lblBusinessVehicles);
		
	}

}
