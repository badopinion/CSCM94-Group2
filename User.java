public class User {
    String username;
	String password;
	
	//Constructor
    public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	// Get username. No username setter; uniqueness enforced by Login class at class instantiation.
	public String getUsername(){
		return username;
	}
	
	// Returns true if input and username match
	public checkUserName(String input){
		return username.equals(input);
	}
	
	// Returns true if input and password match
	public checkPassword(String input){
		return password.equals(input);
	}
	
	// Returns true if passed correct username and password
	public checkCredentials(String userIn, String passIn){
		return checkUserName(userIn) && checkPassword(passIn);
	}
}