package cafepackage.cafe94_group2;

import backend.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerScreenController {
    @FXML
    private Button addStaffButton;
    @FXML
    private Button outstandingOrderButton2;
    @FXML
    private Button reportGeneratorButton3;
    @FXML
    private void addStaffOnAction(ActionEvent actionEvent) throws IOException {
        Stage addStaffScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ManagerAddScreen.fxml"));
        addStaffScreen.setTitle("Add Staff Interface");
        addStaffScreen.setScene(new Scene(root, 730, 530));
        addStaffScreen.setX(600);
        addStaffScreen.setY(250);
        addStaffScreen.initModality(Modality.APPLICATION_MODAL);
        addStaffScreen.show();
    }
    @FXML
    private void outstandingOrderOnAction2(ActionEvent actionEvent) throws IOException {
        Stage outstandingOrderScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("UnfulfilledOrderScreen.fxml"));
        outstandingOrderScreen.setTitle("Outstanding Order Interface");
        outstandingOrderScreen.setScene(new Scene(root, 730, 530));
        outstandingOrderScreen.setX(600);
        outstandingOrderScreen.setY(250);
        outstandingOrderScreen.initModality(Modality.APPLICATION_MODAL);
        outstandingOrderScreen.show();
    }
      @FXML
    private void reportGeneratorAction3(ActionEvent actionEvent) throws IOException {
        Stage reportGeneratorScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ReportController.fxml"));
        outstandingOrderScreen.setTitle("Report Generator Interface");
        outstandingOrderScreen.setScene(new Scene(root, 730, 530));
        outstandingOrderScreen.setX(600);
        outstandingOrderScreen.setY(250);
        outstandingOrderScreen.initModality(Modality.APPLICATION_MODAL);
        outstandingOrderScreen.show();
    }
}
