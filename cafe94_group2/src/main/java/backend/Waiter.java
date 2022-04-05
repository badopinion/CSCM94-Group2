package backend;

/**
 * Waiter is a subclass of Staff used to store information on employees in the role of waiter.
 * It has no unique properties, but is used with instanceof to determine which interface to show the user after login.
 * @author Jo Butler
 * @version 1.0
 */
public class Waiter extends Staff{
    /**
     * Constructor. Inherits heavily from superclass Staff.
     * @param username The username of waiter
     * @param password The password of waiter
     * @param firstName First name of waiter
     * @param lastName Last name of waiter
     * @param homeAddress Home address of waiter
     */
    public Waiter(String username, String password, String firstName, String lastName, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);
    }
}
