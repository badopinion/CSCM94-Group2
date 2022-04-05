package cafepackage.cafe94_group2;

import backend.*;

import backend.Load;
import backend.MenuItem;
import backend.Order;
import backend.Restaurant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 The Unfulfilled order screen Controller
 @author Oliver Jackson
 @version2
 */

public class UnfulfilledOrderScreenController implements Initializable {


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

        System.out.println("mid initialising");
        System.out.println("size = " + orderStringList.size());

        orderTbv.setItems(orderStringList);


    }


    // an old version that was sort of working
//    @FXML
//    private TableView<Order> orderTbv;
//    @FXML
//    TableColumn<Order, String> customer = new TableColumn<>("customer");
//    private ObservableList<Order> orderList;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        Restaurant res = new Load().getRestaurantFromFile();
//        customer.setCellValueFactory(new PropertyValueFactory<Order, String>("customer"));
//        System.out.println("mid initialising");
//        orderList = FXCollections.observableArrayList(res.unfulfilledOrders());
//        System.out.println("size = " + orderList.size());
//
//        orderTbv.setItems(orderList);
//
//
//    }



}
