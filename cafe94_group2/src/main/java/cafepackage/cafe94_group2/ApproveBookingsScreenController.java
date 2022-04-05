package cafepackage.cafe94_group2;

import backend.Restaurant;
import backend.Load;
import backend.BookingTable;
import backend.Booking;
import backend.Table;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;

/**
 * A class that used to approve booking
 * @author  Jo Butler , Hristiana Davidova
 * @version 1.0
 */
public class ApproveBookingsScreenController implements Initializable {
    @FXML
    private Label bookingApprovalLabel;
    @FXML
    private ListView<String> unapprovedBookings;

    private String selected = null;

    /**
     * Initialize the screen
     */

    @Override public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Initializing");
        unapprovedBookings.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selected = unapprovedBookings.getSelectionModel().getSelectedItem();
            }
        });
        displayUnapprovedBookings();
    }

    /**
     * To approve the bookings.
     * @param event Click the Approve Booking Button
     * @throws IOException Throws if input fails
     */

    public void approveBookingsButtonOnAction(ActionEvent event) throws IOException{
        Restaurant res = new Load().loadRestaurant();
        ArrayList<BookingTable> uab = fetchUnapprovedBookings();
        int uabNumber = Integer.parseInt(selected.split(":")[0]);
        BookingTable btToApprove = uab.get(uabNumber);
        for (Booking b : res.getTable(btToApprove.getTableNumber()).getBookings()){
            System.out.println("Do user names match?");
            System.out.println(btToApprove.getBooking().getCustomer().getUsername());
            System.out.println(b.getCustomer().getUsername());
            System.out.println(btToApprove.getBooking().getCustomer().getUsername().equals(b.getCustomer().getUsername()));
            System.out.println("Do times match?");
            System.out.println(btToApprove.getBooking().getBookingStart().toString().equals(b.getBookingStart().toString()));
            if (
                    btToApprove.getBooking().getCustomer().getUsername().equals(b.getCustomer().getUsername())
                    && btToApprove.getBooking().getBookingStart().toString().equals(b.getBookingStart().toString())
            ){
                System.out.println("Approving.");
                b.approve();
            }
        }
        res.saveRestaurant();
        selected = null;
        displayUnapprovedBookings();
    }

    /**
     * To show that have not been approved for the time being.
     */

    public void displayUnapprovedBookings(){
        System.out.println("DUB running");
        unapprovedBookings.getItems().clear();
        ArrayList<BookingTable> uab = fetchUnapprovedBookings();
        ArrayList<String> output = new ArrayList<String>();
        for (BookingTable bt : uab){
            output.add(output.size() + ": "
                    + bt.getBooking().getCustomer().getFirstName() + " " + bt.getBooking().getCustomer().getLastName()
                    + " on table " + bt.getTableNumber()
                    + " at " + bt.getTime().split("T")[0] + ", " + bt.getTime().split("T")[1]
            );
        }
        unapprovedBookings.getItems().addAll(output);
    }

    /**
     * Get information that have not been approved for the time being.
     * @return The information that have not been approved
     */

    public ArrayList<BookingTable> fetchUnapprovedBookings(){
        Restaurant res = new Load().loadRestaurant();
        Table[] tables = res.getAllTables();
        ArrayList<BookingTable> nonApprovedBookings = new ArrayList<BookingTable>();
        for (Table t : tables){
            for (Booking b : t.getBookings()){
                if (!b.isApproved() && !b.isCancelled()){
                    nonApprovedBookings.add(new BookingTable(b, t));
                }
            }
        }
        return nonApprovedBookings;
    }
}
