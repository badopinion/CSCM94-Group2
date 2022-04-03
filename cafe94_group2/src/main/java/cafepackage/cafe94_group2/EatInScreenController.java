package cafepackage.cafe94_group2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class EatInScreenController implements Initializable {
        @FXML
        ComboBox<String> tableSelection;

    ObservableList<String> table =
            FXCollections.observableArrayList(
                    "Table 1",
                    "Table 2",
                    "Table 3",
                    "Table 4",
                    "Table 5",
                    "Table 6",
                    "Table 7",
                    "Table 8",
                    "Table 9",
                    "Table 10",
                    "Table 11"
            );
    final ComboBox comboBox = new ComboBox(table);

    @Override public void initialize(URL url, ResourceBundle rb) {
        tableSelection.setItems(table);


    }


}
