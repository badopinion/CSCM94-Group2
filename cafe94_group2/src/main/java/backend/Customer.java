package backend;

import java.util.ArrayList;


/**
 * A customer class (child of User)
 * @author Oliver Jackson
 * @version 1
 */

public class Customer extends User{

    int customerId;

    public Customer(String username, String password, String firstName, String lastName, String homeAddress, int customerId){
		super(username, password, firstName, lastName, homeAddress);
    }
}