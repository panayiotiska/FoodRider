package Handler_Package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Handler {

	private ArrayList<Restaurant> restaurantsList;
	private ArrayList<Staff> staffList;
	private ArrayList<Vehicle> vehiclesList;
	private ArrayList<Order> OrderHistory;
	
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
		vehiclesList = new ArrayList<>();
		OrderHistory = new ArrayList<>();
		staffAvailable = new LinkedList<>();
		staffUnavailable = new LinkedList<>();
		vehiclesAvailable = new LinkedList<>();
		vehiclesUnavailable = new LinkedList<>();
		runningOrders = new LinkedList<>();
		ordersInQueue = new LinkedList<>();
		
		//ADD DUMMY VALUES INTO TABLES 
		//DUMMY RESTAURANTS
		Restaurant dummyRestaurant1 = new Restaurant(0,"Makis Pizza","egnatia 12","69696969","makispizza@yahoo.de",2,"no-comment");
		Restaurant dummyRestaurant2 = new Restaurant(1,"Babis Pizza","egnatia 13","69696969","babispizza@yahoo.de",4,"no-comment");
		Restaurant dummyRestaurant3 = new Restaurant(2,"Lakis Pizza","egnatia 14","69696969","lakispizza@yahoo.de",8,"no-comment");
		
		restaurantsList.add(dummyRestaurant1);
		restaurantsList.add(dummyRestaurant2);
		restaurantsList.add(dummyRestaurant3);
		
		//DUMMY STAFF LIST
		Staff dummyStaff1 = new Staff(0,"Ben","driver","08/04/90","23/08/18","6987451269");
		Staff dummyStaff2 = new Staff(1,"Nick","driver","21/11/85","04/06/17","6945472016");
		Staff dummyStaff3 = new Staff(3,"John","driver","06/02/93","12/03/18","6947763650");
		
		staffList.add(dummyStaff1);
		staffList.add(dummyStaff2);
		staffList.add(dummyStaff3);
		//DUMMY VEHICLES
		Vehicle dummyVehicle1 = new Vehicle("YX-6574","Street/Standar","Ducati","Monster 821","18/10/17",true);
		Vehicle dummyVehicle2 = new Vehicle("AT-4521","Street/Cruiser","Harley Davidson","Street 750","15/10/17",true);
		Vehicle dummyVehicle3 = new Vehicle("BI-6892","Chopper","Yamaha","Chopper 2005","20/10/17",true);
		
		vehiclesList.add(dummyVehicle1);
		vehiclesList.add(dummyVehicle2);
		vehiclesList.add(dummyVehicle3);
		
		//AT THE START OF THE PROGRAM, THE VEHICLES ARE ADDED TO AVAILABLE OR UNAVAILABLE LIST, DEPENDING ON THEIR TRUE OR FALSE STATUS
		for(Vehicle aVehicle : vehiclesList) {
			if(aVehicle.getStatus() == true) {
				vehiclesAvailable.add(aVehicle);
			}else {
				vehiclesUnavailable.add(aVehicle);
			}
		}
		for(Vehicle aveh : vehiclesAvailable) {
			System.out.println(aveh.getModel() + aveh.getBrand());
		}
		//AT THE START OF THE PROGRAM, THE STAFF ARE ALL ADDED TO AVAILABLE LIST 
		staffAvailable.addAll(staffList);
		
		
		
	}
	public void assignStaffAndVehicleAndManageOrder(Order anOrder,boolean immidiateStart) {
		if(immidiateStart){
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
	
	public void unassignStaffAndVehicleAndAddOrderToHistory(Staff aStaff, Vehicle aVehicle, Order anOrder) {
		staffUnavailable.remove(aStaff);
		staffAvailable.add(aStaff);
		vehiclesUnavailable.remove(aVehicle);
		vehiclesAvailable.add(aVehicle);
		runningOrders.remove(anOrder);
		OrderHistory.add(anOrder);
		
	}
	
	
	public void orderStart(Order anOrder) {
		Thread order = new Thread(new runOrder(this,anOrder));
		order.start();
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
		vehiclesList.add(aVehicle);
		vehiclesAvailable.add(aVehicle);
	}
	
	public boolean isVehicleAvailable(String aPlate) {
	for(Vehicle aVehicle : vehiclesAvailable){
		if (aVehicle.getPlate() == aPlate) {
			return true;
		}
	}
	return false;
	}
	
	public void deleteVehicle(String aPlate) {
		for(int i = 0; i< vehiclesList.size(); i++){
			if (vehiclesList.get(i).getPlate() == aPlate) {
				vehiclesList.remove(i);
			}
		}
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
		return vehiclesList;
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


	public ArrayList<Order> getOrderHistory() {
		return OrderHistory;
	}


	public ArrayList<Vehicle> getVehiclesList() {
		return vehiclesList;
	}


	public Queue<Staff> getStaffUnavailable() {
		return staffUnavailable;
	}


	public Queue<Vehicle> getVehiclesUnavailable() {
		return vehiclesUnavailable;
	}
	
	
	
	
}
