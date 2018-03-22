package Handler_Package;

import java.util.ArrayList;

public class Restaurant {
	
	private String name;
	private int  code;
	private String address;
	private String telephoneNum;
	private String email;
	private String timeDistance;
	private String comments;
	private ArrayList<Order>  orderHistory;
	
	
	public Restaurant( int aCode, String aName, String aAddress, String aTelephoneNum, String anEmail, String aTimeDistance, String someComments) {
		
		code = aCode;
		name = aName;
		address = aAddress;
		telephoneNum = aTelephoneNum;
		email = anEmail;
		timeDistance = aTimeDistance;
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


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
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


	public String getTimeDistance() {
		return timeDistance;
	}


	public void setTimeDistance(String timeDistance) {
		this.timeDistance = timeDistance;
	}


	public ArrayList<Order> getOrderHistory() {
		return orderHistory;
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

	public void setComments(String comments) {
		this.comments = comments;
	}
	

}
