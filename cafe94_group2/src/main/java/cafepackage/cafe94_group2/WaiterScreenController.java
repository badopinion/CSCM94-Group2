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

/**
 * The Waiter screen Controller
 * @author Oliver Jackson
 *  @version 2
 */

public class WaiterScreenController {
    @FXML
    Button createOrderButton, outstandingOrdersButton, approveBookingsButton;

    /**
     * To show the order screen.
     * Takes user to new screen.
     * @param actionEvent Button click
     * @throws IOException Throws if input fails
     */
    @FXML
    private void createOrderbuttonOnAction(ActionEvent actionEvent) throws IOException {
        Stage menuScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MenuScreen.fxml"));
        menuScreen.setTitle("Menu Interface");
        menuScreen.setScene(new Scene(root, 730, 530));
        menuScreen.setX(600);
        menuScreen.setY(250);
        menuScreen.initModality(Modality.APPLICATION_MODAL);
        menuScreen.show();
    }

    /**
     * To show the outstanding orders.
     * Takes user to new screen.
     * @param actionEvent Button click
     * @throws IOException Throws if input fails
     */
    @FXML
    private void outstandingOrdersOnAction(ActionEvent actionEvent) throws IOException {
        Stage outstandingOrderScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("NonChefUnfulfilledOrderScreen.fxml"));
        outstandingOrderScreen.setTitle("Outstanding Orders Interface");
        outstandingOrderScreen.setScene(new Scene(root, 730, 530));
        outstandingOrderScreen.setX(600);
        outstandingOrderScreen.setY(250);
        outstandingOrderScreen.initModality(Modality.APPLICATION_MODAL);
        outstandingOrderScreen.show();
    }

    /**
     * To show approve booking screen.
     * Takes user to new screen.
     * @param actionEvent Button click
     * @throws IOException Throws if input fails
     */
    @FXML
    private void approveBookingsButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage outstandingOrderScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ApproveBookingsScreen.fxml"));
        outstandingOrderScreen.setTitle("Approve Bookings Interface");
        outstandingOrderScreen.setScene(new Scene(root, 730, 530));
        outstandingOrderScreen.setX(600);
        outstandingOrderScreen.setY(250);
        outstandingOrderScreen.initModality(Modality.APPLICATION_MODAL);
        outstandingOrderScreen.show();
    }
}