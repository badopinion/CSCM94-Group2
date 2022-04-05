package cafepackage.cafe94_group2;


import backend.Customer;
import backend.Load;
import backend.Restaurant;
import backend.User;
import backend.Waiter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * The Takeaway screen Controller
 * @author Oliver Jackson
 * @version 2
 */

public class TakeawayOrderScreenController implements Initializable {
    @FXML
    private ComboBox<String> pickUpTimeSelection;
    @FXML
    private TextField orderNotes;
    @FXML
    private TextField orderPrice;
    @FXML
    private Button placeOrderButton;

    private ObservableList<String> timeList = FXCollections.observableArrayList(
            "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
            "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00",
            "20:30", "21:00");


    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("###,##0.00");

/**
 * Initializes the screen, loading the restaurant, setting up the time drop down box,
 * And setting the price box to equal the order price
 */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Restaurant res = new Load().getRestaurantFromFile();
        pickUpTimeSelection.setItems(timeList);
        orderNotes.setText("");
        String priceString = DECIMAL_FORMATTER.format(res.menu.calculatePriceOfItemNames(res.getTemporaryOrderStringList()));
        orderPrice.setText("£" + priceString);

    }

    /**
     * Provides the functionality for the place order button
     * If the customer is ordering it uses the customer's info for the order
     * If the waiter is ordering the customer is set to takeawaycustomer
     * (enabling a customer to order over the phone)
     * @param actionEvent clicking the place orderbutton
     */
    @FXML
    private void placeOrderButtonOnAction(ActionEvent actionEvent) {
        boolean isMyComboBoxEmpty = pickUpTimeSelection.getSelectionModel().isEmpty();
        if (isMyComboBoxEmpty) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("You must select a pick up time!");
            errorAlert.showAndWait();
        } else {
            Restaurant res = new Load().getRestaurantFromFile();
            String pickupTime = pickUpTimeSelection.getSelectionModel().getSelectedItem();
            String orderNotesString = orderNotes.getText();
            User user = res.login.getLoggedIn();
            if (user instanceof Customer) {
                Customer customer = (Customer) user;
                res.menu.placeTakeawayOrder(res, customer, orderNotesString, pickupTime, res.getTemporaryOrderList());
                orderCompleteAlert();
            } else if (user instanceof Waiter) {
                Customer customer = res.login.getCustomerFromUsername("takeawaycustomer");
                res.menu.placeTakeawayOrder(res, customer, orderNotesString, pickupTime, res.getTemporaryOrderList());
                orderCompleteAlert();
            } else {
                System.out.println("Only customers and waiters may order here");
            }
            res.saveRestaurant();
        }
    }

    /**
     * If the order is completed an alert is displayed
     */
    private void orderCompleteAlert() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("Takeaway order complete");
        infoAlert.show();
    }
}

