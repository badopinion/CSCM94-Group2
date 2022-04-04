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
//        if(res.getOrderCounter() == 0){
//            res.menu.populateOrderHistory();
//        }


        res.saveRestaurant();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //set up columns in table
//        itemNameColumn.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("name"));
//        priceColumn.setCellValueFactory(new PropertyValueFactory<MenuItem, Float>("price"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Order, LocalDateTime>("orderDateTime"));

        tableView.setItems(getOrders());
    }

    /**
     * this method will return an ObservableList of order Objects. OJ
     */
    public ObservableList<Order> getOrders() {
        Restaurant res = new Load().getRestaurantFromFile();
        User u = res.login.getLoggedIn();
        Customer c;
        if (u instanceof Customer){
            c = (Customer) u;

            return FXCollections.observableList(res.returnCustomerOrderHistory(c));
        }
        return null;
    }


}
