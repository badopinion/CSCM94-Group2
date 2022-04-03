/**
 * GUI Controller java file report generation
 * @author AS & SR
 * @version 2
 */

package com.example.report3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportGen {

    public ReportGen() {
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    // methods to connect 'button' with java file
    @FXML
    private Button item;
    @FXML
    private Button period;
    @FXML
    private Button customer;
    @FXML
    private Button hours;


    // 1st method to generate report when button is clicked for most popular item
    public void pop_itm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("popular_Item.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //checkpop_itm();
    }
/*    private void checkpop_itm() throws IOException {
        Main m = new Main();
        m.changeScene("popular_Item.fxml");
    }

    // 2nd method to generate report when button is clicked for busiest period
    public void busy(ActionEvent event) throws IOException {
        checkbusy();
    }
    private void checkbusy() throws IOException {
        Main m = new Main();
        m.changeScene("busyTime.fxml");
    }

    // 3rd method to generate report when button is clicked for most active customer
    public void active_cust(ActionEvent event) throws IOException {
        checkactive_cust();
    }
    private void checkactive_cust() throws IOException {
        Main m = new Main();
        m.changeScene("activeCustomer.fxml");
    }

    // 4th method to generate report when button is clicked for most hours worked
    public void most_hrs(ActionEvent event) throws IOException {
        checkmost_hrs();
    }
    private void checkmost_hrs() throws IOException {
        Main m = new Main();
        m.changeScene("mostWork.fxml");
    }
    */


}

