package com.example.cw2;
//package cafepackage.cafe94_group2;
//import backend.*;
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
 * The Report screen Controller
 * @author Adam Schmidt , Samuel Raine
 * @version 3
 */

public class ReportsScreenController {

    public ReportsScreenController() {
    }

    @FXML
    private Button itemButton;
    @FXML
    private Button busyButton;
    @FXML
    private Button customerButton;
    @FXML
    private Button workButton;


    // Generate Most Popular Item report
    public void generateItem(ActionEvent event) throws IOException {
        Stage popularScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("popularItem.fxml"));
        popularScreen.setTitle("Popular Item Report");
        popularScreen.setScene(new Scene(root, 650, 400));
        popularScreen.initModality(Modality.APPLICATION_MODAL);
        popularScreen.show();
    }

    // Generate Busiest Period report
    public void generateBusy(ActionEvent event) throws IOException {
        Stage busySchedule = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("busySchedule.fxml"));
        busySchedule.setTitle("Busiest Period Report");
        busySchedule.setScene(new Scene(root, 650, 400));
        busySchedule.initModality(Modality.APPLICATION_MODAL);
        busySchedule.show();
    }

    // Generate Most Active Customer report
    public void generateCustomer(ActionEvent event) throws IOException {
        Stage activeCustomer = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("activeCustomer.fxml"));
        activeCustomer.setTitle("Most Active Customer Report");
        activeCustomer.setScene(new Scene(root, 650, 400));
        activeCustomer.initModality(Modality.APPLICATION_MODAL);
        activeCustomer.show();
    }

    // Generate Most staff hours worked report
    public void generateSchedule(ActionEvent event) throws IOException {
        Stage mostWorked = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("mostWorked.fxml"));
        mostWorked.setTitle("Busiest Schedule Report");
        mostWorked.setScene(new Scene(root, 650, 400));
        mostWorked.initModality(Modality.APPLICATION_MODAL);
        mostWorked.show();
    }
}
