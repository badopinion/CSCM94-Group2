package cafepackage.cafe94_group2;

import backend.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.ArrayList;

/**
 * This is is the controller for a screen that allows the Manager to add staff to the system.
 * Given information in several fields, calls the appropriate method of the Login object to generate a new staff member.
 * @author Yingfan Zhang, Jo Butler
 * @version 1
 */


public class ManagerAddScreenController implements Initializable {
    @FXML
    TextField firstNameField;
    @FXML
    TextField lastNameField;
    @FXML
    TextField addressField;
    @FXML
    ComboBox<String> staffTypeField;
    @FXML
    TextField usernameField;
    @FXML
    TextField passwordField;
    @FXML
    Label errorLabel;

    private ObservableList<String> staffTypeList = FXCollections.observableArrayList(
            "Waiter",
            "Driver",
            "Chef"
    );

    /**
     * Method called automatically when the scene is initialized. Allows data initialization.
     * @param url
     * @param rb
     */
    @Override public void initialize(URL url, ResourceBundle rb) {
        staffTypeField.setItems(staffTypeList);
    }

    /**
     * Button that, when pressed, attempts to add a new user to the system.
     * If insufficient data is entered, a label will display an error.
     * Otherwise, the appropriate method of Login will be called to create a new user.
     * Pulls appropriate information from other fields on this page to find parameters for the user instantiation.
     * @param event Used to get information in current scene.
     * @throws IOException Throws if input fails.
     */
    public void addStaffButtonOnAction(ActionEvent event) throws IOException{
        Restaurant res = new Load().loadRestaurant();
        if(firstNameField.getText() == "" || firstNameField.getText() == null){
            errorLabel.setText("Please enter the employee's first name.");
        } else if(lastNameField.getText() == "" || lastNameField.getText() == null){
            errorLabel.setText("Please enter the employee's last name.");
        } else if(addressField.getText() == "" || addressField.getText() == null){
            errorLabel.setText("Please enter the employee's address.");
        } else if(usernameField.getText() == "" || usernameField.getText() == null){
            errorLabel.setText("Please enter the desired username.");
        } else if(passwordField.getText() == "" || passwordField.getText() == null){
            errorLabel.setText("Please enter a password.");
        } else {
            if(staffTypeField.getValue() == "Waiter") {
                if(res.login.newWaiter(
                        usernameField.getText(), passwordField.getText(), firstNameField.getText(),
                        lastNameField.getText(), addressField.getText()
                )){
                    errorLabel.setText("New staff profile created!");
                } else {
                    errorLabel.setText("Failed to create the user. Try a different username.");
                }
            } else if(staffTypeField.getValue() == "Driver") {
                if(res.login.newDriver(
                        usernameField.getText(), passwordField.getText(), firstNameField.getText(),
                        lastNameField.getText(), addressField.getText()
                )){
                    errorLabel.setText("New staff profile created!");
                } else {
                    errorLabel.setText("Failed to create the user. Try a different username.");
                }
            } else if(staffTypeField.getValue() == "Chef") {
                if(res.login.newChef(
                        usernameField.getText(), passwordField.getText(), firstNameField.getText(),
                        lastNameField.getText(), addressField.getText()
                )){
                    errorLabel.setText("New staff profile created!");
                } else {
                    errorLabel.setText("Failed to create the user. Try a different username.");
                }
            }
        }
        errorLabel.setVisible(true);
        res.saveRestaurant();
    }
}
