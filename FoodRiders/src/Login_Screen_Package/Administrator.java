package Login_Screen_Package;

public class Administrator extends User{

	private String name; 
	private String password;
	private String subscriptionDate;
	
	public Administrator(String aName, String aPassword, String aSubscriptionDate) {
		super(aName, aPassword, aSubscriptionDate);
		
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
