package cafepackage.cafe94_group2;

import backend.*;


import backend.MenuItem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Double.sum;

/**
 The Menu screen Controller
 @author Hristiana Davidova, Yingfan Zhang, Oliver Jackson
 @version4
 */

public class MenuScreenController implements Initializable {
    @FXML
    private ListView<String> display, displayTwo;
    @FXML
    private TextField priceDisplay;
    @FXML
    private ComboBox<String> chooseMenu, chooseType;
    private ArrayList<String> orderList = new ArrayList<String>();
    private final String specialString = " (Today's special)";
    //    private MenuItem Order;
    @FXML
    Button addButton;
    @FXML
    Button removeButton;
    @FXML
    Button nextButton;


    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("###,##0.00");

    /**
     Initializes the screen, displaying food items available to order, setting up the two comboboxes (dropdown)
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayFood();
        ObservableList<String> chooseMenuList = FXCollections.observableArrayList("Food", "Drinks",
                "Coffee");
        chooseMenu.setItems(chooseMenuList);
        chooseMenu.getSelectionModel().select(0);

        ObservableList<String> typeList = FXCollections.observableArrayList("Eat-in", "Takeaway", "Delivery");
        chooseType.setItems(typeList);
        chooseType.getSelectionModel().select(0);
    }

    /**
     * enables user to choose between food, drink, and coffee options
     * if user selects a new option different item options appear
     * @param actionEvent clicking the dropdown box
     */
    @FXML
    private void processChooseMenu(ActionEvent actionEvent) {
        Restaurant res = new Load().getRestaurantFromFile();
        Object selectedItem = chooseMenu.getSelectionModel().getSelectedItem();
        if (selectedItem.equals("Food")) {
            displayFood();
        } else if (selectedItem.equals("Drinks")) {
            displayDrink();
        } else if (selectedItem.equals("Coffee")) {
            displayCoffee();
        }
    }

    /**
     * displays food menu items in display box
     * if menu item is special displays (Today's Special)
     */
    private void displayFood(){
        Restaurant res = new Load().getRestaurantFromFile();
        ArrayList<MenuItem> menuItems = new ArrayList<>(res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.FOOD));
        ArrayList<String> menuItemNames = new ArrayList<>();
        for (MenuItem menuItem : menuItems) {
            if (menuItem.isSpecial()){
                menuItemNames.add(menuItem.getName() + specialString);
            } else {
                menuItemNames.add(menuItem.getName());
            }
        }
        ObservableList<String> orderList = FXCollections.observableArrayList(menuItemNames);
        display.getItems().clear();
        display.setItems(orderList);
    }

    /**
     * displays drink menu items in display box
     */
    private void displayDrink(){
        Restaurant res = new Load().getRestaurantFromFile();
        ArrayList<MenuItem> menuItems = new ArrayList<>(res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.DRINK));
        ArrayList<String> menuItemNames = new ArrayList<>();
        for (MenuItem menuItem : menuItems) {
            menuItemNames.add(menuItem.getName());
        }
        ObservableList<String> orderList = FXCollections.observableArrayList(menuItemNames);
        display.getItems().clear();
        display.setItems(orderList);
    }

    /**
     * displays coffee menuItems in display box
     */
    private void displayCoffee(){
        Restaurant res = new Load().getRestaurantFromFile();
        ArrayList<MenuItem> menuItems = new ArrayList<>(res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.COFFEE));
        ArrayList<String> menuItemNames = new ArrayList<>();
        for (MenuItem menuItem : menuItems) {
            menuItemNames.add(menuItem.getName());
        }
        ObservableList<String> orderList = FXCollections.observableArrayList(menuItemNames);
        display.getItems().clear();
        display.setItems(orderList);
    }

    /**
     * User can select an option from the display box and if they click the add button
     * the item is added to an arrayList called orderList, held by the menuScreenController.
     * displayTwo is then updated to reflect the change in orderList
     * @param actionEvent clicking the add button
     */
    @FXML
    private void AddButtonOnAction(ActionEvent actionEvent) {
        Restaurant res = new Load().getRestaurantFromFile();
        ObservableList<String> newOrderList;
        newOrderList = display.getSelectionModel().getSelectedItems();
        for (String orderItem : newOrderList) {
            if (orderItem.contains(specialString)){
                String tempString = orderItem.replace(specialString, "");
                orderList.add(tempString);
            } else {
                orderList.add(orderItem);
            }
        }
        String priceString = DECIMAL_FORMATTER.format(res.menu.calculatePriceOfItemNames(orderList));
        priceDisplay.setText("￡" + priceString);
        displayTwo.getItems().clear();
        displayTwo.setItems(FXCollections.observableArrayList(orderList));
        display.getSelectionModel().clearSelection();
        res.saveRestaurant();

    }

    /**
     * User can select an option from the display box and if they click the remove button
     * the item is removed from the arrayList orderList, held by the menuScreenController.
     * displayTwo is then updated to reflect the change in orderList
     * @param actionEvent clicking the remove button
     */
    @FXML
    private void RemoveButtonOnAction(ActionEvent actionEvent) {
        Restaurant res = new Load().getRestaurantFromFile();

        ObservableList<String> removeOrderList;

        removeOrderList = displayTwo.getSelectionModel().getSelectedItems();
        ArrayList<String> deleteCandidates = new ArrayList<>();
        for (String orderItem : orderList) {
            if (removeOrderList.contains(orderItem)) {
                deleteCandidates.add(orderItem);
            }
        }
        for (String deleteCandidate : deleteCandidates) {
            orderList.remove(deleteCandidate);
        }

        String priceString = DECIMAL_FORMATTER.format(res.menu.calculatePriceOfItemNames(orderList));
        priceDisplay.setText("￡" + priceString);
        displayTwo.getItems().clear();
        displayTwo.setItems(FXCollections.observableArrayList(orderList));
        display.getSelectionModel().clearSelection();
        res.saveRestaurant();

    }

    /**
     * Checks to see if customer has made a selection, if not asks them to do so.
     * If a selection has been made, orderList is sent to restaurant object.
     * Res is saved. Enabling next screen to access up to date orderList.
     * Depending on user selection nextButton Action then eatin, takeaway, or order screen.
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    private void NextButtonAction(ActionEvent actionEvent) throws IOException {
        Restaurant res = new Load().getRestaurantFromFile();
        if (orderList.size() == 0){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Not hungry? You must select some items to order!");
            errorAlert.showAndWait();
        } else {
            res.setTemporaryOrderStringList(orderList);
            res.setTemporaryOrderList(res.convStringListToMIList(res.getTemporaryOrderStringList(), res.menu));
            res.saveRestaurant();
            if (chooseType.getSelectionModel().getSelectedItem().equals("Eat-in")){
                loadEatInScreen(res);
            } else if (chooseType.getSelectionModel().getSelectedItem().equals("Takeaway")){
                loadTakeawayScreen(res);
            }  else if (chooseType.getSelectionModel().getSelectedItem().equals("Delivery")){
                loadDeliveryScreen(res);
            }
        }
    }

    /**
     * loads the eat in screen
     * @param res the restaurant object
     * @throws IOException
     */
    @FXML
    private void loadEatInScreen(Restaurant res) throws IOException{
        Stage eatInScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("EatInScreen.fxml"));
        eatInScreen.setTitle("Eat In Interface");
        eatInScreen.setScene(new Scene(root, 730, 530));
        eatInScreen.setX(600);
        eatInScreen.setY(250);
        eatInScreen.initModality(Modality.APPLICATION_MODAL);
        eatInScreen.show();
    }

    /**
     * loads the takeaway screen
     * @param res the restaurant object
     * @throws IOException
     */
    @FXML
    private void loadTakeawayScreen(Restaurant res) throws IOException{
        Stage takeawayScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("TakeawayOrderScreen.fxml"));
        takeawayScreen.setTitle("Takeaway Interface");
        takeawayScreen.setScene(new Scene(root, 730, 530));
        takeawayScreen.setX(600);
        takeawayScreen.setY(250);
        takeawayScreen.initModality(Modality.APPLICATION_MODAL);
        takeawayScreen.show();
    }

    /**
     * loads the delivery screen
     * @param res the restaurant object
     * @throws IOException
     */
    @FXML
    private void loadDeliveryScreen(Restaurant res) throws IOException{
        Stage deliveryScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("DeliveryOrderScreen.fxml"));
        deliveryScreen.setTitle("Delivery Interface");
        deliveryScreen.setScene(new Scene(root, 730, 530));
        deliveryScreen.setX(600);
        deliveryScreen.setY(250);
        deliveryScreen.initModality(Modality.APPLICATION_MODAL);
        deliveryScreen.show();
    }

}