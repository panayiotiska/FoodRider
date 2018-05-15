package Login_Screen_Package;

public class Client extends User {

	private int restaurantID;
	
	public Client(String aName, String aPassword, String aSubscriptionDate, int anID ) {
		super(aName, aPassword, aSubscriptionDate);
		restaurantID = anID;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

}
