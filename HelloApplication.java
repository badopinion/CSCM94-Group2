package com.example.report3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stg0;

    @Override
    public void start(Stage stage) throws IOException {

        stg0 = stage;

        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("Report Generator");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        stg0.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}