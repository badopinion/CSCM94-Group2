package cafepackage.cafe94_group2;

import backend.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

/**
 this is login Controller
 @author Yingfan Zhang
 @version1
 */



public class LoginController {
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField enterUsernameField;
    @FXML
    private TextField enterPasswordField;


    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {
        if(enterUsernameField.getText().isBlank() || enterPasswordField.getText().isBlank()){
            loginMessageLabel.setText("Please enter username and password");
        } else {
            System.out.println("Entering load block.");
            Restaurant res = new Load().getRestaurantFromFile();
            System.out.println("Loaded.");
            if(res.login.loginWithCredentials(enterUsernameField.getText(), enterPasswordField.getText())){
                String userType = res.login.checkLoggedInUserType();
                res.saveRestaurant();
                Parent root = null;
                switch(userType){
                    case "Manager":
                        Stage managerScreen = new Stage();
                        root = FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
                        managerScreen.setTitle("ManagerInterface");
                        managerScreen.setScene(new Scene(root, 730, 530));
                        managerScreen.setX(600);
                        managerScreen.setY(250);
                        managerScreen.initModality(Modality.APPLICATION_MODAL);
                        managerScreen.show();
                        break;
                    case "Waiter":
                        Stage waiterScreen = new Stage();
                        root = FXMLLoader.load(getClass().getResource("WaiterScreen.fxml"));
                        waiterScreen.setTitle("WaiterInterface");
                        waiterScreen.setScene(new Scene(root, 730, 530));
                        waiterScreen.setX(600);
                        waiterScreen.setY(250);
                        waiterScreen.initModality(Modality.APPLICATION_MODAL);
                        waiterScreen.show();
                        break;
                    case "Driver":
                        Stage driverScreen = new Stage();
                        root = FXMLLoader.load(getClass().getResource("DriverScreen.fxml"));
                        driverScreen.setTitle("DriverInterface");
                        driverScreen.setScene(new Scene(root, 730, 530));
                        driverScreen.setX(600);
                        driverScreen.setY(250);
                        driverScreen.initModality(Modality.APPLICATION_MODAL);
                        driverScreen.show();
                        break;
                    case "Chef":
                        Stage chefScreen = new Stage();
                        root = FXMLLoader.load(getClass().getResource("ChefScreen.fxml"));
                        chefScreen.setTitle("ChefInterface");
                        chefScreen.setScene(new Scene(root, 730, 530));
                        chefScreen.setX(600);
                        chefScreen.setY(250);
                        chefScreen.initModality(Modality.APPLICATION_MODAL);
                        chefScreen.show();
                        break;
                    case "Customer":
                        Stage customerScreen = new Stage();
                        root = FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));
                        customerScreen.setTitle("CustomerInterface");
                        customerScreen.setScene(new Scene(root, 600, 400));
                        customerScreen.setX(600);
                        customerScreen.setY(250);
                        customerScreen.initModality(Modality.APPLICATION_MODAL);
                        customerScreen.show();
                        break;
                    default:
                        loginMessageLabel.setText("Error: Couldn't resolve user subclass.");
                }
            } else {
                loginMessageLabel.setText("Username and password not recognised.");
            }
        }

    }
    public void StaffChooseOnAction(ActionEvent event) throws IOException {
        Stage staffScreen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("StaffScreen.fxml"));
        staffScreen.setTitle("StaffInterface");
        staffScreen.setScene(new Scene(root, 600, 400));
        staffScreen.setX(600);
        staffScreen.setY(250);
        staffScreen.initModality(Modality.APPLICATION_MODAL);
        staffScreen.show();

    }
}