package Staff_Screen_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Staff_Screen {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void EmployeesScreen() {
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
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 1075, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1057, 164);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), "\u0396\u03AE\u03C3\u03B7\u03C2 \u0394\u03B7\u03BC\u03AE\u03C4\u03C1\u03B9\u03BF\u03C2", "\u039F\u03B4\u03B7\u03B3\u03CC\u03C2", new Integer(12), "1/1/2017"},
				{new Integer(2), "\u03A3\u03C9\u03C4\u03B7\u03C1\u03AC\u03BA\u03B7\u03C2 \u03A0\u03B7\u03B3\u03B9\u03CE\u03C4\u03B7\u03C2", "\u03A8\u03AE\u03C3\u03C4\u03B7\u03C2", new Integer(33), "1/1/2017"},
				{new Integer(3), "\u03A0\u03B1\u03BD\u03B1\u03B3\u03B9\u03CE\u03C4\u03B7\u03C2 \u039A\u03B1\u03C4\u03C4\u03AF\u03B4\u03B7\u03C2", "Manager", new Integer(34), null},
			},
			new String[] {
				"\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03A5\u03C0\u03B1\u03BB\u03BB\u03AE\u03BB\u03BF\u03C5", "\u039F\u03BD\u03BF\u03BC\u03B1\u03C4\u03B5\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF", "\u039A\u03B1\u03B8\u03AE\u03BA\u03BF\u03BD\u03C4\u03B1", "\u0397\u03BB\u03B9\u03BA\u03AF\u03B1", "\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u03A0\u03C1\u03CC\u03C3\u03BB\u03B7\u03C8\u03B7\u03C2"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(145);
		scrollPane.setViewportView(table);
		
		JButton btnProsthiki = new JButton("Π�?οσθήκη Υπαλλήλου");
		btnProsthiki.setBounds(12, 195, 153, 25);
		frame.getContentPane().add(btnProsthiki);
		
		JButton btnDiagrafi = new JButton("Διαγ�?αφή Υπαλλήλου");
		btnDiagrafi.setBounds(177, 195, 153, 25);
		frame.getContentPane().add(btnDiagrafi);
		
		JButton btnEpeksergasia = new JButton("Επξε�?γασία Υπαλλήλου");
		btnEpeksergasia.setBounds(344, 195, 161, 25);
		frame.getContentPane().add(btnEpeksergasia);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(42, 256, 89, 23);
		frame.getContentPane().add(button);
	}
}
