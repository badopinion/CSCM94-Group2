//OJ is adding a test comment
package cafepackage.cafe94_group2;

import backend.*;

import backend.MenuItem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.scene.control.SplitMenuButton;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MenuScreenController implements Initializable {
    @FXML
    private ListView<String> display, displayTwo;

    @FXML
    Button foodbtn;
    @FXML
    Button coffebtn;
    @FXML
    Button drinksbtn;
    @FXML
    Button add;
    @FXML
    Button remove;
    @FXML
    ChoiceBox <String>choicebox;
    String[] options = {"eat-in","delivery","takeaway"};
    public void initialize(URL arg0, ResourceBundle arg1){
        choicebox.getItems().addAll(options);
      }
    @FXML
    Label mylabel;





//    public void sayGoodbye(ActionEvent event) throws IOException {
//        // Get the restaurant from the file. This should work fine verbatim no matter where you call it.
////        Restaurant res = new Load().getRestaurantFromFile();
//        Load load = new Load();
//        Restaurant res = load.loadRestaurant();
//
//        // Do stuff.
//        if (res.menu.getAllItems().size() == 0) {
//            res.menu.populateMenu();
//        }
//        String hello = res.menu.returnMenuItems();
//        display.setText(hello);
//
//        //Save the restaurant to file, so you don't lose your changes.
//        res.saveRestaurant();
//    }

//
//    public void displayFood(ActionEvent event)throws IOException{
//        Restaurant res = new Load().getRestaurantFromFile();
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
//        Restaurant res = new Load().getRestaurantFromFile();
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
//        Restaurant res = new Load().getRestaurantFromFile();
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

    public void displayDrink(ActionEvent event)throws IOException{
        Restaurant res = new Load().getRestaurantFromFile();
        if(res.menu.getAllItems().size() == 0) {
            res.menu.populateMenu();
        }
        StringBuilder drinkMenu = new StringBuilder();
        for(MenuItem menuItem: res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.DRINK)){
            drinkMenu.append(menuItem.getName() + "\n" );
        }
        display.getItems().clear();
        String drinkMenuString = drinkMenu.toString();
        ObservableList<String> drinkMenuList = FXCollections.observableArrayList(drinkMenuString);
        display.setItems(drinkMenuList);

    }

    public void displayFood(ActionEvent event)throws IOException{
        Restaurant res = new Load().getRestaurantFromFile();
        if(res.menu.getAllItems().size() == 0) {
            res.menu.populateMenu();
        }
        StringBuilder foodMenu = new StringBuilder();
        for(MenuItem menuItem: res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.FOOD)){
            foodMenu.append(menuItem.getName() + "\n" );
        }
        display.getItems().clear();
        String foodMenuString = foodMenu.toString();
        ObservableList<String> foodMenuList = FXCollections.observableArrayList(foodMenuString);
        display.setItems(foodMenuList);

    }

    public void displayCoffee(ActionEvent event)throws IOException{
        Restaurant res = new Load().getRestaurantFromFile();
        if(res.menu.getAllItems().size() == 0) {
            res.menu.populateMenu();
        }
        StringBuilder coffeeMenu = new StringBuilder();
        for(MenuItem menuItem: res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.COFFEE)){
            coffeeMenu.append(menuItem.getName() + "\n" );
        }
        display.getItems().clear();
        String coffeeMenuString = coffeeMenu.toString();
        ObservableList<String> coffeeMenuList = FXCollections.observableArrayList(coffeeMenuString);
        display.setItems(coffeeMenuList);

    }
//
//    public void setOnAction(ActionEvent event)throws IOException{
//    SplitMenuButton menu = new SplitMenuButton();
//    splitMenu.setText("order type");
//    MenuItem choice1 = new MenuItem("Choice 1");
//    MenuItem choice2 = new MenuItem("Choice 2");
//    MenuItem choice3 = new MenuItem("Choice 3");
//
//    choice1.setOnAction((e)-> {
//        System.out.println("Eat in ");
//    });
//     choice2.setOnAction((e)-> {
//        System.out.println("Delivery");
//    });
//    choice3.setOnAction((e)-> {
//        System.out.println("Takeaway");
//    });
//        splitMenu.setOnAction((e) -> {
//            System.out.println("SplitMenuButton clicked!");
//        });


//
//    private void AddToOrder(ActionEvent actionEvent) {
//        if (foodMenuList.isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Warning!!");
//            alert.setHeaderText("Add to Order Failed");
//            alert.setContentText("No donuts selected.");
//            alert.showAndWait();
//        }
//        else {
//            for (int i = 0; i < foodMenuList.size(); i++) {
//                currentOrder.add(donutOrderList.get(i));
//            }
//            foodMenuList = new ArrayList<Food>();
//            donutQuantityMenu.getSelectionModel().select(0);
//            chooseDonutMenu.getSelectionModel().select(0);
//            String priceString = DECIMAL_FORMATTER.format(totalPrice(donutOrderList));
//            donutPriceDisplay.setText("$" + priceString);
//            donutDisplay.getItems().clear();
//
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Confirmation");
//            alert.setHeaderText("Add to Order");
//            alert.setContentText("Donuts added to order.");
//            alert.showAndWait();
//        }
//    }



    //03/04/22
//    public void displayDrink(ActionEvent event) throws IOException {
//        Restaurant res = new Load().getRestaurantFromFile();
//        if (res.menu.getAllItems().size() == 0) {
//            res.menu.populateMenu();
////            StringBuilder drink = new StringBuilder();
//            String drink = "";
//            for(MenuItem menuItem: res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.DRINK)) {
////                drink.append(menuItem.getName());
////                drink.append(menuItem.getName() + "\n");
//                drink = drink + menuItem.getName();
//            }
////            ObservableList<String> drinkMenu = FXCollections.observableArrayList(String.valueOf(drink));
//            ObservableList<String> drinkMenu = FXCollections.observableArrayList(drink);
//            display.getItems().clear();
//            display.setItems(drinkMenu);
//        }


//    private void displayFood(ActionEvent actionEvent) {
//        Object selectedItem = chooseDonutMenu.getSelectionModel().getSelectedItem();
//        if (selectedItem.equals("Food")) {
//            ObservableList<String> Menu = FXCollections.observableArrayList(backend.MenuItem);
//            ListView.getItems().clear();
//            donutFlavorListView.setItems(MenuItem);
//            donutQuantityMenu.getSelectionModel().select(0);
//        }
//        else if (selectedItem.equals("Cake Donuts")) {
//            ObservableList<String> donutFlavorList = FXCollections.observableArrayList("Strawberry Cheesecake",
//                    "Boston Cream Pie", "Birthday Cake");
//            donutFlavorListView.getItems().clear();
//            donutFlavorListView.setItems(donutFlavorList);
//            donutQuantityMenu.getSelectionModel().select(0);
//        }
//        else if (selectedItem.equals("Donut Holes")) {
//            ObservableList<String> donutFlavorList = FXCollections.observableArrayList("Glazed", "Chocolate", "Jelly");
//            donutFlavorListView.getItems().clear();
//            donutFlavorListView.setItems(donutFlavorList);
//            donutQuantityMenu.getSelectionModel().select(0);
//        }
//    }

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

