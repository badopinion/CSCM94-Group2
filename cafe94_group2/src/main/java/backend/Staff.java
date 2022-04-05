package backend;

import java.util.ArrayList;

/**
 * A staff class (child of user)
 * @author Oliver Jackson
 * @version 1
 */


public class Staff extends User{

    private ArrayList<Shift> shifts = new ArrayList<Shift>();

    //Constructor - OJ

    public Staff(String username, String password, String firstName, String lastName, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);

    }


    // Method returns arrayList of shifts
    public ArrayList<Shift> getShifts() {
        return shifts;
    }



}