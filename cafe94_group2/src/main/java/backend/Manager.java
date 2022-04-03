package backend;

/**
 * A Manager class (child of Staff)
 * @author Oliver Jackson
 * @version 1
 */

public class Manager extends Staff{

    public Manager(String username, String password, String firstName, String lastName, int staffId, String homeAddress){
        super(username, password, firstName, lastName, staffId, homeAddress);
    }
}