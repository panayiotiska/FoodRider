package Login_Screen_Package;

import java.util.ArrayList;


public class Database {

	static ArrayList<Administrator> administrators;
	static ArrayList<Client> clients;
	static int LoginType;

	static {
		
		administrators = new ArrayList<>();
		clients = new ArrayList<>();
		
		Administrator user1 = new Administrator("vaggos", "vaggos", "15/2/14");
		Administrator user2 = new Administrator("panos", "panos", "31/5/17");
		
		Client user3 = new Client("tasos", "tasos", "31/5/17",0);
		Client user4 = new Client("vicky", "vicky", "7/6/18",1); 
		Client user5 = new Client("mitsos", "mitsos", "9/6/18",2); 

		administrators.add(user1);
		administrators.add(user2);

		clients.add(user3);
		clients.add(user4);
		clients.add(user5);
		
	}

	public static boolean checkData(String aGivenUsername, String aGivenPassword){

		for(Administrator anAdmin : administrators){
			if(anAdmin.getName().equals(aGivenUsername) && anAdmin.getPassword().equals(aGivenPassword)) {
				LoginType = 1;
				return true;
			}
		}
		for(Client aClient : clients) {
			if(aClient.getName().equals(aGivenUsername) && aClient.getPassword().equals(aGivenPassword)) {
				LoginType = 2;
				return true;
			}
		}
		return false;
	}

	public static int getLoginType() {
		return LoginType;
	}
	
	public static void addClient(Client aClient) {
		clients.add(aClient);
	}
	
	public static Client findClientByUsername(String username){
		for (Client c : clients){
			if(username.equals(c.getName())){
				return c;
			}
		}
		return null;
	}
	
	public static Client findClientByRestaurantID(int restaurantID) {
		for (Client c : clients){
			if(restaurantID == c.getRestaurantID()){
				return c;
			}
		}
		return null;
	}

	public static void deleteClientByRestaurantID(int restaurantID) {
		for(int i = 0; i < clients.size(); i++){
			if(clients.get(i).getRestaurantID() == restaurantID) {
				clients.remove(i);
			}
		}
		
	}
}
