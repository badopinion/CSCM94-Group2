package backend;

/**
 * This is Constructor
 * @author Jo Butler
 * @version 1.0
 */
public class Waiter extends Staff{
    /**
     * This is waiter information
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