/**
 * GUI Application java file report generation
 * @author AS & SR
 * @version 2
 */

package com.example.report3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    // fake stage variable used in scene changing
    private static Stage stg0;

    @Override
    public void start(Stage stage) throws IOException {

        stg0 = stage;

        // false so user cannot maximise window
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("Report Generator");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    // method used by controller to change the scene when the 'button' is clicked
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml)); //uses input FXML file, not hard coded text
        stg0.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}