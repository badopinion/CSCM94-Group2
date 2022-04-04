package com.example.cw2;
//import backend.*;

//fxcontroller="cafepackage.cafe94_group2.WaiterScreenController"

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

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
        checkItem();
    }

    private void checkItem() throws IOException {
        Main m = new Main();

    }


    // Generate Busiest Period report
    public void generateBusy(ActionEvent event) throws IOException {
        checkBusy();
    }

    private void checkBusy() throws IOException {
        Main m = new Main();

    }


    // Generate Most Active Customer report
    public void generateCustomer(ActionEvent event) throws IOException {
        checkCustomer();
    }

    private void checkCustomer() throws IOException {
        Main m = new Main();

    }


    // Generate Most staff hours worked report
    public void generateWorked(ActionEvent event) throws IOException {
        checkWorked();
    }

    private void checkWorked() throws IOException {
        Main m = new Main();

    }

}
