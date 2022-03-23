import java.util.ArrayList;
import java.util.Date;

public class Staff extends User{

    private String firstName;
    private String lastName;
    private int staffId;
    private String homeAddress;
    private ArrayList<Shift> shifts = new ArrayList<Shift>();

    //Constructor
    public Staff(String username, String password, String firstName, String lastName, int staffId, String homeAddress){
		super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffId = staffId;
        this.homeAddress = homeAddress;
    }

    //Getters below

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    //Setters below

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}