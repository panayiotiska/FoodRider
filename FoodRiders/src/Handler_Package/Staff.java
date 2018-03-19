package Handler_Package;

public class Staff {
	
	private int id;
	private String name;
	
	
	
	public Staff(int anId, String aName) {
	
		id = anId;
		name = aName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
