package Login_Screen_Package;

import java.util.ArrayList;

public class Database {

	private ArrayList<User> administrators;
	private ArrayList<User> clients;
	private int LoginType;

	public Database() {
		
		administrators = new ArrayList<>();
		clients = new ArrayList<>();
		
		User user1 = new User("vaggos", "vaggos", "15/2/14");
		User user2 = new User("vicky", "vicky", "25/4/15");  
		User user3 = new User("panos", "panos", "31/5/17");
		User user4= new User("tasos", "tasos", "31/5/17");

		administrators.add(user3);
		administrators.add(user1);
		
		clients.add(user2);
		clients.add(user4);
		
	}

	public boolean checkData(String aGivenUsername, String aGivenPassword){

		for(User anAdmin : administrators){
			if(anAdmin.getName().equals(aGivenUsername) && anAdmin.getPassword().equals(aGivenPassword)) {
				LoginType = 1;
				return true;
			}
		}
		for(User aClient : clients) {
			if(aClient.getName().equals(aGivenUsername) && aClient.getPassword().equals(aGivenPassword)) {
				LoginType = 2;
				return true;
			}
		}
		return false;
	}

	public int getLoginType() {
		return LoginType;
	}
		
}
