package cafepackage.cafe94_group2;

import backend.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;

/**
 * This class serves as a driver class and launches the GUI display.
 * @author Yingfan Zhang
 * @version 1.0
 */

public class Main extends Application {
    /**
     * This method sets and displays the main stage/screen.
     * @param primaryStage is the main screen of the program
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("ManagerScreen.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 400));
       primaryStage.show();
    }

    /**
     * This method serves as the main method and launches the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
		// Launch JavaFX application.
        launch();
    }
}