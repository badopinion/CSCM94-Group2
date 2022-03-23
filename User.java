public class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String homeAddress;
	
	//Constructor - OJ
	public User(String username, String password, String firstName, String lastName, String homeAddress) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeAddress = homeAddress;
	}


	//Getters - OJ
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


  //Setters - OJ
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
	public checkUserName(String input){
		return username.equals(input);
	}
	
	// Returns true if input and password match - JB
	public checkPassword(String input){
		return password.equals(input);
	}
	
	// Returns true if passed correct username and password - JB
	public checkCredentials(String userIn, String passIn){
		return checkUserName(userIn) && checkPassword(passIn);
	}
}