package cafepackage.cafe94_group2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

/*
this is login Controller
@author Evan
@version1
 */



public class LoginController {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField enterUsernameField;



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


}