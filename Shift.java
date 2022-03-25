import java.util.Date;

/**
 * A shift class
 * @author Oliver Jackson
 * @version 1
 */

public class Shift{

    private Date start;
    private Date end;
    //manager can approve that this shift has been worked
    private boolean shiftApproved;

    //Constructor
    public Shift(int year, int month, int date, int startHour, int startMin, int endHour, int endMin){
        this.start = new Date(year, month, date, startHour, startMin);
        this.end = new Date(year, month, date, endHour, endMin);
        this.shiftApproved = false;
    }

    //Getters
    public Date getStart(){
        return this.start;
    }

    public Date getEnd(){
        return this.end;
    }

    //this method is used to approve whether or not the staff member worked the shift
    public void setShiftApproved(boolean yesOrNo){
        shiftApproved = yesOrNo;
    }

}