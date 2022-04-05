package backend;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

/**
 * An order class (child: Eatin, Takeaway, Delivery)
 * @author Oliver Jackson
 * @version 1
 */

public class Order implements Serializable{
    private int orderID;
    private Customer customer;
    //orderNotes could be used to store dietary requirements e.g. "nut allergy" or request e.g. "no potatoes" - OJ
    private String orderNotes;
    private boolean orderCompleted;
    private boolean orderCancelled;
    private ArrayList<MenuItem> orderedMenuItems;
    private LocalDateTime orderDateTime;


    //Constructor with ordernotes - OJ
    public Order(int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> orderedMenuItems) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderNotes = orderNotes;
        this.orderCompleted = false;
        this.orderCancelled = false;
        this.orderedMenuItems = orderedMenuItems;
        orderDateTime = LocalDateTime.now();
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
    public void setOrderNotes(String orderNotes) {
        this.orderNotes = orderNotes;
    }

    public void setOrderCompleted(boolean orderCompleted) {
        this.orderCompleted = orderCompleted;
    }

    public void setOrderCancelled(boolean orderCancelled) {
        this.orderCancelled = orderCancelled;
    }

    //method to calculate sum of price of order - OJ
    public float getOrderPrice(){
        float sum = 0;
        for (MenuItem menuItem : orderedMenuItems){
            sum += menuItem.getPrice();
        }
        return sum;
    }

    //method to return type of order - OJ
    public String typeOfOrder(){
        if (this instanceof EatIn){
            return "Eat In";
        } else if (this instanceof Takeaway){
            return "Takeaway";
        } else if (this instanceof Delivery){
            return "Delivery";
        } else {
            return "Type of order not found";
        }
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    @java.lang.Override
    public java.lang.String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dateTime = orderDateTime.format(formatter);
        return "Order{" +
                "orderID= " + orderID +
                ", customer= " + customer.getUsername() +
                ", orderNotes= '" + orderNotes + '\'' +
                ", orderCompleted= " + orderCompleted +
                ", orderCancelled= " + orderCancelled +
                ", orderedMenuItems= " + orderedMenuItems +
                ", orderDateTime= " + dateTime +
                ", orderType = " + this.typeOfOrder() +
                '}';
    }
}