package cafepackage.cafe94_group2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This is Driver screen Controller
 * @author Yingfan Zhang
 * @version 1
 */

public class DriverScreenController {
    @FXML
    private Button outstandingOrderButton;

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
}
