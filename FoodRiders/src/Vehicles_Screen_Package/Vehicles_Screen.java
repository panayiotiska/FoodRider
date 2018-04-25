package Vehicles_Screen_Package;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import Handler_Package.Staff;
import Handler_Package.Vehicle;
import MainMenu_Screen_Package.MainMenu;
import Staff_Screen_Package.AddStaffScreen;

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
				
				AddVehicleScreen addVehicleScreen  =  new AddVehicleScreen(data, null);
				frame.dispose();
				addVehicleScreen.addVehicle(data, null);
				
			}
		});
		
		JButton btnDiagrafi = new JButton("Delete");
		btnDiagrafi.setBounds(199, 250, 153, 25);
		frame.getContentPane().add(btnDiagrafi);
		btnDiagrafi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0; //Plates Column
				int row = table.getSelectedRow();
				String selectedRow = null;
				String selectedPlate = null;
				if(!table.getSelectionModel().isSelectionEmpty()) {
					selectedPlate = (String) table.getModel().getValueAt(row, 1);
					int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + selectedPlate , "Delete?",  JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						selectedRow = (String) table.getModel().getValueAt(row, column);
						if(!data.deleteVehicle(selectedRow)) { //IF this staff member is unavailable
							JOptionPane.showMessageDialog(frame, "Sorry, this Vehicle is currently on the road.");
						}
						((DefaultTableModel)table.getModel()).removeRow(row);
					}
				}
			}
		});
		
		JButton btnEpeksergasia = new JButton("Edit");
		btnEpeksergasia.setBounds(369, 250, 161, 25);
		frame.getContentPane().add(btnEpeksergasia);
		btnEpeksergasia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				//pass in addStaffScreen the data of the selected row
				
				if(!table.getSelectionModel().isSelectionEmpty()) {
					Vehicle rowData = new Vehicle((String) table.getModel().getValueAt(row,  0),  //ID
											(String) table.getModel().getValueAt(row, 1), //NAME
											(String) table.getModel().getValueAt(row, 2), //POSITION
											(String) table.getModel().getValueAt(row, 3), //DATE OF BIRTHE
											(String) table.getModel().getValueAt(row, 4),
											(Boolean) table.getModel().getValueAt(row, 5));//RECRUITMENT DATE
					AddVehicleScreen addVehicleScreen  =  new AddVehicleScreen(data,rowData);
					frame.dispose();
					AddVehicleScreen.addVehicle(data,rowData);
				}
				
			}
		});
		
		JButton button = new JButton("");
		ImageIcon menuImg = new ImageIcon(this.getClass().getResource("/home.png"));
		button.setIcon(menuImg);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu mainMenu = new MainMenu(data);
				mainMenu.setLockedWindow(data.getLockedWindow());
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
