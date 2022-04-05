package backend;

import java.io.*;

/**
 * Superclass of all user types. Contains information and methods relevant to all users
 * (child: Customer, Staff, Manager, Waiter, Driver, Chef)
 * @author Jo Butler
 * @version 2
 */

public class User implements Serializable {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String homeAddress;

	/**
	 * Constructor of User object
	 * @param username Username of user
	 * @param password Password of user
	 * @param firstName First name of user
	 * @param lastName Last name of user
	 * @param homeAddress Home address of user
	 */
	public User(String username, String password, String firstName, String lastName, String homeAddress) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeAddress = homeAddress;
	}

	/**
	 * Get the first name of user.
	 * @return String value of the user first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Get the last name of user
	 * @return String value of the user last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Get the home address of user
	 * @return String value of the user address
	 */
	public String getHomeAddress() {
		return homeAddress;
	}

	/**
	 * Get the username of user
	 * No username setter; uniqueness enforced by Login class at class instantiation.
	 * @return String value of the user username
	 */

	public String getUsername(){
		return username;
	}

	/**
	 * Set the first name of user
	 * @param firstName First name of user
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Set the last name of user
	 * @param lastName last name of user
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Set the home address of user
	 * @param homeAddress Home address of user
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * Returns true if input and username match
	 * @param input input of user
	 * @return Boolean value about whether the input is the same as username
	 */

	public boolean checkUsername(String input){
		return username.equals(input);
	}

	/**
	 * Returns true if input and password match
	 * @param input input of user
	 * @return Boolean value about whether the input is the same as password
	 */

	public boolean checkPassword(String input){
		return password.equals(input);
	}

	/**
	 * Returns true if passed correct username and password
	 * @param userIn username input
	 * @param passIn password input
	 * @return Boolean value about whether the username and password is correct
	 */

	public boolean checkCredentials(String userIn, String passIn){
		return checkUsername(userIn) && checkPassword(passIn);
	}
}