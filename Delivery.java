import java.util.ArrayList;
/**
 * A delivery class (child of order)
 * @author Oliver Jackson
 * @version 1
 */

public class Delivery extends Order {
    private String deliveryAddress;

    //Constructor with order notes & delivery is a new address - OJ
    public Delivery(int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> menuItems, String deliveryAddress) {
        super(orderID, customer, orderNotes, menuItems);
        this.deliveryAddress = deliveryAddress;
    }


    //Constructor without order notes & delivery is a new address - OJ
    public Delivery(int orderID, Customer customer, ArrayList<MenuItem> menuItems, String deliveryAddress) {
        super(orderID, customer, menuItems);
        this.deliveryAddress = deliveryAddress;
    }

    //Constructor with order notes delivery is customer's address - OJ
    public Delivery(int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> menuItems) {
        super(orderID, customer, orderNotes, menuItems);
        deliveryAddress = customer.getHomeAddress;
    }

    //Constructor without order notes delivery is customer's address - OJ
    public Delivery(int orderID, Customer customer, ArrayList<MenuItem> menuItems) {
        super(orderID, customer, menuItems);
        deliveryAddress = customer.getHomeAddress;
    }


    //Getter - OJ
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    //Setter - OJ
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}







