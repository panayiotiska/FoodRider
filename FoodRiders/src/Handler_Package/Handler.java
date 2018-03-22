package Handler_Package;

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

		staffAvailable =new LinkedList<>();
		vehiclesAvailable = new LinkedList<>();

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
	public void addStaff(Staff aStaff) {
		staffList.add(aStaff);
	}
	
	public void addVehicle(Vehicle aVehicle) {
		vehicles.add(aVehicle);
	}
	
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}
		
}
