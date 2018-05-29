package Orders_Screen_Package;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import Handler_Package.Handler;
import Handler_Package.Order;
import Handler_Package.Restaurant;
import Login_Screen_Package.Client;
import Login_Screen_Package.Database;
import MainMenu_Screen_Package.MainMenu;

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
		frame.setBounds(100, 100, 759, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 717, 322);
		frame.getContentPane().add(scrollPane);
		
		//Filling up the JTable
			ArrayList<Order> orderHistory = new ArrayList<>();
			orderHistory = data.getOrderHistory();
				
			String col[] = {"Order ID", "Restaurant", "Request Time"};
				
			DefaultTableModel model = new DefaultTableModel(col, 0) {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false (non editable cells by double-clicking on them)
			       return false;
			    }
			};
			JTable table = new JTable(model);
			
			for(int i = 0 ; i < orderHistory.size(); i++) {
				model.addRow(new Object[]{orderHistory.get(i).getOrderCode(),orderHistory.get(i).getRestaurant().getName(),orderHistory.get(i).getSentTime()});
			}
			
			scrollPane.setViewportView(table);
			
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
			button.setBounds(338, 407, 64, 60);
	}
}
