
public class Customer extends User{

    private int customerId;

    public Customer(String firstName, String lastName, String homeAddress, int customerId){
        super(firstName, lastName, homeAddress);
        this.customerId = customerId;
    }

}