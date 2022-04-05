package backend;

import java.util.ArrayList;


/**
 * A customer class (child of User)
 * @author Oliver Jackson
 * @version 1
 */

public class Customer extends User{
    private ArrayList<Order> orderHistory = new ArrayList<Order>();

    /**
     * Customer information
     * @param username the customer's id
     * @param password the customer's password
     * @param firstName the customer's first name
     * @param lastName the customer's last name
     * @param homeAddress the customer's home address
     */
    public Customer(String username, String password, String firstName, String lastName, String homeAddress){
		super(username, password, firstName, lastName, homeAddress);
    }


    /**
     * get Order History
     * @return return order history
     */


    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    /**
     * Method to add order object to arrayList orderHistory
     * @param order order history
     */
    public void addOrderToOrderHistory(Order order){
        orderHistory.add(order);
    }
}
