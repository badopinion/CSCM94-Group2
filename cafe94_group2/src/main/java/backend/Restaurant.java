package backend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.*;

/**
 * A Restaurant class that aggregates orders and holds methods to show outstanding orders. Also aggregates Tables.
 * One instance. Restaurant also holds reference to other single-instance aggregator objects.
 * Restaurant can be saved to disk, which saves the entire program state due to the references it holds.
 * @author Oliver Jackson, Jo Butler
 * @version 2
 */

public class Restaurant implements Serializable {
    // Order functionality variables - OJ
    private ArrayList<Order> orders;
    //order counter is the number of orders ever ordered, and is used for orderID - OJ
    private int orderCounter;
    private ArrayList<String> temporaryOrderStringList = new ArrayList<>();
    private ArrayList<MenuItem> temporaryOrderList = new ArrayList<MenuItem>();


    /**
     * Restaurant aggregates tables
     */

    private Table[] tables;

    /**
     * References to other aggregator methods
     */
    public Login login;
    public Menu menu;

    /**
     *  Constructor
     */
    public Restaurant() {
        this.orders = new ArrayList<Order>();
        this.orderCounter = 0;
        this.login = new Login();
        this.menu = new Menu();
        this.menu.populateMenu();
        //addOrders();
        this.tables = new Table[] {
                new Table(1,2), new Table(2,2), new Table(3,2), new Table(4,2),
                new Table(5,4), new Table(6,4), new Table(7,4), new Table(8,4),
                new Table(9,8), new Table(10,8), new Table(11,10)
        };
    }

    /**
     * Getters
     */
    public int getOrderCounter() {
        return orderCounter;
    }

    public ArrayList<Order> getAllOrders() {
        return orders;
    }

    public Table getTable(int tableNumber){
        return tables[tableNumber-1]; // I assume the restaurant itself doesn't use java's 0-based indexing - JB
    }


    public ArrayList<MenuItem> getTemporaryOrderList() {
        return temporaryOrderList;
    }

    public ArrayList<String> getTemporaryOrderStringList() {
        return temporaryOrderStringList;
    }

    public Table[] getAllTables(){
        return tables;
    }

    /**
     * Setters
     * @param orderCounter the order counter
     */
    public void setOrderCounter(int orderCounter) {
        this.orderCounter = orderCounter;
    }

    public void setTemporaryOrderList(ArrayList<MenuItem> temporaryOrderList) {
        this.temporaryOrderList = temporaryOrderList;
    }

    public void setTemporaryOrderStringList(ArrayList<String> temporaryOrderStringList) {
        this.temporaryOrderStringList = temporaryOrderStringList;
    }

    /**
     * @param order method to add order to orders
     */
    public void addOrder(Order order){
        orders.add(order);
    }

    /**
     * @param stringList convert an arraylist of strings
     * @param menu to an arraylist of menuitems
     * @return returns menu list
     */
    public ArrayList<MenuItem> convStringListToMIList(ArrayList<String> stringList, Menu menu) {
        ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
        for (String itemString : stringList) {
            MenuItem newMenuItem = menu.returnMenuItemByName(itemString);
            if (newMenuItem != null) {
                menuItemList.add(newMenuItem);
            }
        }
        return menuItemList;
    }

    /**
     * method to show all orders that have not been fulfilled and have not been cancelled
     * @return returns an ArrayList of orders not done
     */
    public ArrayList<Order> unfulfilledOrders(){
        ArrayList<Order> unfulfilledOrders = new ArrayList<Order>();
        for(Order order : orders){
            if (order.isOrderCompleted() == false){
                if (order.isOrderCancelled() == false) {
                    unfulfilledOrders.add(order);
                }
            }
        }
        return unfulfilledOrders;
    }


    /**
     * @param customer Method that takes a Customer object and returns a customer order history arraylist
     * @return returns an empty arraylist if no orders match
     */
    public ArrayList<Order> returnCustomerOrderHistory(Customer customer) {
        ArrayList<Order> customerOrders = new ArrayList<Order>();
        for (Order order : orders) {
            if (order.getCustomer() == customer) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }


    /**
     * @return Returns arraylist of all eatins , Empty arraylist if no match
     */
    public ArrayList<Order> returnEatInOrders(){
        ArrayList<Order> eatinOrders = new ArrayList<Order>();
        for (Order order : orders){
            if (order instanceof EatIn){
                eatinOrders.add(order);
            }
        }
        return eatinOrders;
    }

    /**
     * @return Returns arraylist of all takeaways ,Empty arraylist if no match
     */
    public ArrayList<Order> returnTakeawayOrders(){
        ArrayList<Order> takeawayOrders = new ArrayList<Order>();
        for (Order order : orders){
            if (order instanceof Takeaway){
                takeawayOrders.add(order);
            }
        }
        return takeawayOrders;
    }

    /**
     * @return Returns arraylist of all deliveries , Empty arraylist if no match
     */
    public ArrayList<Order> returnDeliveryOrders(){
        ArrayList<Order> deliveryOrders = new ArrayList<Order>();
        for (Order order : orders){
            if (order instanceof Delivery){
                deliveryOrders.add(order);
            }
        }
        return deliveryOrders;
    }

    /**
     * Make a booking on the smallest available table.
     * @param guestCount the guest count
     * @param bookingTime the booking time
     * @param bookingDuration the duration of the booking
     * @param customer the customer
     * @return Return the table number or 0 if impossible.
     */
    public int findTableAndBook(int guestCount, LocalDateTime bookingTime, long bookingDuration, Customer customer){
        for(int i = 1; i < tables.length; i++){
            if(tables[i-1].addBooking(guestCount, bookingTime, bookingDuration, customer)){
                return i;
            }
        }
        return 0;
    }


    /**
     * Method sets an order in the order arraylist as complete
     * @param completedOrder the order to mark complete
     */
    public void setOrderComplete(Order completedOrder){
        for (Order order : orders) {
            if (order.equals(completedOrder)){
                order.setOrderCompleted(true);
            }
        }
    }

    /**
     * method to take a string representing date time and return an order with a corresponding time
     * @param dateTimeString the time that the order was placed
     * @return
     */
    public Order returnOrderByOrderTimeString(String dateTimeString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd : HH mm ss");
        for (Order order : orders){
            String orderTime = order.getOrderDateTime().format(formatter);
            if (orderTime.equals(dateTimeString)){
                return order;
            }
        }
        return null;
    }




    /**
     * turns an arraylist of order objects into orderstring objects for displaying in tableview
     * @param ordersArrayList
     * @return Order list
     */
    public ArrayList<OrderString> convertOrdersToStringArray(ArrayList<Order> ordersArrayList){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd : HH mm ss");
        ArrayList<OrderString> orderStringArrayList = new ArrayList<>();
        for (Order order: ordersArrayList){
            String orderedString = "";
            String customerUserName = order.getCustomer().getUsername();
            String tableNumber = "";
            String orderType = order.typeOfOrder();
            String orderDateTime = "";
            for (MenuItem menuItem : order.getOrderedMenuItems()){
                orderedString = orderedString + menuItem.getName() + ", ";
            }
            if (orderType.equals("Eat In")){
                EatIn eatin = (EatIn) order;
                tableNumber = String.valueOf(eatin.getTable().getTableNumber());
            } else {
                tableNumber = "NA";
            }
            orderDateTime = order.getOrderDateTime().format(formatter);
            OrderString newOrderString = new OrderString(orderedString, customerUserName, tableNumber, orderType, orderDateTime);
            orderStringArrayList.add(newOrderString);
        }
        return orderStringArrayList;
    }

    /**
     * Saves the restaurant object (and all aggregated or referenced objects with it - full system state save)
     * Please note the load function is in Main. Need to be able to load without previous instance existing
     */

    public void saveRestaurant(){
        try {
            File restaurantFile = new File("restaurant.ser");
            if(restaurantFile.isFile()){
                System.out.println("Attempting to overwrite old Restaurant data:");
                if(restaurantFile.delete()){
                    System.out.println("Deleted old Restaurant data from file.");
                } else {
                    System.out.println("Attempted to delete old Restaurant data from file, but failed.");
                }
            }
            restaurantFile.createNewFile();
            FileOutputStream fos = new FileOutputStream("restaurant.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
            System.out.println("Restaurant object saved to restaurant.ser");
        } catch (IOException ioe) {
            System.out.println("IOException while trying to save Restaurant object.");
            ioe.printStackTrace();
        }
    }
}