package cafepackage.cafe94_group2;

import backend.GenerateReport;
import backend.Login;
import backend.Order;
import backend.Restaurant;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReportController  implements Initializable {
    @FXML
    Text CUSTOMER;
    @FXML
    Text HOURS_WORKED;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Restaurant res = new Restaurant();
        ArrayList<Order> order = res.getAllOrders();
        GenerateReport gp = new GenerateReport();
        System.out.println(gp.mostActiveCustomer(order));
        CUSTOMER.setText(gp.mostActiveCustomer(order));
        //HOURS_WORKED.setText(gp.whichStaffHasWorkedTheMostReport());
    };


}

