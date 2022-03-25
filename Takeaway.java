import java.util.Date;
import java.util.ArrayList;

/**
 * A takeaway class (child of order)
 * @author Oliver Jackson
 * @version 1
 */

public class Takeaway extends Order {

    //pickUpTime required by spec - OJ
    private Date pickUpTime;

    //Constructor with order notes - OJ
    public Takeaway(int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> menuItems, Date pickUpTime) {
        super(orderID, customer, orderNotes, menuItems);
        this.pickUpTime = pickUpTime;
    }

    //Constructor without order notes - OJ
    public Takeaway(int orderID, Customer customer, ArrayList<MenuItem> menuItems, Date pickUpTime) {
        super(orderID, customer, menuItems);
        this.pickUpTime = pickUpTime;
    }

}