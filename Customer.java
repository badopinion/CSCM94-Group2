import java.io.Serializable;
import java.util.ArrayList;
//Added Serializable to be able to save object in text file -SR
public class Customer extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int customerId;
    private ArrayList<Order> orderHis;

    public Customer(String username, String password, String firstName, String lastName, String homeAddress, int customerId){
		super(username, password, firstName, lastName, homeAddress);
    this.customerId = customerId;
    }
    //Added  a little toString for testing will remove later -SR
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +

                '}';
    }
}