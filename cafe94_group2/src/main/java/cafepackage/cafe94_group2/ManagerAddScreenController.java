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
    @FXML
    ListView<String> existingStaffListView;
    @FXML
    Label selectedStaffLabel;

    private String selected = null;


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
        displayStaffMembers();

        existingStaffListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selected = existingStaffListView.getSelectionModel().getSelectedItem();
                User selStaff = new Load().loadRestaurant().login.getUserFromUsername(selected);
                selectedStaffLabel.setText(
                        selStaff == null ? "No staff selected" :
                        selStaff.getFirstName() + " " + selStaff.getLastName() + ", "
                                + selStaff.getClass().toString().split("\\.")[1]
                );
            }
        });
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
        if(firstNameField.getText().equals("") || firstNameField.getText() == null){
            errorLabel.setText("Please enter the employee's first name.");
        } else if(lastNameField.getText().equals("") || lastNameField.getText() == null){
            errorLabel.setText("Please enter the employee's last name.");
        } else if(addressField.getText().equals("") || addressField.getText() == null){
            errorLabel.setText("Please enter the employee's address.");
        } else if(staffTypeField.getValue() == null){
            errorLabel.setText("Please choose a staff type.");
        }else if(usernameField.getText().equals("") || usernameField.getText() == null){
            errorLabel.setText("Please enter the desired username.");
        } else if(passwordField.getText().equals("") || passwordField.getText() == null){
            errorLabel.setText("Please enter a password.");
        } else {
            if(staffTypeField.getValue().equals("Waiter")){
                if(res.login.newWaiter(
                        usernameField.getText(), passwordField.getText(), firstNameField.getText(),
                        lastNameField.getText(), addressField.getText()
                )){
                    errorLabel.setText("New staff profile created!");
                } else {
                    errorLabel.setText("Failed to create the user. Try a different username.");
                }
            } else if(staffTypeField.getValue().equals("Driver")){
                if(res.login.newDriver(
                        usernameField.getText(), passwordField.getText(), firstNameField.getText(),
                        lastNameField.getText(), addressField.getText()
                )){
                    errorLabel.setText("New staff profile created!");
                } else {
                    errorLabel.setText("Failed to create the user. Try a different username.");
                }
            } else if(staffTypeField.getValue().equals("Chef")){
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
        displayStaffMembers();
    }

    /**
     * Button that, when pressed, will try to remove the staff member selected in the ListView from the user list.
     * Achieves this by calling the appropriate method in Login.
     * @param event Used to get information in current scene.
     * @throws IOException Throws if input fails.
     */
    public void removeButtonOnAction(ActionEvent event) throws IOException{
        if(selected != null) {
            Restaurant res = new Load().loadRestaurant();
            res.login.removeUser(selected);
            res.saveRestaurant();
            displayStaffMembers();
        }
    }

    /**
     * Utility function that puts all staff members into the ListView.
     */
    public void displayStaffMembers(){
        Restaurant res = new Load().loadRestaurant();
        existingStaffListView.getItems().clear();
        for(User u : res.login.getStaffList()){
            if(u instanceof Staff){
                existingStaffListView.getItems().add(u.getUsername());
            }
        }
    }
}
