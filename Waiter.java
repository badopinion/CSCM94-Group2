
public class Waiter extends Staff{

	// Constructor - JB
    public Waiter(String username, String password, String firstName, String lastName, int staffId, String homeAddress){
        super(username, password, firstName, lastName, staffId, homeAddress,StaffType.WAITER);
    }
}