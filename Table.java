/**
 * A table class
 * @author Oliver Jackson
 * @version 1
 */

public class Table {
    private int tableNumber;
    private int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
