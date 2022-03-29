import java.util.Date;

public class Booking {
    private int guestCount;
	private Date bookingTime;
	private int bookingDuration;
	private Customer customer;
	private boolean approved;
	private boolean cancelled;
	
	// Constructor
	public Booking(int guestCount, Date bookingTime, int bookingDuration, Customer customer){
		this.guestCount = guestCount;
		this.bookingTime = bookingTime;
		this.bookingDuration = bookingDuration;
		this.customer = customer;
		this.approved = false;
		this.cancelled = false;
	}
	
	// Getters & Setters
	public int getGuestCount(){
		return this.guestCount;
	}
	
	public Date getBookingTime(){
		return this.bookingTime;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	public boolean isApproved(){
		return this.approved;
	}
	
	public boolean isCancelled(){
		return this.cancelled;
	}
	
	public void approve(){
		this.approved = true;
	}
	
	public void cancel(){
		this.cancelled = true;
	}
	
	// TODO: Test doing maths on dates. Should be fine as a date is essentially a long, but test anyway
}