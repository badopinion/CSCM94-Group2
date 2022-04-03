package cafepackage.cafe94_group2;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

/**
 * A booking class. A booking is a period of time for which a table has been booked by customers who wish to eat in.
 * Bookings must be approved - a booking that has not yet been approved is a booking request.
 * @author Jo Butler
 * @version 2
 */

public class Booking implements Serializable {
    private int guestCount;
    private LocalDateTime bookingStart;
    private LocalDateTime bookingEnd;
    private Customer customer;
    private boolean approved;
    private boolean cancelled;

    // Constructor
    public Booking(int guestCount, LocalDateTime bookingStart, long bookingDuration, Customer customer){
        this.guestCount = guestCount;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingStart.plusMinutes(bookingDuration);
        this.customer = customer;
        this.approved = false;
        this.cancelled = false;
    }

    // Getters & Setters
    public int getGuestCount(){
        return this.guestCount;
    }

    public LocalDateTime getBookingStart(){
        return this.bookingStart;
    }

    public LocalDateTime getBookingEnd(){
        return this.bookingEnd;
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

    // Returns whether the Booking given as input clashes with this one.
    public boolean intersects(Booking in){
        if(this.getBookingStart().isAfter(in.getBookingStart()) && this.getBookingStart().isBefore(in.getBookingEnd())){
            // This booking starts in the middle of the input booking
            System.out.println("Booking clash.");
            return true;
        }
        if(this.getBookingEnd().isAfter(in.getBookingStart()) && this.getBookingEnd().isBefore(in.getBookingEnd())){
            // This booking ends in the middle of the input booking
            System.out.println("Booking clash.");
            return true;
        }
        if(in.getBookingStart().isAfter(this.getBookingStart()) && in.getBookingStart().isBefore(this.getBookingEnd())){
            // Input booking starts in the middle of this booking
            System.out.println("Booking clash.");
            return true;
        }
        if(in.getBookingEnd().isAfter(this.getBookingStart()) && in.getBookingEnd().isBefore(this.getBookingEnd())){
            // Input booking ends in the middle of this booking
            System.out.println("Booking clash.");
            return true;
        }
        if(!this.getBookingStart().isAfter(in.getBookingStart()) && !this.getBookingStart().isBefore(in.getBookingStart())){
            // Both bookings begin at the same time.
            System.out.println("Booking clash - this booking starts at the same time as an existing booking.");
            return true;
        }
        if(!this.getBookingEnd().isAfter(in.getBookingEnd()) && !this.getBookingEnd().isBefore(in.getBookingEnd())){
            // Both bookings end at the same time.
            System.out.println("Booking clash - this booking ends at the same time as an existing booking.");
            return true;
        }
        System.out.println("Booking does not clash.");
        return false;
    }

    private class Customer {
    }
}
