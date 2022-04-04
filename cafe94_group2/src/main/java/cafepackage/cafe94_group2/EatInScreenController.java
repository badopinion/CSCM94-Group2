package cafepackage.cafe94_group2;

import backend.Load;
import backend.Restaurant;
import backend.Table;
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

public class EatInScreenController implements Initializable {
    @FXML
    ComboBox<String> tableSelection;
    @FXML
    private TextField orderPrice;
    @FXML
    private TextField orderNotes;
    @FXML
    private Button placeOrderButton;

    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("###,##0.00");

    ObservableList<String> table =
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
    final ComboBox comboBox = new ComboBox(table);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Restaurant res = new Load().getRestaurantFromFile();
        tableSelection.setItems(table);
        String priceString = DECIMAL_FORMATTER.format(res.menu.calculatePriceOfItemNames(res.getTemporaryOrderStringList()));
        orderPrice.setText("￡" + priceString);
        orderNotes.setText("");

    }

    @FXML
    private void PlaceOrderButtonOnAction(ActionEvent actionEvent) {
        boolean isMyComboBoxEmpty = tableSelection.getSelectionModel().isEmpty();
        if(isMyComboBoxEmpty){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("You must select a table number!");
            errorAlert.showAndWait();
        } else {
            Restaurant res = new Load().getRestaurantFromFile();
            int tableNumber = returnTableNumber(tableSelection.getSelectionModel().getSelectedItem());
            Table table = res.getTable(tableNumber);
            String orderNotesString = orderNotes.getText();
            res.menu.placeEatInOrder(res, res.login.getLoggedIn(), orderNotesString, table, );
        }
    }


    private int returnTableNumber(String tableString){
        int tableNum;
        switch (tableString){
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

}