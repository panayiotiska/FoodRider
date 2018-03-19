package Main;

import javax.swing.UnsupportedLookAndFeelException;

import Login_Screen_Package.Login_Screen;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		
		Login_Screen window = new Login_Screen();
		window.startApplication();

	}

}
