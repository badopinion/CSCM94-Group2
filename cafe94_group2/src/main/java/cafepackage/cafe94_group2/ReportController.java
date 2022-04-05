package cafepackage.cafe94_group2;


import backend.MenuItem;
import backend.Order;
import backend.Restaurant;
import backend.Staff;
import backend.GenerateReport;
import backend.FoodFeq;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * The report controller
 * @author Adam Schmidt , Samuel Raine
 * @version 1
 */
public class ReportController  implements Initializable {
    @FXML
    private Text customer;
    @FXML
    private Text hoursWorked;
    @FXML
    private Text busiestHours;
    @FXML
    private ListView item;
    @FXML
    private ListView feq;
    @FXML
    private Button closeButton;

    /**
     * Initial the screen
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Restaurant res = new Restaurant();
        //ArrayList<Staff> staffList = res.getAllStuff()
        ArrayList<Staff> staffList = res.login.getStaffList();
        System.out.println(staffList.size());
        ArrayList<Order> order = res.getAllOrders();
        ArrayList<MenuItem> menuItems = res.menu.getAllItems();
        GenerateReport gp = new GenerateReport();
        System.out.println(order.size());
        customer.setText(gp.mostActiveCustomer(order));
        ArrayList<FoodFeq> foodFeqs = new ArrayList<>();
        foodFeqs = gp.getPopularDish(res.getAllOrders());
        System.out.println(foodFeqs.size());
        for (FoodFeq feqFood : foodFeqs) {
            item.getItems().add(feqFood.getFoodName());
            feq.getItems().add(feqFood.getFeq());
        }
        feq.getItems().add("1");
        hoursWorked.setText(gp.whichStaffHasWorkedTheMostReport(staffList));
        busiestHours.setText(gp.mostActivePeriodReport());
    }

    /**
     * Button press to close the screen
     */

    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}




