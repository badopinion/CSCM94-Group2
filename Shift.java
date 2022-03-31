import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

/**
 * A shift class.
 * @author Oliver Jackson
 * @version 1
 */

public class Shift implements Serializable{

    private Staff staffMember;
    private LocalDateTime start;
    private LocalDateTime end;
    //manager can approve that this shift has been worked
    private boolean shiftApproved;

    //Constructor - date field takes "YYYY-MM-DD" and the time fields take "HH-MM" - OJ
    public Shift(Staff staffmember, String date, String startTime, String endTime){
        this.staffMember = staffmember;
        String startDateTime = date + " " + startTime;
        String endDateTime = date + " " + endTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        start = LocalDateTime.parse(startDateTime, formatter);
        end = LocalDateTime.parse(endDateTime, formatter);
        this.shiftApproved = false;
    }

    //Getters - OJ
    public LocalDateTime getStart(){
        return this.start;
    }

    public LocalDateTime getEnd(){
        return this.end;
    }

    public Staff getStaffMember() {
        return staffMember;
    }
	
	public boolean getShiftApproved(){
		return shiftApproved;
	}

    //this method is used to approve whether or not the staff member worked the shift - OJ
    public void setShiftApproved(boolean yesOrNo){
        shiftApproved = yesOrNo;
    }


}