import java.util.ArrayList;
import java.util.Date;
/**
 * Save class
 * @author Sam Raine/ADAM
 * @version 1
 */
public class GenerateReport {
    private float convertShiftsIntoInt(ArrayList<Shift> shiftList,Date currentDate){
        float shiftTime = 0;
        for (Shift shift : shiftList){
           String dateToString = shift.getStart().toString();
           String date =  dateToString.substring(0,10);

        }
        return shiftTime;

    }
    public String whichStaffHasWorkedTheMostReport(ArrayList<Staff> staffList,Date currentDate){
        Staff staffWhoHasWorkedTheMost = staffList.get(0);
        float highestShift = 0;
       for (Staff staff : staffList){
           float staffWorkedFor = convertShiftsIntoInt(staff.getShifts(),currentDate);
           if( staffWorkedFor > highestShift){
               highestShift = staffWorkedFor;
               staffWhoHasWorkedTheMost = staff;
           }

       }
       return staffWhoHasWorkedTheMost.getUsername();
    }


}
