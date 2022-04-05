package backend;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
/**
 * A report generating class. This class hold the methods to return the "most popular items",
 * "Most active customer", "Busiest periods in the restaurant", "Staff member with most hours worked".
 * @author Sam Raine , Adam Schmidt
 * @version 2
 */

public class GenerateReport {


    public GenerateReport() {

    }


    // Method to find the most popular dish - SR
    // Generates New array list to hold all ordered menu items - SR
    // Returns the frequency the item has been ordered and items name - SR
    public ArrayList<FoodFeq> getPopularDish(ArrayList<Order> orderHist){
        ArrayList<MenuItem> allItems = new ArrayList();
        for (Order order:orderHist){
            for (MenuItem item: order.getOrderedMenuItems()){
                allItems.add(item);
            }
       }

        // Creates two new arraylists name and frequency of most ordered items -SR
        ArrayList<String> itemString = new ArrayList();
        ArrayList<FoodFeq> feq = new ArrayList();
        for (MenuItem item : allItems){
            itemString.add(item.getName());
        }
        Set<String> uniqueSet = new HashSet<String>(itemString);
        for (String i : uniqueSet) {
            feq.add(new FoodFeq(i, Collections.frequency(itemString, i)));
        }
        return feq;
    }

    // Method to convert the shift format into integers - SR
    // Returns a float to represent shift time - SR
    private float convertShiftsIntoInt(ArrayList<Shift> shiftList){
        float shiftTime = 0;
        for (Shift shift : shiftList){
            String dateToString = shift.getStart().toString();
            String hourString =  dateToString.substring(11, 13);
            String minuteString =  dateToString.substring(14, 16);
            int hour = Integer.parseInt(hourString)*100;
            int minute = Integer.parseInt(minuteString);
            int startShiftTime = (hour + minute);
            String dateToStringES = shift.getEnd().toString();
            String hourStringES =  dateToStringES.substring(11, 13);
            String minuteStringES =  dateToStringES.substring(14, 16);
            int hourES = Integer.parseInt(hourStringES)*100;
            int minuteES = Integer.parseInt(minuteStringES);
            int endShiftTime = (hourES + minuteES);
            if (endShiftTime-startShiftTime >shiftTime){
                shiftTime = endShiftTime-startShiftTime;
            }

        }
        return shiftTime;

    }

    // Method to Find out which staff has the worked the most hours from shift time float - SR
    // Returns the first and last name string of the staff with most hours worked -  SR
    public String whichStaffHasWorkedTheMostReport(ArrayList<Staff> staffList){
        Staff staffWhoHasWorkedTheMost = staffList.get(0);
        float highestShift = 0;
        for (Staff staff : staffList){
            float staffWorkedFor = convertShiftsIntoInt(staff.getShifts());
            if (staffWorkedFor > highestShift){
                highestShift = staffWorkedFor;
                staffWhoHasWorkedTheMost = staff;
            }

        }
        return staffWhoHasWorkedTheMost.getFirstName() + " " + staffWhoHasWorkedTheMost.getLastName();
    }

    // Method to find out which customer has placed the most orders to determine activity - SR
    // Returns first and last name string of most active customer - SR
    public String mostActiveCustomer(ArrayList<Order> allOrders){
        if (allOrders.size() == 0){
            return "NONE";
        }
        Customer customer = allOrders.get(0).getCustomer();
        Integer orderSize = 0;
        Map<Customer, List<Order>> mappedList = allOrders.stream().collect((groupingBy(order->order.getCustomer())));
        for (Map.Entry<Customer, List<Order>> orderHis:mappedList.entrySet()){
            if (orderHis.getValue().size() <orderSize){
                customer = orderHis.getValue().get(0).getCustomer();
                orderSize = orderHis.getValue().size();
            }
        }
        return customer.getFirstName()+ " "+ customer.getLastName();

    }

    // Method to find out the period  in which  the most orders placed - SR/JB
    // Returns a string holding busiest period and number of orders placed - SR/JB
    public String mostActivePeriodReport(){
        Restaurant res = new Load().loadRestaurant();
        ArrayList<Order> allOrders = res.getAllOrders();
        // Array of 24 ints, representing the number of orders placed during the respective hour of the day.
        int[] hours = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (Order o : allOrders){
            int hour = o.getOrderDateTime().getHour();
            hours[hour]++;
        }
        int highestCount = -1;
        int highestIndex = -1;
        for (int i = 0; i < 24; i++){
            if (hours[i] > highestCount){
                highestIndex = i;
                highestCount = hours[i];
            }
        }
        return "The busiest hour of the day is " + highestIndex + ":00 until " + highestIndex
                + ":59, where " + highestCount + " orders have been placed.";
    }





}
