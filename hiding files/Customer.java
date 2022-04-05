import java.io.Serializable;
import java.util.ArrayList;
/**
 * A customer class (child of User)
 * @author Oliver Jackson
 * @version 1
 */
//Added Serializable to be able to save object in text file -SR
public class Customer extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int customerId;
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
    //Added  a little toString for testing will remove later -SR
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +

                '}';
    }
}