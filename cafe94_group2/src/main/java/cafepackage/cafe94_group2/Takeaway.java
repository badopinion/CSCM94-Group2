import java.time.LocalTime;
import java.util.ArrayList;

/**
 * A takeaway class (child of order)
 * @author Oliver Jackson
 * @version 1
 */

public class Takeaway extends Order {

    //pickUpTime required by spec - OJ
    private LocalTime pickUpTime;

    //Constructor with order notes - OJ
    public Takeaway(int orderID, Customer customer, String orderNotes, ArrayList<CafeMenuItem> cafeMenuItems, String pickUpTime) {
        super(orderID, customer, orderNotes, cafeMenuItems);
        this.pickUpTime = LocalTime.parse(pickUpTime);
    }

}