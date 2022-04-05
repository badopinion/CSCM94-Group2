package cafepackage.cafe94_group2;

import backend.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Class for Report Generation
 * @author Adam & Sam
 * @version 4
 */

public class ReportController  implements Initializable {
    @FXML
    Text CUSTOMER;
    @FXML
    Text HOURS_WORKED;
    @FXML
    Text BUSIEST_HOURS;
    @FXML
    ListView item;
    @FXML
    ListView feq;
    @FXML
    Button closeButton;
    
    
    /**
     * Initialize method called when fxml file is loaded
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Restaurant res = new Restaurant();
        ArrayList<Staff> staffList = res.login.getStaffList();
        System.out.println(staffList.size());
        
        
        /**
         * Displays information on the most Active customer based on order histroy
         */
        ArrayList<Order> order = res.getAllOrders();
        ArrayList<MenuItem> menuItems = res.menu.getAllItems();
        GenerateReport gp = new GenerateReport();
        System.out.println(order.size());
        CUSTOMER.setText(gp.mostActiveCustomer(order));
        
        
        /**
         * Displays information on the most poplar menu item
         */
        ArrayList<FoodFeq> foodFeqs = new ArrayList<>();
        foodFeqs = gp.getPopularDish(res.getAllOrders());
        System.out.println(foodFeqs.size());
        for (FoodFeq feqFood : foodFeqs) {
            item.getItems().add(feqFood.getFoodName());
            feq.getItems().add(feqFood.getFeq());
        }
        feq.getItems().add("1");
        
        
        /**
         * Displays which member of staff has worked the most
         */
        HOURS_WORKED.setText(gp.whichStaffHasWorkedTheMostReport(staffList));
        
        
        /**
         * Displays information on the busiest periods
         */
        BUSIEST_HOURS.setText(gp.mostActivePeriodReport());
    }

    
    /**
     * Button press closes the Report Generation scene
     * @param actionEvent Button click
     */
    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}




