package Login_Screen_Package;

import java.util.ArrayList;

public class Database {

	private ArrayList<User> users;

	public Database() {
		
		users = new ArrayList<>();
		
		User user1 = new User("Vaggos", "vaggos", "15/2/14");
		User user2 = new User("Vicky", "vicky", "25/4/15");
		User user3 = new User("Tasos", "tasos", "31/5/17");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	}

	public boolean checkData(String aGivenUsername, String aGivenPassword){
		
		boolean flag = false;
		
		for(User aUser : users){
			if(aUser.getName().equals(aGivenUsername)) {
				flag = true;
			}
		}
		return flag;
	}
	
	
}
