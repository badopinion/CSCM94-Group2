package backend;

import java.time.LocalDate;

/**
 * BookingTable class.BookingTable
 * Custom class to aggregate information relating to bookings and tables for use in the output
 * @author Jo Butler
 * @version 1
 */

public class BookingTable{
    private Table table;
    private Booking booking;
    private LocalDate date;
    private String time;
    private Integer guests;
    private boolean approved;
    private Integer tableNumber;
    private long duration;

    /**
     * Constructor of booking table
     * @param b Booking object
     * @param t Table object
     */
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

    /**
     * Get table
     * @return Table value
     */
    public Table getTable() {
        System.out.println("Returning table.");
        return table;
    }

    /**
     * Get booking
     * @return Booking value
     */
    public Booking getBooking() {
        System.out.println("Returning booking.");
        return booking;
    }

    /**
     * Get date
     * @return LocalDate value
     */
    public LocalDate getDate() {
        System.out.println("Returning date.");
        return date;
    }

    /**
     * Get time
     * @return String value of time
     */
    public String getTime() {
        System.out.println("Returning time.");
        return time;
    }

    /**
     * Get guests
     * @return Integer value of guests
     */
    public Integer getGuests() {
        System.out.println("Returning guests.");
        return guests;
    }

    /**
     * Get boolean value about whether is approved
     * @return Boolean value of whether is approved
     */
    public boolean isApproved() {
        System.out.println("Returning approved.");
        return approved;
    }

    /**
     * Get table number
     * @return Integer value of table number
     */
    public Integer getTableNumber() {
        System.out.println("Returning table number");
        return tableNumber;
    }
}
