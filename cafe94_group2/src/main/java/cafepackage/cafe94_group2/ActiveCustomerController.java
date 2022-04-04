package com.example.cw2;
//package cafepackage.cafe94_group2;
//import backend.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 The Most Active Customer screen Controller
 @author Adam & Sam
 @version3
 */

public class ActiveCustomerController extends Application {

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
