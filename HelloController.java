package com.example.reportlst;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class HelloController implements Initializable {

    @FXML
    private Label myLabel;

    @FXML
    private ChoiceBox<String> myChoiceBox;

    private String[] choice = {"Most Valued Customer","Busiest Period",
            "Most Hours Worked", "Most Popular Item"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        myChoiceBox.getItems().addAll(choice);
        myChoiceBox.setOnAction(this::getReport);

    }

    public void getReport(ActionEvent event) {

        String myReport = myChoiceBox.getValue();
        myLabel.setText(myReport);
    }

}