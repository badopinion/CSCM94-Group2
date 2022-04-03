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


public class ChefScreenController {

    @FXML
    private Button addItemButton;
    public void AddItemOnAction(ActionEvent event) throws IOException {
        Stage chefAddScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ChefAddScreen.fxml"));
        chefAddScreen.setTitle("Chef Add Interface");
        chefAddScreen.setScene(new Scene(root, 730, 530));
        chefAddScreen.setX(600);
        chefAddScreen.setY(250);
        chefAddScreen.initModality(Modality.APPLICATION_MODAL);
        chefAddScreen.show();

    }
}
