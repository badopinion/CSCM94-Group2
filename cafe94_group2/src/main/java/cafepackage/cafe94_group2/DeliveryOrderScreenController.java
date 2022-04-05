package cafepackage.cafe94_group2;

import backend.Restaurant;
import backend.Load;
import backend.User;
import backend.Customer;
import backend.Waiter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * The Delivery screen Controller.
 * @author Oliver Jackson , Hristiana Davidova
 * @version 2
 */

public class DeliveryOrderScreenController implements Initializable {
    @FXML
    private TextField address;
    @FXML
    private TextField orderNotes;
    @FXML
    private TextField orderPrice;
    @FXML
    private Button placeOrderButton;

    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("###,##0.00");

    /**
     Initializes the screen, loading the restaurant, setting the price box to equal the order price
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Restaurant res = new Load().getRestaurantFromFile();
        address.setText("");
        orderNotes.setText("");
        String priceString = DECIMAL_FORMATTER.format(res.menu.calculatePriceOfItemNames(res.getTemporaryOrderStringList()));
        orderPrice.setText("£" + priceString);
    }

    /**
     * provides the functionality for the place order button
     * if the customer is ordering it uses the customer's info for the order
     * if the waiter is ordering the customer is set to deliverycustomer
     * (enabling a customer to order over the phone)
     * @param actionEvent clicking the place orderbutton
     */
    @FXML
    private void placeOrderButtonOnAction(ActionEvent actionEvent) {
        boolean isMyTextFieldEmpty = address.getText().isEmpty();
        if (isMyTextFieldEmpty) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("You must enter an address!");
            errorAlert.showAndWait();
        } else {
            Restaurant res = new Load().getRestaurantFromFile();
            String addressString = address.getText();
            String orderNotesString = orderNotes.getText();
            User user = res.login.getLoggedIn();
            if (user instanceof Customer) {
                Customer customer = (Customer) user;
                res.menu.placeDeliveryOrder(res, customer, orderNotesString, addressString, res.getTemporaryOrderList());
                orderCompleteAlert();
            } else if (user instanceof Waiter) {
                Customer customer = res.login.getCustomerFromUsername("takeawaycustomer");
                res.menu.placeDeliveryOrder(res, customer, orderNotesString, addressString, res.getTemporaryOrderList());
                orderCompleteAlert();
            } else {
                System.out.println("Only customers and waiters may order here");
            }
            res.saveRestaurant();
        }
    }

    /**
     * if the order is completed an alert is displayed
     */
    private void orderCompleteAlert() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("Takeaway order complete");
        infoAlert.show();
    }
}


