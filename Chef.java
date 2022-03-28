
/**
 * A chef class (child of staff)
 * @author Oliver Jackson
 * @version 1
 */

public class Chef extends Staff{

    public Chef(String username, String password, String firstName, String lastName, int staffId, String homeAddress){
        super(username, password, firstName, lastName, staffId, homeAddress,StaffType.CHEF);
    }
}