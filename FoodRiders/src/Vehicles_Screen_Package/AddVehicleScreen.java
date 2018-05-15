package Vehicles_Screen_Package;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.UnsupportedLookAndFeelException;

import Handler_Package.Handler;
import Handler_Package.Vehicle;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class AddVehicleScreen {

	private JFrame frame;
	private JTextField plateTextField;
	private JLabel brandLabel;
	private JTextField brandTextField;
	private JLabel modelLabel;
	private JTextField modelTextField;
	private JLabel typeLabel;
	/**
	 * Launch the application.
	 * @param rowData 
	 */
	public static void addVehicle(Handler data, Vehicle rowData) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVehicleScreen window = new AddVehicleScreen(data, rowData);
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
	 */
	public AddVehicleScreen(Handler data, Vehicle rowData) {
		initialize(data,rowData);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param rowData 
	 */
	private void initialize(Handler aData, Vehicle rowData) {
		
		Handler data = aData;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Add a new Vehicle");
		if (rowData != null) {
			titleLabel.setText("Editing - " + rowData.getPlate());
		}
		titleLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		titleLabel.setBounds(228, 0, 200, 66);
		frame.getContentPane().add(titleLabel);
		
		JLabel plateLabel = new JLabel("Plate Number :");
		plateLabel.setForeground(SystemColor.text);
		plateLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		plateLabel.setBounds(37, 79, 134, 22);
		frame.getContentPane().add(plateLabel);
		
		plateTextField = new JTextField();
		plateTextField.setBounds(181, 82, 134, 20);
		frame.getContentPane().add(plateTextField);
		plateTextField.setColumns(10);
		if (rowData != null) {
			plateTextField.setText(rowData.getPlate());
		}
		
		brandLabel = new JLabel("Brand :");
		brandLabel.setForeground(SystemColor.text);
		brandLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		brandLabel.setBounds(329, 85, 111, 16);
		frame.getContentPane().add(brandLabel);
		
		brandTextField = new JTextField();
		brandTextField.setBounds(441, 82, 151, 20);
		frame.getContentPane().add(brandTextField);
		brandTextField.setColumns(10);
		if (rowData != null) {
			brandTextField.setText(rowData.getBrand());
		}
		
		modelLabel = new JLabel("Model : ");
		modelLabel.setForeground(SystemColor.text);
		modelLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		modelLabel.setBounds(34, 159, 153, 14);
		frame.getContentPane().add(modelLabel);
		
		modelTextField = new JTextField();
		modelTextField.setBounds(191, 158, 127, 20);
		frame.getContentPane().add(modelTextField);
		modelTextField.setColumns(10);
		if (rowData != null) {
			modelTextField.setText(rowData.getModel());
		}
		
		typeLabel = new JLabel("Type :");
		typeLabel.setForeground(SystemColor.text);
		typeLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		typeLabel.setBounds(357, 164, 71, 14);
		frame.getContentPane().add(typeLabel);
		
		String[] typeStrings = {"Car","Motorcycle","Bicycle"};
		JComboBox cmbTypeList = new JComboBox(typeStrings);
		cmbTypeList.setBounds(441, 158, 151, 20);
		cmbTypeList.setSelectedIndex(1);
		if (rowData != null) {
			switch (rowData.getType()) {
            case "Car": cmbTypeList.setSelectedIndex(0);
                    break;
            case "Motorcycle": cmbTypeList.setSelectedIndex(1);
            		break;
            case "Bicycle": cmbTypeList.setSelectedIndex(2);
            		break;
			}
		}
		frame.getContentPane().add(cmbTypeList);
		frame.getContentPane().add(typeLabel);
		
		JLabel messageLbl = new JLabel("");
		messageLbl.setBounds(178, 358, 315, 26);
		frame.getContentPane().add(messageLbl);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(503, 358, 89, 23);
		frame.getContentPane().add(btnApply);	
		btnApply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String plate = plateTextField.getText().trim();
				String type = cmbTypeList.getSelectedItem().toString();
				String brand = brandTextField.getText().trim();
				String model = modelTextField.getText().trim();
				String purchaseDate;
				

				if(rowData == null) { //if its an add and not an edit
					purchaseDate = "Error Occurred";
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //set Current local date as recruitmentDate
					LocalDate localDate = LocalDate.now();
					purchaseDate = dtf.format(localDate).toString();
				}
				else {
					purchaseDate = rowData.getPurchaseDate();
				}
				
				if(plate.isEmpty() || brand.isEmpty() || model.isEmpty()) {
					messageLbl.setForeground(Color.red);
					messageLbl.setText("You must fill all the blanks in order to proceed! ");
					if(plate.isEmpty())
						plateTextField.setBackground(Color.red);
					if(brand.isEmpty())
						brandTextField.setBackground(Color.red);
					if(model.isEmpty())
						modelTextField.setBackground(Color.red);
				}else {
					if (rowData != null) { //If it is an edit !
						data.deleteVehicle(rowData.getPlate());
					}
					data.addVehicle(new Vehicle(plate, type, brand, model, purchaseDate,true));
					System.out.println("size of arrayList: " + data.getStaffList().size());
				
				frame.dispose();
				Vehicles_Screen restScreen = new Vehicles_Screen(data);
				try {
					restScreen.toVehiclesScreen(data);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				
			}
		});
		
		
		plateTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				plateTextField.setBackground(Color.white);
			    brandTextField.setBackground(Color.white);
			    modelTextField.setBackground(Color.WHITE);
			    messageLbl.setText("");
			  }
			});
		brandTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  plateTextField.setBackground(Color.white);
				  brandTextField.setBackground(Color.white);
				  modelTextField.setBackground(Color.WHITE);
				  messageLbl.setText("");
			  }
			});
		
		modelTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  plateTextField.setBackground(Color.white);
				  brandTextField.setBackground(Color.white);
				  modelTextField.setBackground(Color.WHITE);
				  messageLbl.setText("");
			  }
			});
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Vehicles_Screen restScreen = new Vehicles_Screen(data);
				try {
					restScreen.toVehiclesScreen(data);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnCancel.setBounds(37, 358, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		frame.getRootPane().setDefaultButton(btnApply); // Allowing the “Enter” key to press the login button
		
		frame.setBounds(100, 100, 641, 430);
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
	}
}
