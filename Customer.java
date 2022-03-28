import java.util.ArrayList;

public class Customer extends User{
    private int customerId;
    private ArrayList<Order> orderHis;

    public Customer(String username, String password, String firstName, String lastName, String homeAddress, int customerId){
		super(username, password, firstName, lastName, homeAddress);
    this.customerId = customerId;
    }
}