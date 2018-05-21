package Handler_Package;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class runOrder implements Runnable{


	Handler data;
	Order order;
	
	public runOrder(Handler aData,Order anOrder) {
		data = aData;
		order = anOrder;
	}
	
	public void run() {
		
		Queue<Staff> staffAvailable = data.getStaffAvailable();
		Queue<Staff> staffUnavailable = data.getStaffUnavailable();
		Queue<Vehicle> vehiclesAvailable = data.getVehiclesAvailable();
		Queue<Vehicle> vehiclesUnavailable = data.getVehiclesUnavailable();
		Queue<Order> runningOrders = data.getRunningOrders();
		Queue<Order> ordersInQueue = data.getOrdersInQueue();
	
		if(!(staffAvailable.isEmpty()) && !(vehiclesAvailable.isEmpty())) {
			Staff staffAssigned = staffAvailable.peek();				  //Holds the staff and vehicles assigned in order to make those available
			Vehicle vehicleAssigned = vehiclesAvailable.peek();			 //when the order completes and not a random staff and vehicle from the 
			data.assignStaffAndVehicleAndManageOrder(order, true);		// unavailable lists.
			int completeTime = order.getPrepareTime() + order.getRestaurant().getTimeDistance(); 
			try {											// the thread computes the time the staff with the vehicle
				TimeUnit.SECONDS.sleep(completeTime);		// need to complete the order and makes unavailable 
			} catch (InterruptedException e) {					// that staff and vehicle during that time.
				e.printStackTrace();
			}
			System.out.println("Order completed after " + completeTime + " seconds.");
			data.unassignStaffAndVehicleAndAddOrderToHistory(staffAssigned, vehicleAssigned, order); //When the thread awakes, the order has been 
																									//completed, the staff and vehicle are becoming 
																								   //again available, the order is being added to 
		}else {																					  //the Order History and the thread checks if there
			data.assignStaffAndVehicleAndManageOrder(order, false);								 //is an order waiting in OrdersInQueue. If there is
		}																						//one, then the thread starts another runOrder from 
																							   //handler and after that this thread dies.
	}
	

	
	
	
	
	
}
