package cafepackage.cafe94_group2;

import backend.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 The Staff Schedule screen Controller
 @author Adam Schmidt , Samuel Raine
 @version3
 */

public class BusyScheduleController extends Application {

    @FXML
    public Button closeButton;
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    }
}
