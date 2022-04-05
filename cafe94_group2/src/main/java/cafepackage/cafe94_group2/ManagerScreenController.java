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

import javafx.stage.StageStyle;

import java.io.IOException;



/**
 * This is Manager screen Controller
 * @author Yingfan Zhang
 * @version 1
 */


public class ManagerScreenController {
    @FXML
    private Button addStaffButton;

    @FXML
    private Button reportGeneratorButton3;
    @FXML
    private Button outstandingOrderButton;

    /**
     * To show the staff add orders.
     * Takes user to new screen.
     * @param actionEvent Button click
     * @throws IOException Throws if input fails
     */

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


    /**
     * To show the outstanding orders.
     * Takes user to new screen.
     * @param actionEvent Button click
     * @throws IOException Throws if input fails
     */
    @FXML
    private void outstandingOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage outstandingOrderScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("NonChefUnfulfilledOrderScreen.fxml"));
        outstandingOrderScreen.setTitle("Outstanding Order Interface");
        outstandingOrderScreen.setScene(new Scene(root, 730, 530));
        outstandingOrderScreen.setX(600);
        outstandingOrderScreen.setY(250);
        outstandingOrderScreen.initModality(Modality.APPLICATION_MODAL);
        outstandingOrderScreen.show();
    }

      @FXML
    private void reportGeneratorAction3(ActionEvent actionEvent) throws IOException {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("report.fxml"));
          Parent root1 = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.initModality(Modality.APPLICATION_MODAL);
          stage.initStyle(StageStyle.UNDECORATED);
          stage.setTitle("ABC");
          stage.setScene(new Scene(root1));
          stage.show();
    }

}
