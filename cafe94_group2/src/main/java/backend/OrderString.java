package backend;

/**
 * an OrderString class used for displaying orders in tableview
 * @author Oliver Jackson
 * version 1
 */

public class OrderString {

    private String orderedString;
    private String customerUserName;
    private String tableNumber;
    private String orderType;
    private String orderDateTime;

    /**
     * Constructor
     * @param orderString
     * @param customerUserName
     * @param tableNumber
     * @param orderType
     * @param orderDateTime
     */
    public OrderString(String orderString, String customerUserName, String tableNumber, String orderType, String orderDateTime) {
        this.orderedString = orderString;
        this.customerUserName = customerUserName;
        this.tableNumber = tableNumber;
        this.orderType = orderType;
        this.orderDateTime = orderDateTime;
    }

    /**
     * getters and setters
     * @return
     */
    public String getOrderedString() {
        return orderedString;
    }


    public void setOrderString(String orderString) {
        this.orderedString = orderString;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * method to return the datetime order was placed
     * @return the order datetime
     */
    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }
}
