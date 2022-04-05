package cafepackage.cafe94_group2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 The Most Active Customer screen Controller
 @author Adam Schmidt , Sam Raine
 @version3
 */

public class ActiveCustomerController extends Application {

    @FXML
    private Button closeButton;
    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
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
