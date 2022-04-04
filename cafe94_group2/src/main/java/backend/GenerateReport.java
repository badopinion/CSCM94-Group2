package backend;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;


public class GenerateReport {
    private ArrayList<Order> orderHist;
    public GenerateReport(ArrayList<Order> orderHist){
        this.orderHist = orderHist;
    }

    public ArrayList<FoodFeq> getPopularDish(ArrayList<Order> orderHist){
       ArrayList<MenuItem> allItems = new ArrayList();
        for (Order order:orderHist){
            for (MenuItem item: order.getOrderedMenuItems()){
                allItems.add(item);
            }
       }
        ArrayList<String> itemString = new ArrayList();
        ArrayList<FoodFeq> feq = new ArrayList();
        for (MenuItem item : allItems){
            itemString.add(item.getName());
        }
        Set<String> uniqueSet = new HashSet<String>(itemString);
        for (String i : uniqueSet) {
            feq.add(new FoodFeq(i,Collections.frequency(itemString, i)));
        }
        return feq;
    }

    private float convertShiftsIntoInt(ArrayList<Shift> shiftList,Date currentDate){
        float shiftTime = 0;
        for (Shift shift : shiftList){
            String dateToString = shift.getStart().toString();
            String hourString =  dateToString.substring(11,13);
            String minuteString =  dateToString.substring(14,16);
            int hour = Integer.parseInt(hourString)*100;
            int minute = Integer.parseInt(minuteString);
            int startShiftTime = (hour + minute);
            String dateToStringES = shift.getEnd().toString();
            String hourStringES =  dateToStringES.substring(11,13);
            String minuteStringES =  dateToStringES.substring(14,16);
            int hourES = Integer.parseInt(hourStringES)*100;
            int minuteES = Integer.parseInt(minuteStringES);
            int endShiftTime = (hourES + minuteES);
            if(endShiftTime-startShiftTime >shiftTime){
                shiftTime = endShiftTime-startShiftTime;
            }

        }
        return shiftTime;

    }
    public String whichStaffHasWorkedTheMostReport(ArrayList<Staff> staffList,Date currentDate){
        Staff staffWhoHasWorkedTheMost = staffList.get(0);
        float highestShift = 0;
        for (Staff staff : staffList){
            float staffWorkedFor = convertShiftsIntoInt(staff.getShifts(),currentDate);
            if( staffWorkedFor > highestShift){
                highestShift = staffWorkedFor;
                staffWhoHasWorkedTheMost = staff;
            }

        }
        return staffWhoHasWorkedTheMost.getUsername();
    }

    public String mostActiveCustomer(ArrayList<Order> allOrders){
        Customer customer = allOrders.get(0).getCustomer();
        Integer orderSize = 0;
        Map<Customer,List<Order>> mappedList = allOrders.stream().collect((groupingBy(order->order.getCustomer())));
        for(Map.Entry<Customer,List<Order>> orderHis:mappedList.entrySet()){
            if (orderHis.getValue().size() <orderSize){
                customer = orderHis.getValue().get(0).getCustomer();
                orderSize = orderHis.getValue().size();
            }
        }
        return customer.getUsername();

    }





}
