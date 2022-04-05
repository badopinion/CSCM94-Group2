package backend;

import java.time.LocalDate;

/**
 * BookingTable class.BookingTable
 * @author Jo Butler
 * @version 1
 */

// Custom class to aggregate information relating to tables for use in the output. - JB
public class BookingTable{
    public Table table;
    public Booking booking;
    public LocalDate date;
    public String time;
    public Integer guests;
    public boolean approved;
    public Integer tableNumber;
    public long duration;

    // Constructor
    public BookingTable(Booking b, Table t){
        this.table = t;
        this.booking = b;
        this.date = b.getBookingStart().toLocalDate();
        this.time = b.getBookingStart().toString();
        this.guests = b.getGuestCount();
        this.approved = b.isApproved();
        this.tableNumber = t.getTableNumber();
        this.duration = b.getBookingEnd().compareTo(b.getBookingStart());
    }

    public Table getTable() {
        System.out.println("Returning table.");
        return table;
    }

    public Booking getBooking() {
        System.out.println("Returning booking.");
        return booking;
    }

    public LocalDate getDate() {
        System.out.println("Returning date.");
        return date;
    }

    public String getTime() {
        System.out.println("Returning time.");
        return time;
    }

    public Integer getGuests() {
        System.out.println("Returning guests.");
        return guests;
    }

    public boolean isApproved() {
        System.out.println("Returning approved.");
        return approved;
    }

    public Integer getTableNumber() {
        System.out.println("Returning table number");
        return tableNumber;
    }
}