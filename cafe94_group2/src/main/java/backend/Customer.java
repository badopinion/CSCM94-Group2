package backend;

import java.util.ArrayList;


/**
 * A customer class (child of User)
 * @author Oliver Jackson
 * @version 1
 */

public class Customer extends User{
    private ArrayList<Order> orderHistory = new ArrayList<Order>();


    public Customer(String username, String password, String firstName, String lastName, String homeAddress){
		super(username, password, firstName, lastName, homeAddress);
    }



    //Getters - OJ

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    //Method to add order object to arrayList orderHistory - OJ
    public void addOrderToOrderHistory(Order order){
        orderHistory.add(order);
    }

}