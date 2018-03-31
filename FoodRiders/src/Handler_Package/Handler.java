package Handler_Package;

import java.awt.Component;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Handler {

	private ArrayList<Restaurant> restaurantsList;
	private ArrayList<Staff> staffList;
	private ArrayList<Vehicle> vehicles;
	
	private Queue<Staff> staffAvailable;
	private Queue<Staff> staffUnavailable ;
	
	private Queue<Vehicle> vehiclesAvailable;
	private Queue<Vehicle> vehiclesUnavailable ;
	
	private Queue<Order> runningOrders ;
	private Queue<Order> ordersInQueue ;
	
	
	public Handler() {
		restaurantsList = new ArrayList<>();
		staffList = new ArrayList<>();
		vehicles = new ArrayList<>();
		staffAvailable = new LinkedList<>(staffList);
		vehiclesAvailable = new LinkedList<>(vehicles);
		runningOrders = new LinkedList<>();
		ordersInQueue = new LinkedList<>();
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
	
	public void addStaff(Staff aStaff) {
		staffList.add(aStaff);
	}
	
	public void deleteStaff(int anID) {
		for(int i = 0; i < staffList.size(); i++){
			if(staffList.get(i).getId() == anID) {
				staffList.remove(i);
			}
		}
	}
	
	public void addVehicle(Vehicle aVehicle) {
		vehicles.add(aVehicle);
	}
	
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public ArrayList<Restaurant> getRestaurantsList() {
		return restaurantsList;
	}
		
}
