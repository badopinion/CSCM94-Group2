package cafepackage.cafe94_group2;

import backend.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
		// Load Restaurant from file if possible, or create new Restaurant object if not. - JB
		Restaurant restaurant = null;
        File restaurantFile = new File("restaurant.ser");
        if(restaurantFile.isFile()){
            restaurant = loadRestaurant();
			if(restaurant.menu.returnMenuItemByName("Pasta Carbonara") == null) {
				restaurant.menu.createAndAddMenuItem("Pasta Carbonara", "An italian classic", 12.5f, true, false, MenuItemType.FOOD);
			}
        } else {
            //System.out.println("No restaurant file found. Creating new Restaurant data.");
            restaurant = new Restaurant();
            restaurant.saveRestaurant();
        }
		
		restaurant.saveRestaurant();
		
		// Launch JavaFX application.
        launch();
    }
	
	// Loads a restaurant from the file "restaurant.ser". This file contains all program state. - JB
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