package Handler_Package;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class runOrder implements Runnable{


	Handler data;
	Order order;
	int orderStatus; 													  //Order Status is used so the thread will know if it receives an order that
																		 //has been on queue, so to remove the order from the queue list, or if it 
	public runOrder(Handler aData,Order anOrder,int anOrderStatus) {	//receives a new order that hasn't been on the queue list, so to do all those
		data = aData;												   //operations needed, except removing the order from the queue list.
		order = anOrder;											  //During the program, anOrderStatus takes two possible values: 
		orderStatus = anOrderStatus;								 // 1 : The order is a new one, 2: The order is coming from the queue list.
	}
	
	public void run() {
		
		Queue<Staff> staffAvailable = data.getStaffAvailable();
		Queue<Vehicle> vehiclesAvailable = data.getVehiclesAvailable();
		Queue<Order> ordersInQueue = data.getOrdersInQueue();
		
		if(orderStatus == 1) {
			if(!(staffAvailable.isEmpty()) && !(vehiclesAvailable.isEmpty())) {
				Staff staffAssigned = staffAvailable.peek();				  //Holds the staff and vehicles assigned in order to make those available
				Vehicle vehicleAssigned = vehiclesAvailable.peek();			 //when the order completes and not a random staff and vehicle from the 
				data.assignStaffAndVehicleAndManageOrder(order, true);		// unavailable lists.
				int completeTime = order.getPrepareTime() + order.getRestaurant().getTimeDistance(); 
				try {												 // the thread computes the time the staff with the vehicle
					TimeUnit.SECONDS.sleep(completeTime);			// need to complete the order and makes unavailable 
				} catch (InterruptedException e) {				   // that staff and vehicle during that time.
					e.printStackTrace();
				}
				data.unassignStaffAndVehicleAndAddOrderToHistory(staffAssigned, vehicleAssigned, order); 
				if(!(ordersInQueue.isEmpty())) {									   //When the thread awakes, the order has been 	
					Order anOrder = ordersInQueue.peek();							  //completed, the staff and vehicle are becoming
					Thread order = new Thread(new runOrder(data,anOrder,2));		 //the Order History and the thread checks if there
					order.start();													//is an order waiting in OrdersInQueue. If there is
				}
				System.out.println("Order completed after " + completeTime + " seconds.");    																						   //again available, the order is being added to 
			}else {																			  
				data.assignStaffAndVehicleAndManageOrder(order, false);						
			}																			   
		}else if(orderStatus == 2){
			if(!(staffAvailable.isEmpty()) && !(vehiclesAvailable.isEmpty())) {
				ordersInQueue.remove(order);
				Staff staffAssigned = staffAvailable.peek();				 
				Vehicle vehicleAssigned = vehiclesAvailable.peek();			
				data.assignStaffAndVehicleAndManageOrder(order, true);		
				int completeTime = order.getPrepareTime() + order.getRestaurant().getTimeDistance(); 
				try {											
					TimeUnit.SECONDS.sleep(completeTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data.unassignStaffAndVehicleAndAddOrderToHistory(staffAssigned, vehicleAssigned, order); 
				if(!(ordersInQueue.isEmpty())) {
					Order anOrder = ordersInQueue.peek();
					Thread order = new Thread(new runOrder(data,anOrder,2));
					order.start();
				}
				System.out.println("Order completed after " + completeTime + " seconds.");																		//one, then the thread starts another runOrder from 
			}
		}																					 //handler and after that this thread dies.

	}

}
