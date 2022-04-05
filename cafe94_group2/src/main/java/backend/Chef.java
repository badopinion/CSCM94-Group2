package backend;

/**
 * A Chefclass. Chefclass
 * @author Oliver Jackson
 * @version 1
 */

public class Chef extends Staff{
    /**
     * Chef information
     * @param username The chef's id
     * @param password The chef's password
     * @param firstName The chef's first name
     * @param lastName the chef's last name
     * @param homeAddress the chef's home address
     */
    public Chef(String username, String password, String firstName, String lastName, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);
    }
}