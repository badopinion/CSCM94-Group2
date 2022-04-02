//OJ is adding a test comment

package cafepackage.cafe94_group2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MenuScreenController {
    @FXML
    Button coffee;
    @FXML
    Button goodbye;
    @FXML
    TextArea display;

    public void sayHello(ActionEvent event) throws IOException {
        String hello = "Hello";
        display.setText(hello);
    }

    public void sayGoodbye(ActionEvent event) throws IOException {
        CafeMenu newMenu = new CafeMenu();
        newMenu.populateMenu();
        String hello = newMenu.returnMenuItems();
        display.setText(hello);
    }



}
