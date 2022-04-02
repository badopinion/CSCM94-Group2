//OJ is adding a test comment
package cafepackage.cafe94_group2;

import backend.*;

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
        // Get the restaurant from the file. This should work fine verbatim no matter where you call it.
        Restaurant res = new Load().getRestaurantFromFile();

        // Do stuff.
        if(res.menu.getAllItems().size() == 0) {
            res.menu.populateMenu();
        }
        String hello = res.menu.returnMenuItems();
        display.setText(hello);

        // Save the restaurant to file, so you don't lose your changes.
        res.saveRestaurant();
    }



}
