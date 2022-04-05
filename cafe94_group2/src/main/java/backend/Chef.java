package backend;

/**
 * A Chefclass. Chefclass
 * @author Yingfan Zhang
 * @version 1
 */

public class Chef extends Staff{
    /**
     *
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