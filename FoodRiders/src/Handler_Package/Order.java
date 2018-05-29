package Handler_Package;

public class Order {
	
	private Restaurant restaurant;
	private int prepareTime;
	private int orderCode;
	private String sentTime;
	
	public Order(Restaurant aRestaurant, int aPrepareTime, int anOrderCode, String aSentTime) {
		restaurant = aRestaurant;
		prepareTime = aPrepareTime;
		orderCode = anOrderCode;
		sentTime = aSentTime;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public int getPrepareTime() {
		return prepareTime;
	}
	public int getOrderCode() {
		return orderCode;
	}
	public String getSentTime() {
		return sentTime;
	}

}
