package Handler_Package;
 
public class Staff {
   
    private int id;
    private String name;
    private String position;
    private String dateOfBirth;
    private String recruitmentDate;
 
   
    public Staff(int id, String name, String position, String dateOfBirth, String recruitmentDate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.recruitmentDate = recruitmentDate;
    }
 
    public String getPosition() {
        return position;
    }
 
    public void setPosition(String position) {
        this.position = position;
    }
 
    public String getDateOfBirth() {
        return dateOfBirth;
    }
 
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 
    public String getRecruitmentDate() {
        return recruitmentDate;
    }
 
    public void setRecruitmentDate(String recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
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