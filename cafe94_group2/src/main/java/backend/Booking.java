package backend;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * A booking class. A booking is a period of time for which a table has been booked by customers who wish to eat in.
 * Bookings must be approved - a booking that has not yet been approved is a booking request.
 * @author Jo Butler , Oliver Jackson
 * @version 2
 */

public class Booking implements Serializable {
    private int guestCount;
	private LocalDateTime bookingStart;
	private LocalDateTime bookingEnd;
	private Customer customer;
	private boolean approved;
	private boolean cancelled;

	/**
	 * This is booking Constructor.
	 * @param guestCount The count of the guest
	 * @param bookingStart The start time of booking
	 * @param bookingDuration The duration time of booking
	 * @param customer The customer of booking
	 */

	public Booking(int guestCount, LocalDateTime bookingStart, long bookingDuration, Customer customer){
		this.guestCount = guestCount;
		this.bookingStart = bookingStart;
		this.bookingEnd = bookingStart.plusMinutes(bookingDuration);
		this.customer = customer;
		this.approved = false;
		this.cancelled = false;
	}

	/**
	 * Get the count of guest.
	 * @return Int value of the guest count
	 */
	public int getGuestCount(){
		return this.guestCount;
	}

	/**
	 * Get the start time of booking.
	 * @return LocalDateTime value of start time
	 */
	public LocalDateTime getBookingStart(){
		return this.bookingStart;
	}

	/**
	 * Get the end time of booking.
	 * @return LocalDateTime value of end time
	 */
	public LocalDateTime getBookingEnd(){
		return this.bookingEnd;
	}

	/**
	 * Get the customer of booking.
	 * @return Customer value of customer
	 */
	public Customer getCustomer(){
		return this.customer;
	}

	/**
	 * Get boolean value about whether is approved
	 * @return Boolean value of whether is approved
	 */
	public boolean isApproved(){
		return this.approved;
	}

	/**
	 * Get boolean value about whether is cancelled
	 * @return Boolean value of whether is cancelled
	 */
	public boolean isCancelled(){
		return this.cancelled;
	}

	/**
	 * Set approve value
	 */
	public void approve(){
		this.approved = true;
	}

	/**
	 * Set cancel value
	 */
	public void cancel(){
		System.out.println("Cancelling booking.");
		this.cancelled = true;
	}

	/** Returns whether the Booking given as input clashes with this one.
	 * @param in Store in booking
	 * @return
	 */
	public boolean intersects(Booking in){
		if (this.getBookingStart().isAfter(in.getBookingStart()) && this.getBookingStart().isBefore(in.getBookingEnd())){
			// This booking starts in the middle of the input booking
			System.out.println("Booking clash.");
			return true;
		}
		if (this.getBookingEnd().isAfter(in.getBookingStart()) && this.getBookingEnd().isBefore(in.getBookingEnd())){
			// This booking ends in the middle of the input booking
			System.out.println("Booking clash.");
			return true;
		}
		if (in.getBookingStart().isAfter(this.getBookingStart()) && in.getBookingStart().isBefore(this.getBookingEnd())){
			// Input booking starts in the middle of this booking
			System.out.println("Booking clash.");
			return true;
		}
		if (in.getBookingEnd().isAfter(this.getBookingStart()) && in.getBookingEnd().isBefore(this.getBookingEnd())){
			// Input booking ends in the middle of this booking
			System.out.println("Booking clash.");
			return true;
		}
		if (!this.getBookingStart().isAfter(in.getBookingStart()) && !this.getBookingStart().isBefore(in.getBookingStart())){
			// Both bookings begin at the same time.
			System.out.println("Booking clash - this booking starts at the same time as an existing booking.");
			return true;
		}
		if (!this.getBookingEnd().isAfter(in.getBookingEnd()) && !this.getBookingEnd().isBefore(in.getBookingEnd())){
			// Both bookings end at the same time.
			System.out.println("Booking clash - this booking ends at the same time as an existing booking.");
			return true;
		}
		System.out.println("Booking does not clash.");
		return false;
	}
}
