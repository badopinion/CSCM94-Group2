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
private CheckBox CustomerChoose;
    @FXML
    private CheckBox StaffChoose;


    public void loginButtonOnAction(ActionEvent event){
  
    if(enterUsernameField.getText().isBlank()==false){
        loginMessageLabel.setText("you are login");
    }else{
        loginMessageLabel.setText("Please enter username and password");
    }
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

public void CustomerChooseOnAction(ActionEvent event) throws IOException {
    Stage customerScreen = new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));
    customerScreen.setTitle("CustomerInterface");
    customerScreen.setScene(new Scene(root, 600, 400));
    customerScreen.setX(600);
    customerScreen.setY(250);
    customerScreen.initModality(Modality.APPLICATION_MODAL);
    customerScreen.show();

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