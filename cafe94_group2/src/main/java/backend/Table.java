package backend;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * A table class. Aggregates bookings.
 * @author Jo Butler
 * @version 1
 */

public class Table implements Serializable{
    private int tableNumber;
    private int capacity;
    private ArrayList<Booking> bookings;

    // Constructor - JB
    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.bookings = new ArrayList<Booking>();
    }

    // Getters - JB
    public int getTableNumber() {
        return this.tableNumber;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Booking> getBookings(){
        return this.bookings;
    }

    // Setters - JB
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Tries to add a booking with the entered parameters. - JB
    // Returns false instead if already booked at the time or above table's capacity. - JB
    public boolean addBooking(int guestCount, LocalDateTime bookingTime, long bookingDuration, Customer customer){
        boolean res = true;
        if(guestCount > capacity){
            System.out.println("Booking doesn't fit on this table.");
            res = false;
        }
        Booking newBooking = new Booking(guestCount, bookingTime, bookingDuration, customer);
        for(Booking b : bookings){
            if(newBooking.intersects(b)){
                System.out.println("New booking rejected because it clashes with an existing booking.");
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
