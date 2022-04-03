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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MenuScreenController implements Initializable {
    @FXML
    private ListView<String> display, displayTwo;
    @FXML
    private TextField priceDisplay;
    @FXML
    private ComboBox <String> chooseMenu, chooseType;
    private ArrayList<MenuItem> OrderList = new ArrayList<MenuItem>();
    private MenuItem Order;
    @FXML
    Button add;
    @FXML
    Button remove;

    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("###,##0.00");
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> chooseMenuList = FXCollections.observableArrayList("Food", "Drinks",
                "Coffee");
        chooseMenu.setItems(chooseMenuList);
        chooseMenu.getSelectionModel().select(0);
        ObservableList<String> foodList = FXCollections.observableArrayList("cheese burger", "pizza",
                "pasta");
        display.getItems().clear();
        display.setItems(foodList);

        ObservableList<String> typeList = FXCollections.observableArrayList("Eat-in", "Take away", "Delivery");
        chooseType.setItems(typeList);
        chooseType.getSelectionModel().select(0);
    }



    }

