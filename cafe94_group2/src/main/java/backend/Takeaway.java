package backend;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * A takeaway class (child of order)
 * @author Hristiana Davidova
 * @version 1
 */

public class Takeaway extends Order {


    private LocalTime pickUpTime;

    /**
     * Takeaway information
     * PickUpTime required by spec
     * Constructor with order notes
     * @param orderID OrderID of takeaway order
     * @param customer Customer of takeaway order
     * @param orderNotes OrderNotes of takeaway order
     * @param menuItems Menu item of takeaway order
     * @param pickUpTime Pick up time of takeaway order
     */

    public Takeaway(int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> menuItems, String pickUpTime) {
        super(orderID, customer, orderNotes, menuItems);
        this.pickUpTime = LocalTime.parse(pickUpTime);
    }

}