package backend;

import java.util.ArrayList;
/**
 * An eatin class (child of order)
 * @author Oliver Jackson
 * @version 1
 */

public class EatIn extends Order{
    private Table table;

    //Constructor with order notes - OJ
    public EatIn(Table table, int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> menuItems){
        super(orderID, customer, orderNotes, menuItems);
        this.table = table;
    }


}