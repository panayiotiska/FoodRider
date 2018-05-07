package Login_Screen_Package;

import java.util.ArrayList;

public class Database {

	private ArrayList<Administrator> administrators;
	private ArrayList<Client> clients;
	private int LoginType;

	public Database() {
		
		administrators = new ArrayList<>();
		clients = new ArrayList<>();
		
		Administrator user1 = new Administrator("vaggos", "vaggos", "15/2/14");
		 
		Administrator user2 = new Administrator("panos", "panos", "31/5/17");
		
		Client user3 = new Client("tasos", "tasos", "31/5/17",0);
		Client user4 = new Client("vicky", "vicky", "7/6/18",1); 

		administrators.add(user1);
		administrators.add(user2);

		clients.add(user3);
		
	}

	public boolean checkData(String aGivenUsername, String aGivenPassword){

		for(Administrator anAdmin : administrators){
			if(anAdmin.getName().equals(aGivenUsername) && anAdmin.getPassword().equals(aGivenPassword)) {
				LoginType = 1;
				return true;
			}
		}
		for(Administrator aClient : clients) {
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
	
	public Client findClientByUsername(String username){
		for (Client c : clients){
			if(username.equals(c.getName())){
				return c;
			}
		}
		return null;
	}
}
