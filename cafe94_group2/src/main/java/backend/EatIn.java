package backend;

import java.util.ArrayList;
/**
 * An eatin class (child of order)
 * @author Oliver Jackson
 * @version 1
 */

public class EatIn extends Order{
    private Table table;

    /**
     * Constructor with order notes
     * @param table the table in the restaurant
     * @param orderID the order id
     * @param customer the customer username
     * @param orderNotes the notes for the order
     * @param menuItems the items on the menu
     */
    public EatIn(Table table, int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> menuItems){
        super(orderID, customer, orderNotes, menuItems);
        this.table = table;
    }

    public Table getTable() {
        return table;
    }
}