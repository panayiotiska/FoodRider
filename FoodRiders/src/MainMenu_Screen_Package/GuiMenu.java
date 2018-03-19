package MainMenu_Screen_Package;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Staff_Screen_Package.GuiEmployees;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;

public class GuiMenu {

	private JFrame frmFoodRiders;

	/**
	 * Launch the application.
	 */
	public static void showMainMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMenu window = new GuiMenu();
					window.frmFoodRiders.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoodRiders = new JFrame();
		frmFoodRiders.setResizable(false);
		frmFoodRiders.setTitle("Food Riders");
		frmFoodRiders.setBounds(100, 100, 690, 461);
		frmFoodRiders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{432, 0};
		gridBagLayout.rowHeights = new int[]{16, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		frmFoodRiders.getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("\u039A\u03B5\u03BD\u03C4\u03C1\u03B9\u03BA\u03CC \u039C\u03B5\u03BD\u03BF\u03CD");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		frmFoodRiders.getContentPane().add(label, gbc_label);
		
		JButton btnTrexousa = new JButton("\u03A4\u03C1\u03AD\u03C7\u03BF\u03C5\u03C3\u03B1 \u03BA\u03B1\u03C4\u03AC\u03C3\u03C4\u03B1\u03C3\u03B7");
		btnTrexousa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		frmFoodRiders.getContentPane().add(separator, gbc_separator);
		GridBagConstraints gbc_btnTrexousa = new GridBagConstraints();
		gbc_btnTrexousa.insets = new Insets(0, 0, 5, 0);
		gbc_btnTrexousa.fill = GridBagConstraints.BOTH;
		gbc_btnTrexousa.gridx = 0;
		gbc_btnTrexousa.gridy = 2;
		frmFoodRiders.getContentPane().add(btnTrexousa, gbc_btnTrexousa);
		
		JButton btnEstiatoria = new JButton("\u0395\u03C3\u03C4\u03B9\u03B1\u03C4\u03CC\u03C1\u03B9\u03B1");
		GridBagConstraints gbc_btnEstiatoria = new GridBagConstraints();
		gbc_btnEstiatoria.insets = new Insets(0, 0, 5, 0);
		gbc_btnEstiatoria.fill = GridBagConstraints.BOTH;
		gbc_btnEstiatoria.gridx = 0;
		gbc_btnEstiatoria.gridy = 3;
		frmFoodRiders.getContentPane().add(btnEstiatoria, gbc_btnEstiatoria);
		
		JButton btnParaggelies = new JButton("\u0399\u03C3\u03C4\u03BF\u03C1\u03B9\u03BA\u03CC \u03A0\u03B1\u03C1\u03B1\u03B3\u03B3\u03B5\u03BB\u03B9\u03CE\u03BD");
		GridBagConstraints gbc_btnParaggelies = new GridBagConstraints();
		gbc_btnParaggelies.insets = new Insets(0, 0, 5, 0);
		gbc_btnParaggelies.fill = GridBagConstraints.BOTH;
		gbc_btnParaggelies.gridx = 0;
		gbc_btnParaggelies.gridy = 4;
		frmFoodRiders.getContentPane().add(btnParaggelies, gbc_btnParaggelies);
		
		JButton btnYpalliloi = new JButton("\u039B\u03AF\u03C3\u03C4\u03B1 \u03A5\u03C0\u03B1\u03BB\u03BB\u03AE\u03BB\u03C9\u03BD");
		btnYpalliloi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiEmployees ge = new GuiEmployees();
				ge.EmployeesScreen();
			}
		});
		GridBagConstraints gbc_btnYpalliloi = new GridBagConstraints();
		gbc_btnYpalliloi.insets = new Insets(0, 0, 5, 0);
		gbc_btnYpalliloi.fill = GridBagConstraints.BOTH;
		gbc_btnYpalliloi.gridx = 0;
		gbc_btnYpalliloi.gridy = 5;
		frmFoodRiders.getContentPane().add(btnYpalliloi, gbc_btnYpalliloi);
		
		JButton btnStatistika = new JButton("\u03A3\u03C4\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03AC");
		GridBagConstraints gbc_btnStatistika = new GridBagConstraints();
		gbc_btnStatistika.insets = new Insets(0, 0, 5, 0);
		gbc_btnStatistika.fill = GridBagConstraints.BOTH;
		gbc_btnStatistika.gridx = 0;
		gbc_btnStatistika.gridy = 6;
		frmFoodRiders.getContentPane().add(btnStatistika, gbc_btnStatistika);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(5, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 7;
		frmFoodRiders.getContentPane().add(separator_1, gbc_separator_1);
		
		JButton btnAposindesi = new JButton("\u0391\u03C0\u03BF\u03C3\u03CD\u03BD\u03B4\u03B5\u03C3\u03B7");
		GridBagConstraints gbc_btnAposindesi = new GridBagConstraints();
		gbc_btnAposindesi.fill = GridBagConstraints.VERTICAL;
		gbc_btnAposindesi.gridx = 0;
		gbc_btnAposindesi.gridy = 8;
		frmFoodRiders.getContentPane().add(btnAposindesi, gbc_btnAposindesi);
	}
}
