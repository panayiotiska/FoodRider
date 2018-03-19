package Handler_Package;

public class Vehicle {
	
	private String plate;
	private String brand;
	private String model;
	private boolean status;
	
	
	public Vehicle(String aPlate, String aBrand, String aModel, boolean aStatus) {
	
		plate = aPlate;
		brand = aBrand;
		model = aModel;
		status = aStatus;
	}
	

	
	
	
	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	
	

}
