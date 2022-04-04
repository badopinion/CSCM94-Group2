//OJ is adding a test comment
package cafepackage.cafe94_group2;

import backend.*;

import backend.Menu;
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

public class MenuScreenController implements Initializable {
    @FXML
    private ListView<String> display, displayTwo;
    @FXML
    private TextField priceDisplay;
    @FXML
    private ComboBox<String> chooseMenu, chooseType;
    private ArrayList<String> orderList = new ArrayList<String>();
//    private MenuItem Order;
    @FXML
    Button addButton;
    @FXML
    Button removeButton;
    @FXML
    Button nextButton;

    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("###,##0.00");

    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> chooseMenuList = FXCollections.observableArrayList("Food", "Drinks",
                "Coffee");
        chooseMenu.setItems(chooseMenuList);
        chooseMenu.getSelectionModel().select(0);

        ObservableList<String> typeList = FXCollections.observableArrayList("Eat-in", "Takeaway", "Delivery");
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
            for (MenuItem menuItem : menuItems) {
                menuItemNames.add(menuItem.getName());
            }
            ObservableList<String> orderList = FXCollections.observableArrayList(menuItemNames);
            display.getItems().clear();
            display.setItems(orderList);

        } else if (selectedItem.equals("Drinks")) {
            ArrayList<MenuItem> menuItems = new ArrayList<>(res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.DRINK));
            ArrayList<String> menuItemNames = new ArrayList<>();
            for (MenuItem menuItem : menuItems) {
                menuItemNames.add(menuItem.getName());
            }
            ObservableList<String> orderList = FXCollections.observableArrayList(menuItemNames);
            display.getItems().clear();
            display.setItems(orderList);
        } else if (selectedItem.equals("Coffee")) {
            ArrayList<MenuItem> menuItems = new ArrayList<>(res.menu.returnMenuItemsByType(res.menu.getCurrentItems(), MenuItemType.COFFEE));
            ArrayList<String> menuItemNames = new ArrayList<>();
            for (MenuItem menuItem : menuItems) {
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
        for (String orderItem : newOrderList) {
            orderList.add(orderItem);
        }
        String priceString = DECIMAL_FORMATTER.format(res.menu.calculatePriceOfItemNames(orderList));
        priceDisplay.setText("￡" + priceString);
        displayTwo.getItems().clear();
        displayTwo.setItems(FXCollections.observableArrayList(orderList));
        display.getSelectionModel().clearSelection();
        res.saveRestaurant();

    }

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

    @FXML
    private void NextButtonAction(ActionEvent actionEvent) throws IOException {
        Restaurant res = new Load().getRestaurantFromFile();
        if (orderList.size() == 0){
//            ArrayList<String> errorList = new ArrayList<>();
//            String noOrderString = "You must select some items to order!";
//            errorList.add(noOrderString);
//            ObservableList<String> errorStringList = FXCollections.observableArrayList(errorList);
//            displayTwo.setItems(errorStringList);
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
