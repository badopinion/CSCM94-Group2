import java.util.ArrayList;

public class Manager extends Staff{
    private ArrayList<Staff> staffMembers;

    public Manager(String username, String password, String firstName, String lastName, int staffId, String homeAddress){
        super(username, password, firstName, lastName, staffId, homeAddress,StaffType.MANAGER);

    }
}