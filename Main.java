import java.io.*;
import java.util.ArrayList;

public class Main{
    public static void main (String[] args){
        Table table1 = new Table(1, 6);
        System.out.println("Table number: " + table1.getTableNumber());

        // Try to load Menu from file. If a Menu exists in file, load that, otherwise make a new one. JB
        Menu cafe94Menu = loadOrCreateMenu();

        // Test Menu's ability to overwrite the file without inflating the size of "menu.ser" JB
        System.out.println("Testing overwrite:");
        saveMenuToFile(cafe94Menu);

        //Some testing below - OJ

//        System.out.println(cafe94Menu.returnMenuItemByName("Cheese Burger"));
//        cafe94Menu.setMenuItemIsOnOrOff("Cheese Burger", false);
//        System.out.println(cafe94Menu.returnMenuItemByName("Cheese Burger"));
//        cafe94Menu.setMenuItemSpecialOrNot("Cheese Burger", true);
//        System.out.println(cafe94Menu.returnMenuItemByName("Cheese Burger"));
//        System.out.println(cafe94Menu.returnMenuItemByName("Burger"));
//        cafe94Menu.setMenuItemSpecialOrNot("Burger", true);

        // Try to load login object from file. If no such file exists, create login object and populate with test data.
        Login login = loadOrCreateLogin();

        //Some testing below - JB
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

    // Checks whether a Menu object is saved to a file. If so it loads and returns it. JB
    // If there is no Menu object saved, it creates and saves a default, and returns that. JB
    public static Menu loadOrCreateMenu(){
        Menu res = null;
        File menuFile = new File("menu.ser");
        if(menuFile.isFile()){
            System.out.println("Attempting to load menu.");
            res = (Menu) loadMenuFromFile();
            System.out.println("Output from main after return:");
            res.printMenuItems(res.getCurrentItems());
        } else {
            System.out.println("No menu found. Creating menu.");
            res = new Menu();
            res.populateMenu();
            res.printMenuItems(res.getCurrentItems());
            System.out.println("Attempting to save menu.");
            saveMenuToFile(res);
        }
        return res;
    }

    // Loads a Menu object from the file "menu.ser" and returns that object. JB
    public static Menu loadMenuFromFile(){
        Menu res = null;
        try {
            FileInputStream fileIn = new FileInputStream("menu.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            res = (Menu) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Menu loaded.");
            res.printMenuItems(res.getCurrentItems());
        } catch (IOException i) {
            System.out.println("File IOException while trying to load menu from file.");
        } catch (ClassNotFoundException c) {
            System.out.println("Menu load failed. Menu class apparently doesn't exist.");
        }
        return res;
    }

    // Saves the Menu object to a file called "menu.ser". JB
    // If this file already exists it will be deleted to make way - otherwise the file inflates after every save. JB
    public static void saveMenuToFile(Menu menu){
        try {
            File menuFile = new File("menu.ser");
            if(menuFile.isFile()){
                if(menuFile.delete()){
                    System.out.println("Deleted old menu from file.");
                } else {
                    System.out.println("Failed to delete existing menu from file.");
                }
            }
            menuFile.createNewFile();
            FileOutputStream fileOut =
                    new FileOutputStream("menu.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(menu);
            out.close();
            fileOut.close();
            System.out.println("Menu saved to 'menu.ser'");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    // Checks whether a Login object is saved. If there is one, loads and returns it. JB
    // If there is no Login object saved, creates a default and returns that. JB
    public static Login loadOrCreateLogin(){
        Login res = null;
        File loginFile = new File("login.ser");
        if(loginFile.isFile()){
            System.out.println("Attempting to load login.");
            res = (Login) loadLoginFromFile();
        } else {
            System.out.println("No login object found. Creating login.");
            res = new Login();

            // Create and test login stuff. - JB
            res.newManager("manager", "madwithpower", "Bob", "Bossman", 1, "10 Downing Street");
            // Below: Check whether duplicate usernames can exist.
            // Wants returns of true for the first time we create Steve, then false for the second. JB
            System.out.println(res.newWaiter("waiter", "ihatetheserviceindustry", "Steve", "Loa", 2, "Under a bridge"));
            System.out.println(res.newWaiter("waiter", "ihatetheserviceindustry", "Steve", "Loa", 2, "Under a bridge"));
            res.loginWithCredentials("manager", "madwithpower");
            System.out.println(res.checkLoggedInUserType());
            User steve = res.getUserFromUsername("waiter");
            System.out.println(steve.getUsername());
            System.out.println(res.checkUserType(steve));

            saveLoginToFile(res);
        }
        return res;
    }

    // Loads a login object from the file "login.ser" and returns that object. JB
    public static Login loadLoginFromFile(){
        Login res = null;
        try {
            FileInputStream fileIn = new FileInputStream("login.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            res = (Login) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Login object loaded.");
        } catch (IOException i) {
            System.out.println("File IOException while trying to load login from file.");
        } catch (ClassNotFoundException c) {
            System.out.println("Login load failed. Login class apparently doesn't exist.");
        }
        return res;
    }

    // Saves the Login object to a file called "login.ser". JB
    // If this file already exists it will be deleted to make way - otherwise the file inflates after every save. JB
    public static void saveLoginToFile(Login login){
        try {
            File loginFile = new File("login.ser");
            if(loginFile.isFile()){
                if(loginFile.delete()){
                    System.out.println("Deleted old login object from file.");
                } else {
                    System.out.println("Failed to delete existing login object from file.");
                }
            }
            loginFile.createNewFile();
            FileOutputStream fileOut =
                    new FileOutputStream("login.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(login);
            out.close();
            fileOut.close();
            System.out.println("Menu saved to 'login.ser'");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}