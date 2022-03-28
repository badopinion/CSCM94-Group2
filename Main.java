import java.util.ArrayList;

public class Main{
    public static void main (String[] args){
        Table table1 = new Table(1, 6);
        System.out.println("Table number: " + table1.getTableNumber());

        Menu cafe94Menu = new Menu();
        cafe94Menu.populateMenu();
        cafe94Menu.printMenuItems(cafe94Menu.getCurrentItems());


        //Some testing below - OJ

//        System.out.println(cafe94Menu.returnMenuItemByName("Cheese Burger"));
//        cafe94Menu.setMenuItemIsOnOrOff("Cheese Burger", false);
//        System.out.println(cafe94Menu.returnMenuItemByName("Cheese Burger"));
//        cafe94Menu.setMenuItemSpecialOrNot("Cheese Burger", true);
//        System.out.println(cafe94Menu.returnMenuItemByName("Cheese Burger"));
//        System.out.println(cafe94Menu.returnMenuItemByName("Burger"));
//        cafe94Menu.setMenuItemSpecialOrNot("Burger", true);

      //Some testing below - JB

//        Login login = new Login();
//        login.newManager("manager", "madwithpower", "Bob", "Bossman", 1, "10 Downing Street");
//        // Below: Check whether duplicate usernames can exist.
//        // Wants returns of true for the first time we create Steve, then false for the second. JB
//        System.out.println(login.newWaiter("waiter", "ihatetheserviceindustry", "Steve", "Loa", 2, "Under a bridge"));
//        System.out.println(login.newWaiter("waiter", "ihatetheserviceindustry", "Steve", "Loa", 2, "Under a bridge"));
//        login.loginWithCredentials("manager", "madwithpower");
//        System.out.println(login.checkLoggedInUserType());
//        User steve = login.getUserFromUsername("waiter");
//        System.out.println(steve.getUsername());
//        System.out.println(login.checkUserType(steve));

        //Save Testing - SR

        Customer customer = new Customer("Sam","password","Sam","Raine","Swansea",1);
        Customer customer2 = new Customer("Sam2","password","Sam2","Raine2","Swansea",2);
        ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
        customerArrayList.add(customer);
        customerArrayList.add(customer2);
        Save save = new Save();
        save.saveCustomers(customerArrayList);

    }

}