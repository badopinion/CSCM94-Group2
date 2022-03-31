import java.util.ArrayList;

/**
 * A staff class (child of user). All staff share the responsibility
 * @author Oliver Jackson, Jo Butler
 * @version 1
 */


public class Staff extends User{

    private ArrayList<Shift> shifts = new ArrayList<Shift>();

    //Constructor - OJ

    public Staff(String username, String password, String firstName, String lastName, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);
    }

    // Method returns arrayList of shifts - OJ
    public ArrayList<Shift> getShifts() {
        return shifts;
    }

	// Adds a shift to the user's shift list. JB
	public void addShift(Shift newShift){
		shifts.add(newShift);
	}
	
	// Approves a shift. JB
	public void approveShift(Shift shiftToApprove){
		for(Shift s : shifts){
			if(s == shiftToApprove){
				s.setShiftApproved(true);
			}
		}
	}
}