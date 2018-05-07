package Login_Screen_Package;

public class Administrator {

	private String name; 
	private String password;
	private String subscriptionDate;
	
	public Administrator(String aName, String aPassword, String aSubscriptionDate) {
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

	
}
