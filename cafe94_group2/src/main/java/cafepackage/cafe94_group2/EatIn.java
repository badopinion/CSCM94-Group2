import java.util.ArrayList;
/**
 * An eatin class (child of order)
 * @author Oliver Jackson
 * @version 1
 */

public class EatIn extends Order{
    private Table table;

    //Constructor with order notes - OJ
    public EatIn(Table table, int orderID, Customer customer, String orderNotes, ArrayList<CafeMenuItem> cafeMenuItems){
        super(orderID, customer, orderNotes, cafeMenuItems);
        this.table = table;
    }


}