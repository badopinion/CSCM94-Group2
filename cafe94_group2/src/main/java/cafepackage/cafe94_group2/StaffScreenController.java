package cafepackage.cafe94_group2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is Staff screen Controller
 * @author Yingfan Zhang , Hristiana Davidova
 * @version 1
 */
public class StaffScreenController {

    /**
     * @param event Button click
     * @throws IOException Throws if it fails
     */
    public void managerChooseOnAction(ActionEvent event) throws IOException {
        Stage managerScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
        managerScreen.setTitle("ManagerInterface");
        managerScreen.setScene(new Scene(root, 730, 530));
        managerScreen.setX(600);
        managerScreen.setY(250);
        managerScreen.initModality(Modality.APPLICATION_MODAL);
        managerScreen.show();

    }
    public void driverChooseOnAction(ActionEvent event) throws IOException {
        Stage driverScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("DriverScreen.fxml"));
        driverScreen.setTitle("DriverInterface");
        driverScreen.setScene(new Scene(root, 730, 530));
        driverScreen.setX(600);
        driverScreen.setY(250);
        driverScreen.initModality(Modality.APPLICATION_MODAL);
        driverScreen.show();

    }
    public void waiterChooseOnAction(ActionEvent event) throws IOException {
        Stage waiterScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("WaiterScreen.fxml"));
        waiterScreen.setTitle("WaiterInterface");
        waiterScreen.setScene(new Scene(root, 730, 530));
        waiterScreen.setX(600);
        waiterScreen.setY(250);
        waiterScreen.initModality(Modality.APPLICATION_MODAL);
        waiterScreen.show();

    }
    public void chefChooseOnAction(ActionEvent event) throws IOException {
        Stage chefScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ChefScreen.fxml"));
        chefScreen.setTitle("ChefInterface");
        chefScreen.setScene(new Scene(root, 730, 530));
        chefScreen.setX(600);
        chefScreen.setY(250);
        chefScreen.initModality(Modality.APPLICATION_MODAL);
        chefScreen.show();

    }
}
