package Login_Screen_Package;

public abstract class User {
	
	private String name; 
	private String password;
	private String subscriptionDate;
	
	public User(String aName, String aPassword, String aSubscriptionDate) {
		name = aName;
		password = aPassword;
		subscriptionDate = aSubscriptionDate;
	}

	public String getName() {
		return name;
	}


	public String getPassword() {
		return password;
	}

	public String getSubscriptionDate() {
		return subscriptionDate;
	}

	
}
