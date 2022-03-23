public class Login {
	User loggedIn = null; // Currently logged in user.
	ArrayList<User> userList = new ArrayList<User>(); // All user profiles.

	// Constructor takes no argument. At system start up no user should be logged in. JB
    public Login() {
    }

	// Replaces currently logged in user with the user specified as argument. JB
    public static void login(User userIn) {
        this.loggedIn = userIn;
    }
	
	// Logs user out (replaces currently logged in user with null). JB
	public static void logout(){
		this.loggedIn = null;
	}

	// TODO: ALL METHODS BELOW NEED TESTING BEFORE PULL REQUEST - JB.
	
	// Methods to create users (of all types). No duplicate usernames.
	// All users created are added to Login's arraylist of users.
	// Other classes query Login to get hold of them.
	// Returns false if username was already taken. JB
	// TODO: Manager, Waiter, Chef, Driver, Customer
	public static String newManager(){
		
	}
	
	public static String newWaiter(String username, String password, String firstName, String lastName, int staffId, String homeAddress){
		for(User u : userList){
			if(u.checkUsername){
				return false;
			}
			userList.add(new User(username, password, firstName, lastName, staffId));
			return true;
		}
	}
	
	public static String newChef(){
		
	}
	
	public static String newDriver(){
		
	}
	
	// Checks what type of user is logged in and returns as string. JB
	public static String checkLoggedInUserType(){
		if(loggedIn instanceof Manager) return "Manager";
		if(loggedIn instanceof Waiter) return "Waiter";
		if(loggedIn instanceof Driver) return "Driver";
		if(loggedIn instanceof Chef) return "Chef";
		if(loggedIn instanceof Customer) return "Customer";
		return "Invalid subclass";
	}
	
	// Checks what type of user was passed as argument to this method and returns as string. JB
	public static String checkUserType(User userIn){
		if(userIn instanceof Manager) return "Manager";
		if(userIn instanceof Waiter) return "Waiter";
		if(userIn instanceof Driver) return "Driver";
		if(userIn instanceof Chef) return "Chef";
		if(userIn instanceof Customer) return "Customer";
		return "Invalid subclass";
	}
	
	// Checks username and password for matching user. If found log user in.
	// Returns true if a user was logged in and false if invalid (for the sake of output). JB
	public static boolean loginWithCredentials(String username, String password){
		for(User u : userList){
			if(u.checkCredentials(username, password)){
				this.loggedIn = u;
				return true;
			}
		}
		return false;
	}
}