package cafepackage.cafe94_group2;

import backend.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CustomerBookingScreenController implements Initializable{
    @FXML
    DatePicker bookingDate;
    @FXML
    ComboBox<String> bookingTime;
    @FXML
    ComboBox<Integer> bookingNumberOfGuests;

    @FXML Label dateLabel;
    @FXML Label timeLabel;
    @FXML Label guestLabel;
    @FXML TableView<Booking> customerBookings;
    @FXML
    TableColumn<Booking, LocalDate> dateColumn;
    @FXML
    TableColumn<Booking, String> timeColumn;
    @FXML
    TableColumn<Booking, Integer> guestsColumn;
    @FXML
    TableColumn<Booking, Boolean> approvedColumn;

    private ObservableList<String> timeList = FXCollections.observableArrayList(
            "10:00", "11:00", "12:00", "13:00", "14:00",
            "15:00", "16:00", "17:00", "18:00", "19:00", "20:00",
            "21:00");
    private ObservableList<Integer> numberOfGuestsList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private Connection connection = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;


    @Override public void initialize(URL url, ResourceBundle rb) {
        bookingTime.setItems(timeList);
        bookingNumberOfGuests.setItems(numberOfGuestsList);

    }
//
//    public void createBooking(ActionEvent event) throws IOException {
//
//        if (bookingDate.getValue() == null) {
//            dateLabel.setText("Please enter booking date");
//            dateLabel.setVisible(true);
//        } else {
//            dateLabel.setVisible(false);
//        }
//        if (bookingTime.getValue() == null) {
//            timeLabel.setVisible(true);
//        } else {
//            timeLabel.setVisible(false);
//        }
//
//        if (bookingDate.getValue() != null
//                && bookingTime.getValue() != null
//                && bookingNumberOfGuests != null) {
//            try {
//
//                LocalDate date = bookingDate.getValue();
//                pst.setObject(1, date);
//                pst.setString(2, bookingTime.getValue());
//                pst.setInt(3, (Integer) bookingNumberOfGuests.getValue());
//
//                if(bookingDate.getValue().isBefore(LocalDate.now())){
//                    dateLabel.setText("Date must be for future booking");
//                    dateLabel.setVisible(true);
//                }
//                else {
//                    pst.executeUpdate();
//                    pst.close();
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//            finally {
//
//            }
//        }
//    }

//    private ObservableList<Booking> getBookingList(ResultSet rsBooking) throws SQLException {
//        ObservableList<Booking> tempBookingList = FXCollections.observableArrayList();
//        while(rsBooking.next()){
//            Booking temp = new Booking();
//            temp.setDate(rsBooking.getString("date"));
//            temp.getGuestCount(rsBooking.getInt("numberOfGuests"));
//            temp.setApproved(rsBooking.getBoolean("approved"));
//            temp.setBookingID(rsBooking.getInt("bookingID"));
//            tempBookingList.add(temp);
//        }
//        return tempBookingList;
//    }
}





