package Staff_Screen_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import Handler_Package.Handler;
import Handler_Package.Staff;
import MainMenu_Screen_Package.MainMenu;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Staff_Screen {

	private JFrame frame;

	
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
		frame.setBounds(100, 100, 559, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Staff - FoodRiders");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 66, 505, 164);
		frame.getContentPane().add(scrollPane);
		
		//Filling up the JTable
		ArrayList<Staff> staffList = new ArrayList<>();
		staffList = data.getStaffList();
		
		String col[] = {"ID","Name","Position", "Recruitment Date","Birth Date"};	
		
		DefaultTableModel model = new DefaultTableModel(col, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false (non editable cells by double-clicking on them)
		       return false;
		    }
		};
		JTable table = new JTable(model);
		
		for(int i = 0 ; i < staffList.size(); i++) {
			System.out.println(staffList.get(i).getPosition());
			System.out.println(staffList.get(i).getRecruitmentDate());
			System.out.println(i);
			model.addRow(new Object[]{staffList.get(i).getId(),staffList.get(i).getName(),staffList.get(i).getPosition(),
									  staffList.get(i).getRecruitmentDate(),staffList.get(i).getDateOfBirth()});
		}
		scrollPane.setViewportView(table);
		
		//Buttons
		JButton addBtn = new JButton("Add");
		addBtn.setBounds(25, 250, 153, 25);
		frame.getContentPane().add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddStaffScreen addStaffScreen  =  new AddStaffScreen(data);
				frame.dispose();
				addStaffScreen.addStaff(data);
				
			}
		});
		
		JButton btnDiagrafi = new JButton("Delete");
		btnDiagrafi.setBounds(199, 250, 153, 25);
		frame.getContentPane().add(btnDiagrafi);
		btnDiagrafi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0; //ID column
				int row = table.getSelectedRow();
				int id = -1;
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + table.getModel().getValueAt(row, 1), "Delete?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					id = (int) table.getModel().getValueAt(row, column);
					if(!data.deleteStaff(id)) { //IF this staff member is unavailable
						JOptionPane.showMessageDialog(frame, "Sorry, this staff member is currently on the road.");
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
		
		JLabel lblBusinessStaff = new JLabel("Business'  Staff");
		lblBusinessStaff.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblBusinessStaff.setBounds(210, 11, 142, 44);
		frame.getContentPane().add(lblBusinessStaff);
		
	}
}
