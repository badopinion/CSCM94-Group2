public class Main{
    public static void main (String[] args){
        Table table1 = new Table(1, 6);
        System.out.println("Table number: " + table1.getTableNumber());

        Restaurant cafe94 = new Restaurant();
        Menu cafe94Menu = new Menu();
        cafe94Menu.populateMenu();
        cafe94Menu.printMenuItems();


        Customer jamesTabor = new Customer("jamesTabor", "1234", "james", "tabor", "10 Swansea Road, Swansea, Wales");


        cafe94Menu.placeEatInOrder(cafe94, jamesTabor, "", table1, cafe94Menu.returnMenuItemByName("Cheese Burger"), cafe94Menu.returnMenuItemByName("Mushroom soup"));
        cafe94Menu.placeTakeawayOrder(cafe94, jamesTabor, "", "12:30", cafe94Menu.returnMenuItemByName("Cheese Burger"));
        cafe94Menu.placeDeliveryOrder(cafe94, jamesTabor, "", "1 Swansea Lane, Swansea", cafe94Menu.returnMenuItemByName("Cheese Burger"));
        System.out.println();
        System.out.println(cafe94.returnCustomerOrderHistory(jamesTabor));
        System.out.println();
        System.out.println(cafe94Menu.returnMenuItemsByType(cafe94Menu.getCurrentItems(), MenuItemType.COFFEE));





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
}