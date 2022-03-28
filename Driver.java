
/**
 * A driver class (child of Staff)
 * @author Oliver Jackson
 * @version 1
 */

public class Driver extends Staff{

    public Driver(String username, String password, String firstName, String lastName, int staffId, String homeAddress){
        super(username, password, firstName, lastName, staffId, homeAddress,StaffType.DRIVER);
    }
}