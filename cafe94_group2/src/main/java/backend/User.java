package backend;

import java.io.*;

/**
 * Superclass of all user types. Contains information and methods relevant to all users
 * (child: Customer, Staff, Manager, Waiter, Driver, Chef)
 * @author: Jo Butler
 * @version: 2
 */

public class User implements Serializable {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String homeAddress;
	
	//Constructor - JB
	public User(String username, String password, String firstName, String lastName, String homeAddress) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeAddress = homeAddress;
	}

	//Getters - JB
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	// No username setter; uniqueness enforced by Login class at class instantiation. JB
	public String getUsername(){
		return username;
	}

  	//Setters - JB
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
  
	// Returns true if input and username match - JB
	public boolean checkUsername(String input){
		return username.equals(input);
	}
	
	// Returns true if input and password match - JB
	public boolean checkPassword(String input){
		return password.equals(input);
	}
	
	// Returns true if passed correct username and password - JB
	public boolean checkCredentials(String userIn, String passIn){
		return checkUsername(userIn) && checkPassword(passIn);
	}
}