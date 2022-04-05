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


    /**
     * Constructor
     * @param username the staff's username
     * @param password the staff's password
     * @param firstName the staff's firstname
     * @param lastName the staff's lastname
     * @param homeAddress the staff's home address
     */


    //Constructor - OJ
    //Added StaffTypeEnum to tell the difference between the staff (look at driver,chef,waiter they are same class not need to have 3) SR
    public Staff(String username, String password, String firstName, String lastName, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);

    }


    //Getters - OJ
    public int getStaffId() {
        return staffId;
    }


    /**
     *  Method returns arrayList of shifts
     * @return returns the shifts
     */
    public ArrayList<Shift> getShifts() {
        return shifts;
    }


    //Setters - OJ
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }


}