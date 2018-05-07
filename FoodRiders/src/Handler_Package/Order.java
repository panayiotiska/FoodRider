package Handler_Package;

public class Order {
	
	private Restaurant restaurant;
	private int prepareTime;
	private int orderCode;
	//+order time 
	public Order(Restaurant aRestaurant, int aPrepareTime, int anOrderCode) {
		restaurant = aRestaurant;
		prepareTime = aPrepareTime;
		orderCode = anOrderCode;
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
	
	

}
