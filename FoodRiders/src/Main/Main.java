package Main;

import java.net.MalformedURLException;

import javax.swing.UnsupportedLookAndFeelException;

import Handler_Package.Handler;
import Login_Screen_Package.Database;
import Login_Screen_Package.Login_Screen;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
												  UnsupportedLookAndFeelException, MalformedURLException {
		Handler data = new Handler();// !!!aData is the Handler object data which has all the buisiness' data and will be sent all over the project
		//Database db = new Database(); // This object will be resposible for adding new clients into the database class , so they can login later with their username and password!
		Login_Screen window = new Login_Screen(data);
		window.showLoginScreen(data);  

		
	}

}