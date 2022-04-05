package backend;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * A table class. Aggregates bookings.
 * @author Jo Butler , Hristiana Davidova
 * @version 1
 */

public class Table implements Serializable{
    private int tableNumber;
    private int capacity;
    private ArrayList<Booking> bookings;

    /**
     * Constructor
     * @param tableNumber the table number
     * @param capacity the capacity of the table
     */
    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.bookings = new ArrayList<Booking>();
    }

    /**
     * Getters
     * @return returns table number
     */
    public int getTableNumber() {
        return this.tableNumber;
    }

    /**
     * Getters
     * @return returns capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Getters
     * @return returns arraylist of booking
     */
    public ArrayList<Booking> getBookings(){
        return this.bookings;
    }

    /**
     * Setters
     * @param tableNumber the table number
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     *Tries to add a booking with the entered parameters.
     * Returns false instead if already booked at the time or above table's capacity.
     * @param guestCount the count for the guests
     * @param bookingTime the time of the booking
     * @param bookingDuration the duration of the booking
     * @param customer the customer
     * @return returning if booked or rejected
     */
    public boolean addBooking(int guestCount, LocalDateTime bookingTime, long bookingDuration, Customer customer){
        boolean res = true;
        if(guestCount > capacity){
            System.out.println("Booking doesn't fit on table " + tableNumber);
            res = false;
        }
        Booking newBooking = new Booking(guestCount, bookingTime, bookingDuration, customer);
        for(Booking b : bookings){
            if(newBooking.intersects(b)){
                System.out.println("Booking rejected. Clashes with an existing booking, table " + tableNumber);
                res = false;
            }
        }
        if(res) {
            this.bookings.add(newBooking);
            System.out.println("Booking added.");
        }
        return res;
    }
}
