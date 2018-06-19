/*
 ************************* IMPORTANT **********************************
 *
 * In order statistics run properly, please import RCaller library from
 * 
 * Project rest files/External Jars/ !!
 * 
 * 
 */

package Main;

import java.net.MalformedURLException;

import javax.swing.UnsupportedLookAndFeelException;

import Handler_Package.Handler;
import Login_Screen_Package.Login_Screen;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
												  UnsupportedLookAndFeelException, MalformedURLException {
		Handler data = new Handler();// !!!data is the Handler object data which has all the buisiness' data and will be sent all over the project
		Login_Screen window = new Login_Screen(data);
		window.showLoginScreen(data);  

		
	}

}