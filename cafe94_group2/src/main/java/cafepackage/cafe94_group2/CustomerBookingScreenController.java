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
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * This is the controller for the screen that customers will use to request bookings.
 * @author Yingfan Zhang, Jo Butler
 * @version 2
 */

public class CustomerBookingScreenController implements Initializable{
    @FXML
    DatePicker bookingDate;
    @FXML
    ComboBox<String> bookingTime;
    @FXML
    ComboBox<Integer> bookingDuration;
    @FXML
    ComboBox<Integer> bookingNumberOfGuests;

    @FXML Label dateLabel;
    @FXML Label timeLabel;
    @FXML Label durationLabel;
    @FXML Label guestLabel;
    @FXML Label resultsLabel;
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
            "10:00", "10:30", "11:00", "11:30", "12:00",
            "12:30", "13:00", "13:30", "14:00", "14:30",
            "15:00", "15:30", "16:00", "16:30", "17:00",
            "17:30", "18:00", "18:30", "19:00", "19:30",
            "20:00", "20:30", "21:00", "21:30", "22:00");
    private ObservableList<Integer> numberOfGuestsList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private ObservableList<Integer> durationList = FXCollections.observableArrayList(60, 75, 90, 105, 120, 135, 150);
    private Connection connection = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;


    @Override public void initialize(URL url, ResourceBundle rb) {
        bookingTime.setItems(timeList);
        bookingNumberOfGuests.setItems(numberOfGuestsList);
        bookingDuration.setItems(durationList);
    }

    public void bookingButtonOnAction(ActionEvent event) throws IOException{
        Restaurant res = new Load().loadRestaurant();

        if(bookingDate.getValue() == null){
            dateLabel.setVisible(true);
            dateLabel.setText("Please choose a booking date.");
        } else {
            dateLabel.setVisible(false);
        }

        if(bookingTime.getValue() == null){
            timeLabel.setVisible(true);
            timeLabel.setText("Please choose a booking time.");
        } else {
            timeLabel.setVisible(false);
        }

        if(bookingDuration.getValue() == null){
            durationLabel.setVisible(true);
            durationLabel.setText("Please choose a booking length.");
        } else {
            durationLabel.setVisible(false);
        }

        if(bookingNumberOfGuests.getValue() == null){
            guestLabel.setVisible(true);
            guestLabel.setText("Please enter guest count.");
        } else {
            guestLabel.setVisible(false);
        }

        if(bookingDate.getValue() != null
                && bookingTime.getValue() != null
                && bookingDuration.getValue() != null
                && bookingNumberOfGuests.getValue() != null
                && bookingDate.getValue() != null
        ){
            resultsLabel.setText("Thank you. Attempting to book you in...");
            resultsLabel.setVisible(true);
            String[] timeStrings = bookingTime.getValue().split(":");
            int[] timeInts = {Integer.parseInt(timeStrings[0]), Integer.parseInt(timeStrings[1])};
            int[] dateInts = {
                    bookingDate.getValue().getDayOfMonth(),
                    bookingDate.getValue().getMonthValue(),
                    bookingDate.getValue().getYear()
            };
            LocalDateTime bookDT = LocalDateTime.of(dateInts[2], dateInts[1], dateInts[0], timeInts[0], timeInts[1], 0);
            int tableNumberOut =
                    res.findTableAndBook(bookingNumberOfGuests.getValue(),
                            bookDT, bookingDuration.getValue(), (Customer) res.login.getLoggedIn());
            if(tableNumberOut == 0){
                resultsLabel.setText("Sorry, we do not have space for your group at " + bookingTime.getValue() + ".");
            } else {
                resultsLabel.setText("You are booked in on table number " + tableNumberOut + "!");
                res.saveRestaurant();
            }
        }
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





