import java.util.ArrayList;

/**
 * A customer class (child of User)
 * @author Oliver Jackson
 * @version 1
 */

public class Customer extends User{
    private int customerId;
    private ArrayList<Order> orderHistory = new ArrayList<Order>;


    public Customer(String username, String password, String firstName, String lastName, String homeAddress, int customerId){
		super(username, password, firstName, lastName, homeAddress);
    this.customerId = customerId;
    }

    //Getters - OJ
    public int getCustomerId() {
        return customerId;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    //Setters - OJ
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    //Method to add order object to arrayList orderHistory - OJ
    public void addOrderToOrderHistory(Order order){
        orderHistory.add(order);
    }

}