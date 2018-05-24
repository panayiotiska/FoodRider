package Orders_Screen_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import Handler_Package.Handler;
import Handler_Package.Order;
import Handler_Package.Restaurant;
import Login_Screen_Package.Client;
import Login_Screen_Package.Database;

public class Orders_Screen {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void toOrderScreen(Handler data) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders_Screen window = new Orders_Screen(data);
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
	public Orders_Screen(Handler data) {
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param aData 
	 */
	private void initialize(Handler data) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOrdersHistory = new JLabel("Orders History");
		lblOrdersHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdersHistory.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblOrdersHistory.setBounds(12, 13, 717, 40);
		frame.getContentPane().add(lblOrdersHistory);
		frame.setBounds(100, 100, 759, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Filling up the JTable
			ArrayList<Order> orderHistory = new ArrayList<>();
			orderHistory = data.getOrderHistory();
				
			String col[] = {"ID", "Restaurant", "Time", "Driver"};
				
			DefaultTableModel model = new DefaultTableModel(col, 0) {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false (non editable cells by double-clicking on them)
			       return false;
			    }
			};
			JTable table = new JTable(model);
			table.setBounds(12, 66, 717, 322);
			frame.getContentPane().add(table);
			
			for(int i = 0 ; i < orderHistory.size(); i++) {
				model.addRow(new Object[]{orderHistory.get(i).getOrderCode(),orderHistory.get(i).getRestaurant().getName(),"00:00","Sotirakis"});
			}
	}
}
