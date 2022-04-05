package backend;
/**
 * A driver class (child of Staff)
 * @author Oliver Jackson
 * @version 1
 */

public class Driver extends Staff{


    /**
     * Driver information
     * @param username the driver's username
     * @param password the driver's password
     * @param firstName the driver's first name
     * @param lastName the driver's lastname
     * @param homeAddress the driver's home address
     */
    public Driver(String username, String password, String firstName, String lastName, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);

    }
}
