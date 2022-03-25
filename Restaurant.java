import java.util.ArrayList;

/**
 * A Restaurant class that aggregates orders and holds methods to show outstanding orders...
 * @author Oliver Jackson
 * @version 1
 */

public class Restaurant {
    private ArrayList<Order> orders;
    //order counter is the number of orders ever ordered, and is used for orderID
    private int orderCounter;

    public Restaurant() {
        this.orders = new ArrayList<Order>();
        this.orderCounter = 0;
    }

    //Getters
    public int getOrderCounter() {
        return orderCounter;
    }

    public ArrayList<Order> getAllOrders() {
        return orders;
    }

    //Setters
    public void setOrderCounter(int orderCounter) {
        this.orderCounter = orderCounter;
    }

    //method to add order to orders - OJ
    public void addOrder(Order){
        orders.add(order);
    }

    //method to show all orders that have not been fulfilled and have not been cancelled - OJ
    //returns an ArrayList
    public ArrayList<Order> unfulfilledOrders(){
        ArrayList<Order> unfulfilledOrders = new ArrayList<Order>()
        for(Order order : orders){
            if (order.isOrderCompleted == false){
                if (order.isOrderCancelled == false) {
                    unfulfilledOrders.add(order);
                }
            }
        }
        return unfulfilledOrders;
        }
    }

    //Method that takes a Customer object and returns a customer order history arraylist - OJ
    //returns an empty arraylist if no orders match
    // TODO - check this is working properly
    public ArrayList<Order> returnCustomerOrderHistory(Customer customer) {
        ArrayList<Order> customerOrders = new ArrayList<Order>();
        for (Order order : orders) {
            if (order.getCustomer == customer) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }
}

    //Returns arraylist of all eatins - OJ
    //Empty arraylist if no match
    public ArrayList<Order> returnEatinOrders(){
        ArrayList<Order> eatinOrders = new ArrayList<Order>();
        for (Order order : orders){
            if (order instanceof Eatin){
                eatinOrders.add(order);
            }
        }
        return eatinOrders;
    }

    //Returns arraylist of all takeaways - OJ
    //Empty arraylist if no match
    public ArrayList<Order> returnTakeawayOrders(){
        ArrayList<Order> takeawayOrders = new ArrayList<Order>();
        for (Order order : orders){
            if (order instanceof Takeaway){
                eatinOrders.add(order);
            }
        }
        return takeawayOrders;
    }

    //Returns arraylist of all deliveries - OJ
    //Empty arraylist if no match
    public ArrayList<Order> returnDeliveryOrders(){
        ArrayList<Order> deliveryOrders = new ArrayList<Order>();
        for (Order order : orders){
            if (order instanceof Delivery){
                eatinOrders.add(order);
            }
        }
        return deliveryOrders;
    }