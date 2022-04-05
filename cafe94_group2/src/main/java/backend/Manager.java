package backend;

/**
 * A Manager class (child of Staff)
 * @author Oliver Jackson
 * @version 1
 */

public class Manager extends Staff{


    /**
     * Manager information
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param homeAddress
     */
    public Manager(String username, String password, String firstName, String lastName, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);

    }
}