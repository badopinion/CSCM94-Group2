//OJ is adding a test comment
package cafepackage.cafe94_group2;

import backend.*;

import backend.Menu;
import backend.MenuItem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.scene.control.SplitMenuButton;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Double.sum;

public class MenuScreenController implements Initializable {
    @FXML
    private ListView<String> display, displayTwo;
    @FXML
    private TextField priceDisplay;
    @FXML
    private ComboBox <String> chooseMenu, chooseType;
    private ArrayList<String> orderList = new ArrayList<String>();
    private MenuItem Order;
    @FXML
    Button addButton;
    @FXML
    Button removeButton;

    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("###,##0.00");
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> chooseMenuList = FXCollections.observableArrayList("Food", "Drinks",
                "Coffee");
        chooseMenu.setItems(chooseMenuList);
        chooseMenu.getSelectionModel().select(0);
        ObservableList<String> foodList = FXCollections.observableArrayList("Cheese Burger", "Ham and cheese toastie",
                "Mushroom soup","American hot pizza","Pasta Carbonara");
        display.getItems().clear();
        display.setItems(foodList);

        ObservableList<String> typeList = FXCollections.observableArrayList("Eat-in", "Take away", "Delivery");
        chooseType.setItems(typeList);
        chooseType.getSelectionModel().select(0);
    }

    @FXML
    private void processChooseMenu(ActionEvent actionEvent) {
        Restaurant res = new Load().getRestaurantFromFile();
        Object selectedItem = chooseMenu.getSelectionModel().getSelectedItem();
        if (selectedItem.equals("Food")) {
            ArrayList<MenuItem> menuItems = new ArrayList<>(res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.FOOD));
            ArrayList<String> menuItemNames = new ArrayList<>();
            for(MenuItem menuItem : menuItems){
                menuItemNames.add(menuItem.getName());
            }
            ObservableList<String> orderList = FXCollections.observableArrayList(menuItemNames);
            display.getItems().clear();
            display.setItems(orderList);

        }
        else if (selectedItem.equals("Drinks")) {
            ArrayList<MenuItem> menuItems = new ArrayList<>(res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.DRINK));
            ArrayList<String> menuItemNames = new ArrayList<>();
            for(MenuItem menuItem : menuItems){
                menuItemNames.add(menuItem.getName());
            }
            ObservableList<String> orderList = FXCollections.observableArrayList(menuItemNames);
            display.getItems().clear();
            display.setItems(orderList);
        }
        else if (selectedItem.equals("Coffee")) {
            ArrayList<MenuItem> menuItems = new ArrayList<>(res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.COFFEE));
            ArrayList<String> menuItemNames = new ArrayList<>();
            for(MenuItem menuItem : menuItems){
                menuItemNames.add(menuItem.getName());
            }
            ObservableList<String> orderList = FXCollections.observableArrayList(menuItemNames);
            display.getItems().clear();
            display.setItems(orderList);
        }
    }

    @FXML
    private void AddButtonOnAction(ActionEvent actionEvent) {
        Restaurant res = new Load().getRestaurantFromFile();

        ObservableList<String> newOrderList;
        newOrderList = display.getSelectionModel().getSelectedItems();
        for (String orderItem : newOrderList){
            orderList.add(orderItem);
        }
        String priceString = DECIMAL_FORMATTER.format(res.menu.calculatePriceOfItemNames(orderList));
        priceDisplay.setText("￡" + priceString);
        displayTwo.getItems().clear();
        displayTwo.setItems(FXCollections.observableArrayList(orderList));
        display.getSelectionModel().clearSelection();
        res.saveRestaurant();

    }



    }

