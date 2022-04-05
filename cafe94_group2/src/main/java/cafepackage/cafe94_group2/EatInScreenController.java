package cafepackage.cafe94_group2;

import backend.Restaurant;
import backend.Load;
import backend.Table;
import backend.Customer;
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
 * The Menu screen Controller
 * @author Oliver Jackson
 * @version 2
 */

public class EatInScreenController implements Initializable {
    @FXML
    private ComboBox<String> tableSelection;
    @FXML
    private TextField orderPrice;
    @FXML
    private TextField orderNotes;
    @FXML
    private Button placeOrderButton;

    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("###,##0.00");

    private ObservableList<String> table =
            FXCollections.observableArrayList(
                    "Table 1",
                    "Table 2",
                    "Table 3",
                    "Table 4",
                    "Table 5",
                    "Table 6",
                    "Table 7",
                    "Table 8",
                    "Table 9",
                    "Table 10",
                    "Table 11"
            );

    /**
     * Initializes the screen, loading the restaurant, setting up the table drop down box,
     * And setting the price box to equal the order price.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Restaurant res = new Load().getRestaurantFromFile();
        tableSelection.setItems(table);
        String priceString = DECIMAL_FORMATTER.format(res.menu.calculatePriceOfItemNames(res.getTemporaryOrderStringList()));
        orderPrice.setText("￡" + priceString);
        orderNotes.setText("");

    }


    /**
     * Provides the functionality for the place order button
     * If the customer is ordering it uses the customer's info for the order
     * If the waiter is ordering the customer is set to eatincustomer
     * @param actionEvent clicking the placeorder button
     */
    @FXML
    private void placeOrderButtonOnAction(ActionEvent actionEvent) {
        boolean isMyComboBoxEmpty = tableSelection.getSelectionModel().isEmpty();
        if (isMyComboBoxEmpty) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("You must select a table number!");
            errorAlert.showAndWait();
        } else {
            Restaurant res = new Load().getRestaurantFromFile();
            int tableNumber = returnTableNumber(tableSelection.getSelectionModel().getSelectedItem());
            Table table = res.getTable(tableNumber);
            String orderNotesString = orderNotes.getText();
            User user = res.login.getLoggedIn();
            if (user instanceof Customer) {
                Customer customer = (Customer) user;
                res.menu.placeEatInOrder(res, customer, orderNotesString, table, res.getTemporaryOrderList());
                orderCompleteAlert();
            } else if (user instanceof Waiter) {
                Customer customer = res.login.getCustomerFromUsername("eatincustomer");
                res.menu.placeEatInOrder(res, customer, orderNotesString, table, res.getTemporaryOrderList());
                orderCompleteAlert();
            } else {
                System.out.println("Only customers and waiters may order here");
            }
            res.saveRestaurant();
        }
    }

    /**
     * Takes a string and searches for a corresponding table number
     * @param tableString
     * @return an int corresponding to a table number
     */
    private int returnTableNumber(String tableString) {
        int tableNum;
        switch (tableString) {
            case "Table 1":
                tableNum = 1;
                break;
            case "Table 2":
                tableNum = 2;
                break;
            case "Table 3":
                tableNum = 3;
                break;
            case "Table 4":
                tableNum = 4;
                break;
            case "Table 5":
                tableNum = 5;
                break;
            case "Table 6":
                tableNum = 6;
                break;
            case "Table 7":
                tableNum = 7;
                break;
            case "Table 8":
                tableNum = 8;
                break;
            case "Table 9":
                tableNum = 9;
                break;
            case "Table 10":
                tableNum = 10;
                break;
            case "Table 11":
                tableNum = 11;
                break;
            case "Table 12":
                tableNum = 12;
                break;
            default:
                throw new IllegalArgumentException("Invalid tableNumberString: " + tableString);
        }
        return tableNum;
    }

    /**
     * If the order is completed an alert is displayed
     */
    private void orderCompleteAlert() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("Eat-in order complete");
        infoAlert.show();
    }
}
