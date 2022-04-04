package backend;

import java.util.ArrayList;
import java.io.*;

/**
 * Login holds all user profiles and keeps track of which user is currently logged in.
 * To get user information or log users in or out, other classes reference Login.
 * @author Jo Butler
 * @version 3
 */

public class Login implements Serializable {
	User loggedIn = null; // User that is currently logged in. JB
	ArrayList<User> userList = new ArrayList<User>(); // All user profiles. JB

	/**
	 *  Constructor
	 */
	public Login() {
		populateUsers();

	}

	/**
	 * Replaces currently logged in user with the user specified as argument
	 * @param userIn user is logged in
	 */
	public void login(User userIn) {
		this.loggedIn = userIn;
	}

	/**
	 *  Logs user out (replaces currently logged in user with null).
	 */
	public void logout(){
		this.loggedIn = null;
	}

	/**
	 *  Methods to create users (of all types). No duplicate usernames.
	 * 	All users created are added to Login's arraylist of users.
	 * 	Other classes call methods of Login to get hold of them.
	 * @param username  the username
	 * @param password the user's password
	 * @param firstName the user's first name
	 * @param lastName the user's last name
	 * @param homeAddress the user's home address
	 * @return  returns false if entered username was already taken
	 */
	public boolean newManager(String username, String password, String firstName, String lastName, String homeAddress){
		for(User u : userList){
			if(u.checkUsername(username)){
				return false;
			}
		}
		userList.add(new Manager(username, password, firstName, lastName, homeAddress));
		return true;
	}


	public boolean newWaiter(String username, String password, String firstName, String lastName, String homeAddress){
		for(User u : userList){
			if(u.checkUsername(username)){
				return false;
			}
		}
		userList.add(new Waiter(username, password, firstName, lastName, homeAddress));
		return true;
	}

	public boolean newChef(String username, String password, String firstName, String lastName, String homeAddress){
		for(User u : userList){
			if(u.checkUsername(username)){
				return false;
			}
		}
		userList.add(new Chef(username, password, firstName, lastName, homeAddress));
		return true;
	}

	public boolean newDriver(String username, String password, String firstName, String lastName, String homeAddress){
		for(User u : userList){
			if(u.checkUsername(username)){
				return false;
			}
		}
		userList.add(new Driver(username, password, firstName, lastName, homeAddress));
		return true;
	}

	public boolean newCustomer(String username, String password, String firstName, String lastName, String homeAddress){
		for(User u : userList){
			if(u.checkUsername(username)){
				return false;
			}
		}
		userList.add(new Customer(username, password, firstName, lastName, homeAddress));
		return true;
	}

	/**
	 * a method to create some users details.
	 */
	public void populateUsers(){
		newCustomer("eatincustomer", "pass", "eatin", "customer", "cafe94");
		newCustomer("takeawaycustomer", "pass", "takeaway", "customer", "cafe94");
		newCustomer("deliverycustomer", "pass", "delivery", "customer", "cafe94");
		newCustomer("jamestaylor", "pass", "james", "taylor", "1 swansea lane, swansea");
		newCustomer("sophie.frank", "pass", "sophie", "frank", "54 manchester drive, manchester");
		newManager("manager", "test", "John", "Bossman", "10 Downing Street");
		newChef("chef", "test", "Jane", "Cook", "12 Dracaena Avenue");
		newCustomer("customer", "test", "Remi", "Crimson", "Flat 6, 21 High Street");
		newWaiter("waiter", "test", "Dave", "Davies", "1 Graham Place");
		newWaiter("waiterben", "pass", "Ben", "Davies", "10 Vindaloo Road");
		newDriver("driver", "test", "Max", "Verstappen", "A van");
	}


	/**
	 *  Checks what type of user is logged in and returns as string.
	 * @return returns the type of user is logged
	 */
	public String checkLoggedInUserType(){
		if(loggedIn instanceof Manager) return "Manager";
		if(loggedIn instanceof Waiter) return "Waiter";
		if(loggedIn instanceof Driver) return "Driver";
		if(loggedIn instanceof Chef) return "Chef";
		if(loggedIn instanceof Customer) return "Customer";
		return "Invalid subclass";
	}

	/**
	 * Checks what type of user was passed as argument to this method and returns as string.
	 * @param userIn the user is logged
	 * @return returns what type of user is logged
	 */
	public String checkUserType(User userIn){
		if(userIn instanceof Manager) return "Manager";
		if(userIn instanceof Waiter) return "Waiter";
		if(userIn instanceof Driver) return "Driver";
		if(userIn instanceof Chef) return "Chef";
		if(userIn instanceof Customer) return "Customer";
		return "Invalid subclass";
	}

	/**
	 *  Checks username and password for matching user. If found log user in.
	 * 	 Returns true if a user was logged in and false if invalid (for the sake of output)
	 * @param username the username  for matching user
	 * @param password the password for matching user
	 * @return returns login credentials
	 */
	public boolean loginWithCredentials(String username, String password){
		for(User u : userList){
			if(u.checkCredentials(username, password)){
				this.loggedIn = u;
				return true;
			}
		}
		return false;
	}

	/**
	 *  Gets user from username.
	 * @param username the username
	 * @return returns the user
	 */
	public User getUserFromUsername(String username){
		for(User u : userList){
			if(u.getUsername().equals(username)){
				return u;
			}
		}
		return null;
	}

	/**
	 * gets Customer from username.
	 * @param username cutomer's username
	 * @return returns user
	 */
	public Customer getCustomerFromUsername(String username){
		User u = getUserFromUsername(username);
		if(u instanceof Customer){
			Customer c = (Customer) u;
			return c;
		}
		return null;
	}

	/**
	 * Gets user that is logged in
	 * @return  returns logged in
	 */
	public User getLoggedIn(){
		return this.loggedIn;
	}
}