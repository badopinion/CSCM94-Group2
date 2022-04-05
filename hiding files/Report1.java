import java.awt.*;
import java.util.ArrayList;

/**
 * A report generation class for 4x information
 * @author AS & SR
 * @version 1
 */


public class Report1 {
    //Customer based variable
    private int ArrayList<MenuItem> orderedMenuItems;
    private int orderID;
    private int customerID;
    private int ArrayList<shiftHistory> shiftsWorked;


    // Constructor:
    public Report(int ArrayList<MenuItem> orderedMenuItems, int orderID, int customerID,
                  int ArrayList<shiftHistory> shiftsWorked) {
        this.orderedMenuItems = orderedMenuItems;
        this.orderID = orderID;
        this.customerID = customerID;
        this.shiftsWorked = shiftsWorked;
    }

    // Get
    public ArrayList<MenuItem> orderedMenuItems() {
        return orderedMenuItems();
    }

    public int getOrderID() {
        return orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public ArrayList<shiftHistory> getshiftsWorked() {
        return getshiftsWorked();
    }

    // Set
    public void (int ) {
        this. = ;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void (int ) {
        this. = ;
    }

}





/* todo =
Generate most popular items
Busiest periods in the restaurant
Most active customer
Highest number of hours work by staff members
 */






class order {
    static int maxFreq(int []arr, int n) {

            // moore's algorithm
            int res = 0;
            int count = 1;
            for(int i = 1; i < n; i++) {
                if(arr[i] == arr[res]) {
                    count++;
                } else {
                    count--;
                }
                if(count == 0) {
                    res = i;
                    count = 1;
                }
            }
            return arr[res];
        }

        // Driver ex. code
        public static void main (String[] args) {
            int menuItem[] = {4, 5, 3, 4, 5, 3, 3, 10, 10};
            int n = menuItem.length;
            int freq = maxFreq(menuItem, n);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (menuItem[i] == freq) {
                    count++;
                }
            }
            System.out.println("The most popular item is no. " + maxFreq(menuItem, n) +
                    ". Ordered a total of " + count + " times.");
    }
 }