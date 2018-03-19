package Handler_Package;

public class Order {
	
	private Restaurant restaurant;
	private String addressRestaurant;
	private String addressClient;
	private int prepareTime;
	private int orderCode;
	//+order time 
	public Order(Restaurant aRestaurant, String anAddressRestaurant, String anAddressClient, int aPrepareTime,
			int anOrderCode) {
		restaurant = aRestaurant;
		addressRestaurant = anAddressRestaurant;
		addressClient = anAddressClient;
		prepareTime = aPrepareTime;
		orderCode = anOrderCode;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public String getAddressRestaurant() {
		return addressRestaurant;
	}
	public String getAddressClient() {
		return addressClient;
	}
	public int getPrepareTime() {
		return prepareTime;
	}
	public int getOrderCode() {
		return orderCode;
	}
	
	

}
