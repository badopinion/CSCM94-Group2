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
    private Button unfulfilledOrderButton;

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
}
