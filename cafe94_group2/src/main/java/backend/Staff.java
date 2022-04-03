package backend;

import java.util.ArrayList;

/**
 * A staff class (child of user)
 * @author Oliver Jackson
 * @version 1
 */


public class Staff extends User{

    private int staffId;

    private ArrayList<Shift> shifts = new ArrayList<Shift>();


    //Constructor - OJ
    //Added StaffTypeEnum to tell the difference between the staff (look at driver,chef,waiter they are same class not need to have 3) SR
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