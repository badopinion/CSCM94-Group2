package backend;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * A takeaway class (child of order)
 * @author Oliver Jackson
 * @version 2
 */

public class Takeaway extends Order {

    //pickUpTime required by spec - OJ
    private LocalTime pickUpTime;


    //Constructor with order notes - OJ
    public Takeaway(int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> menuItems, String pickUpTime) {
        super(orderID, customer, orderNotes, menuItems);
        try {
            this.pickUpTime = LocalTime.parse(pickUpTime);
        } catch (Exception e) {
            System.out.println("invalid time format given");;
        }
    }

}