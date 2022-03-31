/**
 * This class is a wrapper for a Staff member and a number of hours.
 * This is for the report functions only: for hours to be worked by staff members, see the Shift class.
 * @author Jo Butler
 * @version 1
 */
 
public class StaffHours{
	public Staff staffMember;
	public double hours;
	
	// Constructor - JB
	public StaffHours(Staff staffMember, double hours){
		this.staffMember = staffMember;
		this.hours = hours;
	}
}