package backend;

import java.io.*;

/**
 * Load class is used to get the Restaurant object out of a file or to create a new one if no such file exists.
 * @author Jo Butler
 * @version 1
 */

public class Load {
    // Checks if a file called "restaurant.ser" exists. Exists: returns Restaurant object from file. - JB
    // Does not exist: instantiates a new restaurant and returns. - JB
    public Restaurant loadRestaurant() {
        Restaurant restaurant = null;
        File restaurantFile = new File("restaurant.ser");
        if (restaurantFile.isFile()) {
            restaurant = loadRestaurant();
            if (restaurant.menu.returnMenuItemByName("Pizza Margharita") == null) {
                restaurant.menu.createAndAddMenuItem("Pizza Margharita", "Another italian classic", 12.5f, true, false, MenuItemType.FOOD);
            }
        } else {
            //System.out.println("No restaurant file found. Creating new Restaurant data.");
            restaurant = new Restaurant();
        }
        return restaurant;
    }

    // Loads a restaurant from the file "restaurant.ser". This file contains all program state. - JB
    public Restaurant getRestaurantFromFile(){
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
