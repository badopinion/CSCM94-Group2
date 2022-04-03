package cafepackage.cafe94_group2;

import backend.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
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
 * FXML Controller class
 * @author Oliver Jackson
 */

public class ProfileScreenController implements Initializable {

    @FXML
    private TableView<Order> tableView;
//    @FXML
//    private TableColumn<MenuItem, String> itemNameColumn;
//    @FXML
//    private TableColumn<MenuItem, Float> priceColumn;
    @FXML
    private TableColumn<Order, LocalDateTime> dateColumn;


    public void showCustomerOrderHistory(){
        Restaurant res = new Load().getRestaurantFromFile();



        res.saveRestaurant();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //set up columns in table
//        itemNameColumn.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("name"));
//        priceColumn.setCellValueFactory(new PropertyValueFactory<MenuItem, Float>("price"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Order, LocalDateTime>("orderDateTime"));

        if (getOrders() != null) {
            System.out.println("get orders not null");
            tableView.setItems(getOrders());
        }

    }

    /**
     * this method will return an ObservableList of order Objects. OJ
     */
    public ObservableList<Order> getOrders() {
        Restaurant res = new Load().getRestaurantFromFile();
        User u = res.login.getLoggedIn();
        System.out.println(res.login.checkUserType(u));
        System.out.println(res.login.checkLoggedInUserType());
        System.out.println("order counter = " + res.getOrderCounter());
        if(res.getOrderCounter() == 0){
            res.menu.populateOrderHistory();
        }
        if (u instanceof Customer){
            Customer c = (Customer) u;
            System.out.println(c);
            return FXCollections.observableList(res.returnCustomerOrderHistory(c));
        }
        System.out.println("get orders null");
        return null;
    }


}
