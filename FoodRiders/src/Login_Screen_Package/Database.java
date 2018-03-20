package Login_Screen_Package;

import java.util.ArrayList;

public class Database {

	private ArrayList<User> administrators;
	private ArrayList<User> clients;
	private int LoginType;

	public Database() {
		
		administrators = new ArrayList<>();
		clients = new ArrayList<>();
		
		User user1 = new User("Vaggos", "vaggos", "15/2/14");
		User user2 = new User("Vicky", "vicky", "25/4/15");  
		User user3 = new User("Tasos", "tasos", "31/5/17");
		User user4 = new User("Panos", "panos", "1/1/11");

		administrators.add(user1);
		administrators.add(user2);
		clients.add(user3);
		clients.add(user4);
		//commit done 
		
	}

	public boolean checkData(String aGivenUsername, String aGivenPassword){

		for(User anAdmin : administrators){
			if(anAdmin.getName().equals(aGivenUsername)) {
				LoginType = 1;
				return true;
			}
		}
		for(User aClient : clients) {
			if(aClient.getName().equals(aGivenUsername)) {
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
