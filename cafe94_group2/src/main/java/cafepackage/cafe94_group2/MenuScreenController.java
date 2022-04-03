//OJ is adding a test comment
package cafepackage.cafe94_group2;

import backend.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MenuScreenController {
    @FXML
    TextArea display;
    @FXML
    Button food;
    @FXML
    Button coffebtn;
    @FXML
    Button drinksbtn;

    public void sayHello(ActionEvent event) throws IOException {
        String hello = "Hello";
        display.setText(hello);
    }

    public void sayGoodbye(ActionEvent event) throws IOException {
        // Get the restaurant from the file. This should work fine verbatim no matter where you call it.
//        Restaurant res = new Load().getRestaurantFromFile();
        Load load = new Load();
        Restaurant res = load.loadRestaurant();

        // Do stuff.
        if(res.menu.getAllItems().size() == 0) {
            res.menu.populateMenu();
        }
        String hello = res.menu.returnMenuItems();
        display.setText(hello);

        //Save the restaurant to file, so you don't lose your changes.
        res.saveRestaurant();
    }


    public void displayFood(ActionEvent event)throws IOException{
        Restaurant res = new Load().getRestaurantFromFile();
        if(res.menu.getAllItems().size() == 0) {
            res.menu.populateMenu();
        }
        StringBuilder food = new StringBuilder();
        for(MenuItem menuItem: res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.FOOD)){
            food.append(menuItem.getName() + "\n" );
        }
        display.setText(String.valueOf(food));

    }

    public void displayCoffee(ActionEvent event)throws IOException{
        Restaurant res = new Load().getRestaurantFromFile();
        if(res.menu.getAllItems().size() == 0) {
            res.menu.populateMenu();
        }
        StringBuilder food = new StringBuilder();
        for(MenuItem menuItem: res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.COFFEE)){
            food.append(menuItem.getName() + "\n" );
        }
        display.setText(String.valueOf(food));

    }

    public void displayDrink(ActionEvent event)throws IOException{
        Restaurant res = new Load().getRestaurantFromFile();
        if(res.menu.getAllItems().size() == 0) {
            res.menu.populateMenu();
        }
        StringBuilder food = new StringBuilder();
        for(MenuItem menuItem: res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.DRINK)){
            food.append(menuItem.getName() + "\n" );
        }
        display.setText(String.valueOf(food));
    }

//    public void displayFood(ActionEvent event)throws IOException{
//        Load load = new Load();
//        Restaurant res = load.loadRestaurant();
//        if(res.menu.getAllItems().size() == 0) {
//            res.menu.populateMenu();
//        }
//        StringBuilder food = new StringBuilder();
//        for(MenuItem menuItem: res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.FOOD)){
//            food.append(menuItem.getName() + "\n" );
//        }
//        display.setText(String.valueOf(food));
//
//    }
//
//    public void displayCoffee(ActionEvent event)throws IOException{
//        Load load = new Load();
//        Restaurant res = load.loadRestaurant();
//        if(res.menu.getAllItems().size() == 0) {
//            res.menu.populateMenu();
//        }
//        StringBuilder food = new StringBuilder();
//        for(MenuItem menuItem: res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.COFFEE)){
//            food.append(menuItem.getName() + "\n" );
//        }
//        display.setText(String.valueOf(food));
//
//    }
//
//    public void displayDrink(ActionEvent event)throws IOException{
//        Load load = new Load();
//        Restaurant res = load.loadRestaurant();
//        if(res.menu.getAllItems().size() == 0) {
//            res.menu.populateMenu();
//        }
//        StringBuilder food = new StringBuilder();
//        for(MenuItem menuItem: res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.DRINK)){
//            food.append(menuItem.getName() + "\n" );
//        }
//        display.setText(String.valueOf(food));
//
//    }


}
