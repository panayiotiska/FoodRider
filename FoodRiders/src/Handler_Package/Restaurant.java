package Handler_Package;

import java.util.ArrayList;

public class Restaurant {
	
	private String name;
	private int  code;
	private String address;
	private String telephoneNum;
	private String timeDistance;
	private String email;
	private String comments;
	private ArrayList<Order>  orderHistory;
	
	
	public Restaurant(int aCode, String aName, String aAddress, String aTelephoneNum, String anEmail, String aTimeDistance, String someComments) {
		
		name = aName;
		code = aCode;
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
	
	
	
	

}
