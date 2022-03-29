import java.io.*;

/**
 * Upon program start, main creates Restaurant, by loading from save data or making a new one if no saved data exists.
 * Most other methods are accessed through Restaurant.
 * @author Jo Butler
 * @version 2
 */

public class Main{
    public static void main (String[] args){

        //If a file called restaurant.ser exists: load the Restaurant object from that file.
        //If no such file exists, instantiate a new Restaurant object. - JB
        Restaurant restaurant = null;
        File restaurantFile = new File("restaurant.ser");
        if(restaurantFile.isFile()){
            restaurant = loadRestaurant();
        } else {
            System.out.println("No restaurant file found. Creating new Restaurant data.");
            restaurant = new Restaurant();
            restaurant.saveRestaurant();
        }

        //Tests from before restaurant reword. Preserved for reference, to be removed before submission - JB

//        Table table1 = new Table(1, 6);
//        System.out.println("Table number: " + table1.getTableNumber());

//        Menu cafe94Menu = new Menu();
//        cafe94Menu.populateMenu();
//        cafe94Menu.printMenuItems();
//        cafe94Menu.createAndAddMenuItem("Pasta Carbonara", "An italian classic", 12.5f, true, false);
//        cafe94Menu.printMenuItems();
//        System.out.println(cafe94Menu.returnMenuItemByName("Pasta Carbonara"));

//        Customer jamesTabor = new Customer("jamesTabor", "1234", "james", "tabor", "10 Swansea Road, Swansea, Wales");
//        Restaurant cafe94 = new Restaurant();

//        cafe94Menu.placeEatInOrder(cafe94, jamesTabor, "", table1, cafe94Menu.returnMenuItemByName("Cheese Burger"), cafe94Menu.returnMenuItemByName("Mushroom soup"));
//        cafe94Menu.placeTakeawayOrder(cafe94, jamesTabor, "", "12:30", cafe94Menu.returnMenuItemByName("Cheese Burger"));
//        cafe94Menu.placeDeliveryOrder(cafe94, jamesTabor, "", "1 Swansea Lane, Swansea", cafe94Menu.returnMenuItemByName("Cheese Burger"));
//        System.out.println("James would like to order");
//        System.out.println(cafe94.returnCustomerOrderHistory(jamesTabor));
//        System.out.println("eatIn orders:");
//        System.out.println(cafe94.returnEatInOrders());
//        System.out.println("takeaway orders:");
//        System.out.println(cafe94.returnTakeawayOrders());
//        System.out.println("delivery orders:");
//        System.out.println(cafe94.returnDeliveryOrders());



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
    }

    // Loads a Restaurant object from the file "restaurant.ser". - JB
    public static Restaurant loadRestaurant(){
        Restaurant res = null;
        try {
            FileInputStream fIn = new FileInputStream("restaurant.ser");
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            res = (Restaurant) oIn.readObject();
            oIn.close();
            fIn.close();
            System.out.println("Restaurant object loaded.");
        } catch (ClassNotFoundException cnf) {
            System.out.println("Load failure! Restaurant class apparently does not exist.");
        } catch (IOException ioe) {
            System.out.println("Load failure! IOException while trying to load Restaurant object from file.");
        }
        return res;
    }
}