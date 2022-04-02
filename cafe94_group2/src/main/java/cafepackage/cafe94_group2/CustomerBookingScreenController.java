package cafepackage.cafe94_group2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerBookingScreenController  implements Initializable{
    @FXML
    DatePicker bookingDate;
    @FXML
    ComboBox<String> bookingTime;
    @FXML
    ComboBox<Integer>bookingNumberOfGuests;
    @FXML
    TableView<Booking> customerBookings;
    @FXML
    TableColumn<Booking, LocalDate> dateColumn;
    @FXML TableColumn<Booking, String> timeColumn;
    @FXML TableColumn<Booking, Integer> guestsColumn;
    @FXML TableColumn<Booking, Boolean> approvedColumn;

    private ObservableList<String> timeList = FXCollections.observableArrayList(
            "10:00", "11:00", "12:00", "13:00", "14:00",
            "15:00", "16:00", "17:00", "18:00", "19:00", "20:00",
            "21:00");
    private ObservableList<Integer> numberOfGuestsList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8,9,10);
    private Connection connection = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    @Override public void initialize(URL url, ResourceBundle rb) {
        bookingTime.setItems(timeList);
        bookingNumberOfGuests.setItems(numberOfGuestsList);
        try{
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
