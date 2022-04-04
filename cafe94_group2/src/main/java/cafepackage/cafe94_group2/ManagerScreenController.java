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
    private Button unfulfilledOrderButton,addStuffButton,addHoursButton;


    public void UnfulfilledOrderOnAction(ActionEvent event) throws IOException {
        Stage unfulfilledScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("UnfulfilledOrderScreen.fxml"));
        unfulfilledScreen.setTitle("Unfulfilled Order Interface");
        unfulfilledScreen.setScene(new Scene(root, 730, 530));
        unfulfilledScreen.setX(600);
        unfulfilledScreen.setY(250);
        unfulfilledScreen.initModality(Modality.APPLICATION_MODAL);
        unfulfilledScreen.show();

    }
    public void AddStuffOnAction(ActionEvent event) throws IOException {
        Stage addStuffScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ManagerAddScreen.fxml"));
        addStuffScreen.setTitle("Add Stuff Interface");
        addStuffScreen.setScene(new Scene(root, 730, 530));
        addStuffScreen.setX(600);
        addStuffScreen.setY(250);
        addStuffScreen.initModality(Modality.APPLICATION_MODAL);
        addStuffScreen.show();

    }
    public void AddHoursOnAction(ActionEvent event) throws IOException {
        Stage addHoursScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ManagerAddHoursScreen.fxml"));
        addHoursScreen.setTitle("Add Hours Interface");
        addHoursScreen.setScene(new Scene(root, 730, 530));
        addHoursScreen.setX(600);
        addHoursScreen.setY(250);
        addHoursScreen.initModality(Modality.APPLICATION_MODAL);
        addHoursScreen.show();

    }

}
