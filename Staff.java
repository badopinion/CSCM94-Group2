import java.util.ArrayList;
import java.util.Date;

public class Staff extends User{

    private int staffId;

    private ArrayList<Shift> shifts = new ArrayList<Shift>();

    //Constructor - OJ

    public Staff(String username, String password, String firstName, String lastName, int staffId, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);

        this.staffId = staffId;
    }

    //Getters - OJ
    public int getStaffId() {
        return staffId;
    }


    // Method returns arrayList of shifts
    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    //Setters - OJ
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }


}