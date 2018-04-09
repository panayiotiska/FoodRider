package Handler_Package;

public class Vehicle {
	
	private String plate;
	private String type;
	private String brand;
	private String model;
	private String purchaseDate;
	private boolean status;
	
	
	public Vehicle(String aPlate, String aType, String aBrand, String aModel, String aPurchaseDate, boolean aStatus) {
	
		plate = aPlate;
		type = aType;
		brand = aBrand;
		model = aModel;
		purchaseDate = aPurchaseDate;
		status = aStatus;
	}


	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public boolean getStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
