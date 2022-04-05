package backend;

import java.util.ArrayList;
/**
 * A delivery class (child of order)
 * @author Oliver Jackson
 * @version 1
 */

public class Delivery extends Order {
    private String deliveryAddress;

    /**
     * Constructor with order notes, delivery is a new address
     * @param orderID the order id
     * @param customer the customer
     * @param orderNotes the order notes
     * @param menuItems the menu items
     * @param deliveryAddress the address for  delivery
     */
    public Delivery(int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> menuItems, String deliveryAddress) {
        super(orderID, customer, orderNotes, menuItems);
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Alternative constructor with order notes delivery is customer's address
     * @param orderID the order id
     * @param customer the customer
     * @param orderNotes the order notes
     * @param menuItems the menu items
     */
    public Delivery(int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> menuItems) {
        super(orderID, customer, orderNotes, menuItems);
        deliveryAddress = customer.getHomeAddress();
    }


    /**
     * get Delivery Address
     * @return return delivery address
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Setter
     * @param deliveryAddress the delivery address
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}







