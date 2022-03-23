public class Customer extends User{
    private int customerId;

    public Customer(String username, String password, String firstName, String lastName, String homeAddress, int customerId){
		super(username, password, firstName, lastName, homeAddress);
        this.customerId = customerId;
    }
}