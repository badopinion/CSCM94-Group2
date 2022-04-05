package backend;
/**
 * A driver class (child of Staff)
 * @author Oliver Jackson
 * @version 1
 */

public class Driver extends Staff{

    public Driver(String username, String password, String firstName, String lastName, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);
    }
}