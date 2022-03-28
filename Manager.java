import java.util.ArrayList;

/**
 * A Manager class (child of Staff)
 * @author Oliver Jackson
 * @version 1
 */

public class Manager extends Staff{
    private ArrayList<Staff> staffMembers;

    public Manager(String username, String password, String firstName, String lastName, int staffId, String homeAddress){
        super(username, password, firstName, lastName, staffId, homeAddress,StaffType.MANAGER);

    }
}