import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.time.temporal.*;
import java.util.*;

/**
 * Class to be instantiated for the purpose of generating reports.
 * @author Jo Butler
 * @version 1
 */

public class Report{

    // Constructor - empty. Information is pulled from elsewhere.
    public Report(){
        
    }

    // Generate most popular item report
	
	// Generate busiest period report
	
	// Generate most active customer report
	
	// Generate highest number of hours worked by staff report
	public ArrayList<StaffHours> hoursWorkedReport(Restaurant r){
		ArrayList<StaffHours> res1 = new ArrayList<StaffHours>();
		for(Staff staff : r.login.getStaffList()){
			double hours = 0;
			for(Shift shift : staff.getShifts()){
				if(shift.getShiftApproved()){
					hours += shift.getStart().until(shift.getEnd(),ChronoUnit.HOURS);
				}
			}
			res1.add(new StaffHours(staff, hours));
		}
		ArrayList<StaffHours> res2 = new ArrayList<StaffHours>();
		
		// Sort result list in descending order.
		while(res1.size() > 0){
			double highest = -1;
			int indexOfHighest = -1;
			for(int i = 0; i < res1.size(); i++){
				if(res1.get(i).hours > highest){
					highest = res1.get(i).hours;
					indexOfHighest = i;
				}
			}
			res2.add(res1.get(indexOfHighest));
			res1.remove(indexOfHighest);
		}
		
		return res2;
	}
}