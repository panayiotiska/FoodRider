package Handler_Package;

import java.util.ArrayList;

public class Restaurant {
	
	private String name;
	private int  code;
	private String address;
	private String telephoneNum;
	private int timeDistance;
	private ArrayList<Order>  orderHistory;
	
	
	public Restaurant(String aName, int aCode, String aAddress, String aTelephoneNum, int aTimeDistance) {
		
		name = aName;
		code = aCode;
		address = aAddress;
		telephoneNum = aTelephoneNum;
		timeDistance = aTimeDistance;
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


	public int getTimeDistance() {
		return timeDistance;
	}


	public void setTimeDistance(int timeDistance) {
		this.timeDistance = timeDistance;
	}


	public ArrayList<Order> getOrderHistory() {
		return orderHistory;
	}
	
	
	
	

}
