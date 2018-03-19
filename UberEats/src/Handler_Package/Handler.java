package Handler_Package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Handler {

	private ArrayList<Restaurant> restaurantsList = new ArrayList<>();
	private ArrayList<Staff> staffList = new ArrayList<>();
	private ArrayList<Vehicle> vehicles = new ArrayList<>();
	
	private Queue<Staff> staffAvailable = new LinkedList<>();
	private Queue<Staff> staffUnavailable = new LinkedList<>();
	
	private Queue<Vehicle> vehiclesAvailable = new LinkedList<>();
	private Queue<Vehicle> vehiclesUnavailable = new LinkedList<>();
	
	private Queue<Order> runningOrders = new LinkedList<>();
	private Queue<Order> ordersInQueue = new LinkedList<>();
	
	
	
	
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
	
	
}
