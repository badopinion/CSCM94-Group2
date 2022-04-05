package backend;

import java.io.*;

/**
 * Load class is used to get the Restaurant object out of a file or to create a new one if no such file exists.
 * @author Jo Butler , Yingfan Zhang
 * @version 1
 */

public class Load {
    /**
     * Due to confusion both these methods now do the same thing, unifying the previous two methods.
     * @return returining the restaurant
     */
    public Restaurant loadRestaurant() {
        return getRestaurantFromFile();
    }

    /**
     *  Loads a Restaurant object from the file "restaurant.ser". This file contains all program state.
     *   If no such file exists a new restaurant.ser containing a fresh Restaurant object will be made.
     * @return returning restaurant
     */
    public Restaurant getRestaurantFromFile(){
        Restaurant res = null;
        File restaurantFile = new File("restaurant.ser");
        if (restaurantFile.isFile()) {
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
        } else {
            res = new Restaurant();
            res.saveRestaurant();
        }
        return res;
    }
}
