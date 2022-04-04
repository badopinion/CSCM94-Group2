package cafepackage.cafe94_group2;

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



    private String[] choice = {"Most Valued Customer","Busiest Period",
            "Most Hours Worked", "Most Popular Item"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }


}