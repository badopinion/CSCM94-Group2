import java.time.LocalDateTime;
import java.util.ArrayList;

public class Table {

    private String tableID;
    private int numberOfSeats;
    private boolean available;
    private int maximumCapacity;

    // private ArrayList<bookinglist>Booking =new ArrayList bookingList;
    private ArrayList<Booking> bookingList = new ArrayList<>();

    public Table(String tabelID_, int numberOfSeats_, int capacity_) {
        this.tableID = tabelID_;
        this.numberOfSeats = numberOfSeats_;
        this.maximumCapacity = capacity_;
    }

    public boolean checkAvailability(LocalDateTime checkedDate) {

        return true;
    }

    public void addBooking(Booking toBeAdded) {
        bookingList.add(toBeAdded);
    }

    public String getTableID() {
        return this.tableID;
    }

    public int getCapacity() {
        return this.maximumCapacity;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}