// - so far have decided that we do not need reference to which chef object marked order complete
//my thinking is that it is superfluous, and also confusing if only a drink order is placed
//       -  similarly have decided with jo that we will not include which staff member served an order
//        with exception of delivery driver (delivery object will hold reference to a delivery driver)
// OJ 17/03/22

import java.util.ArrayList;

public class Order{
    private int orderID;
    private Customer customer;
    //orderNotes could be used to store dietary requirements e.g. "nut allergy" or request e.g. "no potatoes" - OJ
    private String orderNotes;
    private boolean orderCompleted;
    private boolean orderCancelled;
    private ArrayList<MenuItem> orderedMenuItems;


    //Constructor
    public Order(int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> orderedMenuItems) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderNotes = orderNotes;
        this.orderCompleted = false;
        this.orderCancelled = false;
    }
    public Order( int orderID, Customer customer, String orderNotes){
        this.orderID = orderID;
        this.customer = customer;
        this.orderNotes = orderNotes;
    }
    //Getters
    public int getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getOrderNotes() {
        return orderNotes;
    }

    public boolean isOrderCompleted() {
        return orderCompleted;
    }

    public boolean isOrderCancelled() {
        return orderCancelled;
    }

    public ArrayList<MenuItem> getOrderedMenuItems() {
        return orderedMenuItems;
    }

    //Setters
    //I think there should be no setter for orderId or customer [OJ 17/03/22]
    public void setOrderNotes(String orderNotes) {
        this.orderNotes = orderNotes;
    }

    public void setOrderCompleted(boolean orderCompleted) {
        this.orderCompleted = orderCompleted;
    }

    public void setOrderCancelled(boolean orderCancelled) {
        this.orderCancelled = orderCancelled;
    }

    //method to calculate sum of price of order
    public float getOrderPrice(){
        float sum = 0;
        for (MenuItem menuItem : orderedMenuItems){
            sum += menuItem.getPrice();
        }
        return sum;
    }

}