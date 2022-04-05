package cafepackage.cafe94_group2;

import backend.Load;
import backend.OrderString;
import backend.Restaurant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The Unfulfilled order screen Controller
 * @author Oliver Jackson
 * @version 2
 */


public class NonChefUnfulfilledOrderScreenController implements Initializable {


    @FXML
    private TableView<OrderString> orderTbv;
    @FXML
    private TableColumn<OrderString, String> items = new TableColumn<>("items");
    @FXML
    private TableColumn<OrderString, String> table = new TableColumn<>("table");
    @FXML
    private TableColumn<OrderString, String> orderType = new TableColumn<>("orderType");
    @FXML
    private TableColumn<OrderString, String> customer = new TableColumn<>("customer");
    @FXML
    private TableColumn<OrderString, String> orderTime = new TableColumn<>("orderTime");


    private ObservableList<OrderString> orderStringList;

    /**
     * Initial the screen.
     * @param url
     * @param rb
     */
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
