package Handler_Package;

public class Staff {
	
	private int id;
	private String name;
	private String position;
	private int age;
	private String recruitmentDate;
	
	
	
	public Staff(int anId, String aName, String position, int age, String recruitmentDate) {
	
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
