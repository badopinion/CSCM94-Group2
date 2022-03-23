
public class User {
    private String firstName;
    private String lastName;
    private String homeAddress;

    //Constructor - OJ
    public User(String firstName, String lastName, String homeAddress) {
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


}