package Handler_Package;

import java.util.ArrayList;

public class Restaurant {
	
	private static int  IDsetter = 2;
	

	private String name;
	private int  id;
	private String address;
	private String telephoneNum;
	private int timeDistance;
	private String email;
	private String comments;
	private ArrayList<Order>  orderHistory;
	
	
	public Restaurant(int aID, String aName, String aAddress, String aTelephoneNum, String anEmail, int aTimeDistance, String someComments) {
		
		name = aName;
		id = aID;
		address = aAddress;
		telephoneNum = aTelephoneNum;
		timeDistance = aTimeDistance;
		email = anEmail;
		comments = someComments;
		orderHistory = new ArrayList<>();
	}
	
	public void addOrderToHistory(Order anOrder) {
		
		orderHistory.add(anOrder);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephoneNum() {
		return telephoneNum;
	}

	public void setTelephoneNum(String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}

	public int getTimeDistance() {
		return timeDistance;
	}

	public void setTimeDistance(int timeDistance) {
		this.timeDistance = timeDistance;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComments() {
		return comments;
	}

	public static int getIDsetter() {
		IDsetter ++;
		return IDsetter;
	}
	
	
	public void setComments(String comments) {
		this.comments = comments;
	}

	public ArrayList<Order> getOrderHistory() {
		return orderHistory;
	}
}
