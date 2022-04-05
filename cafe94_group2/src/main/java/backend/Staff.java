package backend;

import java.util.ArrayList;

/**
 * A staff class (child of user)
 * @author Oliver Jackson
 * @version 1
 */


public class Staff extends User{

    private ArrayList<Shift> shifts = new ArrayList<Shift>();

    /**
     * Constructor
     * @param username the staff's username
     * @param password the staff's password
     * @param firstName the staff's firstname
     * @param lastName the staff's lastname
     * @param homeAddress the staff's home address
     */

    public Staff(String username, String password, String firstName, String lastName, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);

    }


    /**
     *  Method returns arrayList of shifts
     * @return returns the shifts
     */
    public ArrayList<Shift> getShifts() {
        return shifts;
    }



}