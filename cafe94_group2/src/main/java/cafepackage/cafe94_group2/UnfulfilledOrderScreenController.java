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
 @version1
 */

public class UnfulfilledOrderScreenController implements Initializable {

//    @FXML
//    TableColumn<Order, Customer> customer = new TableColumn<>("customer");



    @FXML
    private TableView<Order> orderTbv;
    //    @FXML
//    TableColumn<Order, ArrayList<MenuItem>> items = new TableColumn<>("Items");
//    @FXML
//    TableColumn<Order, Table> table = new TableColumn<>("Table");
//    @FXML
//    TableColumn<Order, String> orderType = new TableColumn<>("Order Type");
    @FXML
    TableColumn<Order, String> customer = new TableColumn<>("customer");
//    @FXML
//    TableColumn<Order, String> customer = new TableColumn<>("Customer");
//    @FXML
//    TableColumn<Order, LocalDateTime> orderTime = new TableColumn<>("Order Time");

    private ObservableList<Order> orderList;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Restaurant res = new Load().getRestaurantFromFile();

//        customer.setCellValueFactory(new PropertyValueFactory<Order, Customer>("customer"));




//        items.setCellValueFactory(new PropertyValueFactory<Order, ArrayList<MenuItem>>("orderedMenuItems"));
        customer.setCellValueFactory(new PropertyValueFactory<Order, String>("customer"));



//        orderTime.setCellValueFactory(new PropertyValueFactory<LocalDateTime, String>("orderDateTime"));
        System.out.println("mid initialising");
        orderList = FXCollections.observableArrayList(res.unfulfilledOrders());
        System.out.println("size = " + orderList.size());

        orderTbv.setItems(orderList);


    }


}
