package backend;

/**
 * A Manager class (child of Staff)
 * @author Oliver Jackson
 * @version 1
 */

public class Manager extends Staff{


    /**
     * Manager information
     * @param username Username of manager
     * @param password Password of manager
     * @param firstName First name of manager
     * @param lastName Last name of manager
     * @param homeAddress Home address of manager
     */
    public Manager(String username, String password, String firstName, String lastName, String homeAddress){
        super(username, password, firstName, lastName, homeAddress);

    }
}
