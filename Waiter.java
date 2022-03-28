
public class Waiter extends Staff{

	// Constructor - JB -- Added StaffType Enum so I only have to save the staff class and not each extend class -SR
    public Waiter(String username, String password, String firstName, String lastName, int staffId, String homeAddress){
        super(username, password, firstName, lastName, staffId, homeAddress,StaffType.WAITER);
    }
}