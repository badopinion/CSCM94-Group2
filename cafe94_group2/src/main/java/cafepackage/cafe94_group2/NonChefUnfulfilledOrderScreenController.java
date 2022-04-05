package cafepackage.cafe94_group2;

import backend.Load;
import backend.Order;
import backend.OrderString;
import backend.Restaurant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 The Unfulfilled order screen Controller for non chefs
 @author Oliver Jackson
 @version2
 */

public class NonChefUnfulfilledOrderScreenController implements Initializable {


    @FXML
    private TableView<OrderString> orderTbv;
    @FXML
    TableColumn<OrderString, String> items = new TableColumn<>("items");
    @FXML
    TableColumn<OrderString, String> table = new TableColumn<>("table");
    @FXML
    TableColumn<OrderString, String> orderType = new TableColumn<>("orderType");
    @FXML
    TableColumn<OrderString, String> customer = new TableColumn<>("customer");
    @FXML
    TableColumn<OrderString, String> orderTime = new TableColumn<>("orderTime");


    private ObservableList<OrderString> orderStringList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Restaurant res = new Load().getRestaurantFromFile();
        orderStringList = FXCollections.observableArrayList(res.convertOrdersToStringArray(res.unfulfilledOrders()));
        customer.setCellValueFactory(new PropertyValueFactory<OrderString, String>("customerUserName"));
        items.setCellValueFactory(new PropertyValueFactory<OrderString, String>("orderedString"));
        table.setCellValueFactory(new PropertyValueFactory<OrderString, String>("tableNumber"));
        orderType.setCellValueFactory(new PropertyValueFactory<OrderString, String>("orderType"));
        orderTime.setCellValueFactory(new PropertyValueFactory<OrderString, String>("orderDateTime"));
        orderTbv.setItems(orderStringList);
    }


}
