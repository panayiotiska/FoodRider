package Handler_Package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Handler {

	private ArrayList<Restaurant> restaurantsList;
	private ArrayList<Staff> staffList;
	private ArrayList<Vehicle> vehicles;
	private ArrayList<Vehicle> OrderHistory;
	
	private Queue<Staff> staffAvailable;
	private Queue<Staff> staffUnavailable ;
	
	private Queue<Vehicle> vehiclesAvailable;
	private Queue<Vehicle> vehiclesUnavailable ;
	
	private Queue<Order> runningOrders ;
	private Queue<Order> ordersInQueue ;
	
	private Current_Status lockedWindow = null;
	
	
	public Handler() {
		restaurantsList = new ArrayList<>();
		staffList = new ArrayList<>();
		vehicles = new ArrayList<>();
		OrderHistory = new ArrayList<>();
		staffAvailable = new LinkedList<>(staffList);
		staffUnavailable = new LinkedList<>();
		vehiclesAvailable = new LinkedList<>(vehicles);
		runningOrders = new LinkedList<>();
		ordersInQueue = new LinkedList<>();
		
		//ADD DUMMY VALUES INTO TABLES
		
		Restaurant dummyRestaurant1 = new Restaurant(0,"Makis Pizza","egnatia 12","69696969","makispizza@yahoo.de","20","no-comment");
		Restaurant dummyRestaurant2 = new Restaurant(1,"Babis Pizza","egnatia 13","69696969","babispizza@yahoo.de","21","no-comment");
		Restaurant dummyRestaurant3 = new Restaurant(2,"Lakis Pizza","egnatia 14","69696969","lakispizza@yahoo.de","22","no-comment");
		
		restaurantsList.add(dummyRestaurant1);
		restaurantsList.add(dummyRestaurant2);
		restaurantsList.add(dummyRestaurant3);
	}
	
	
	public void orderSubmission(Order anOrder) {
		if(!(staffAvailable.isEmpty()) && !(vehiclesAvailable.isEmpty())) {
			Staff aStaff = staffAvailable.peek();
			staffAvailable.remove();
			staffUnavailable.add(aStaff);
			Vehicle aVehicle = vehiclesAvailable.peek();
			vehiclesAvailable.remove();
			vehiclesUnavailable.add(aVehicle);
			runningOrders.add(anOrder);	
		}else {
			ordersInQueue.add(anOrder);
		}
		
	}
	
	public void addRestaurant(Restaurant aRestaurant) {
		restaurantsList.add(aRestaurant);
	}
	
	public void deleteRestaurant(int anID) {
		for(int i = 0; i < restaurantsList.size(); i++){
			if(restaurantsList.get(i).getId() == anID) {
				restaurantsList.remove(i);
			}
		}
	}
	
	public Restaurant findRestaurantFromClient(int restaurantID){
		for (Restaurant r : restaurantsList){
			if (r.getId() == restaurantID){
				return r;
			}
		}
		return null;
	}
	
	public void addStaff(Staff aStaff) {
		staffList.add(aStaff);
		staffAvailable.add(aStaff);
	}
	
	public boolean deleteStaff(int anID) {
		boolean found = false;
		for(Staff s : staffAvailable){
			if (s.getId() == anID) {
				found = true;
				staffAvailable.remove(s);
				staffList.remove(s);
			}
		}
		return found;	
	}

	public void addVehicle(Vehicle aVehicle) {
		vehicles.add(aVehicle);
		vehiclesAvailable.add(aVehicle);
	}
	
	public boolean deleteVehicle(String aPlate) {
		boolean found = false;
		for(Vehicle v : vehiclesAvailable){
			if (v.getPlate() == aPlate) {
				found = true;
				vehiclesAvailable.remove(v);
				vehicles.remove(v);
			}
		}
		return found;
	}
	
	public Current_Status getLockedWindow() {
		return lockedWindow;
	}


	public void setLockedWindow(Current_Status lockedWindow) {
		this.lockedWindow = lockedWindow;
	}
	
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public ArrayList<Restaurant> getRestaurantsList() {
		return restaurantsList;
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public Queue<Staff> getStaffAvailable() {
		return staffAvailable;
	}

	public Queue<Vehicle> getVehiclesAvailable() {
		return vehiclesAvailable;
	}

	public Queue<Order> getRunningOrders() {
		return runningOrders;
	}

	public Queue<Order> getOrdersInQueue() {
		return ordersInQueue;
	}


	public ArrayList<Vehicle> getOrderHistory() {
		return OrderHistory;
	}
	
}
