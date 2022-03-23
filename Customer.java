// This class holds information about the customer including (FirstName, LastName, Address, Order History) SR


import java.util.ArrayList;

public class Customers {
    String firstName;
    String lastName;
    String address;
    ArrayList<Order> orderHist;

    //

    public Customers(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.orderHist = new ArrayList<Order>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Order> getOrderHist() {
        return orderHist;
    }


}