package com.tlc.app.ui;

import com.tlc.app.model.ReadTripRecordModel;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class SingleTripRecordViewUI {

    static Label dispatchingBaseNumberLabel = new Label("Dispatching Base Number:");
    static TextField dispatchingBaseNumberTextField = new TextField();

    static Label timePickedUpLabel = new Label("Time Picked Up:");
    static TextField timePickedTextField = new TextField();

    static Label pickupTextLabel = new Label("Pickup:");
    static TextField pickupTextField = new TextField();

    static Label destinationLabel = new Label("Destination:");
    static TextField destinationTextField = new TextField();

    static Label timeCompletedLabel = new Label("Time Completed:");
    static TextField timeCompletedTextField = new TextField();

    static Label affiliatedBaseNumberLabel = new Label("Affiliated Base Number:");
    static TextField affiliatedBaseNumberTextField = new TextField();

    static Label pickupLatitudeLabel = new Label("Pickup Latitude:");
    static TextField pickupLatitudeTextField = new TextField();

    static Label pickupLongitudeLabel = new Label("Pickup Longitude:");
    static TextField pickupLongitudeTextField = new TextField();

    static Label destinationLatitudeLabel = new Label("Destination Latitude:");
    static TextField destinationLatitudeTextField = new TextField();

    static Label destinationLongitudeLabel = new Label("Destination Longitude:");
    static TextField destinationLongitudeTextField = new TextField();

    static Label TLCDriverLicenseNumberLabel = new Label("Tlc Driver License Number:");
    static TextField TLCDriverLicenseNumberTextField = new TextField();

    static Label vehiclePlateNumberLabel = new Label("Vehicle Plate Number:");
    static TextField vehiclePlateNumberTextField = new TextField();

    static Label driverLabel = new Label("Driver:");
    static TextField driverTextField = new TextField();

    static Label timeDispatchedLabel = new Label("Time Dispatched:");
    static TextField timeDispatchedTextField = new TextField();

    static Label timeVehicleArrivedLabel = new Label("Time Vehicle Arrived:");
    static TextField timeVehicleArrivedTextField = new TextField();

    public static void setData(ReadTripRecordModel readTripRecordModel) {
        dispatchingBaseNumberTextField.setText(readTripRecordModel.getDispatchingBaseNumber());
        timePickedTextField.setText(readTripRecordModel.getTimePickedUp());
        pickupTextField.setText(readTripRecordModel.getPickup());
        destinationTextField.setText(readTripRecordModel.getDestination());
        timeCompletedTextField.setText(readTripRecordModel.getTimeCompleted());
        affiliatedBaseNumberTextField.setText(readTripRecordModel.getAffiliatedBaseNumber());
        pickupLatitudeTextField.setText(readTripRecordModel.getPickupLatitude());
        pickupLongitudeTextField.setText(readTripRecordModel.getPickupLongitude());
        destinationLatitudeTextField.setText(readTripRecordModel.getDestinationLatitude());
        destinationLongitudeTextField.setText(readTripRecordModel.getDestinationLongitude());
        TLCDriverLicenseNumberTextField.setText(readTripRecordModel.getTLCDriverLicenseNumber());
        vehiclePlateNumberTextField.setText(readTripRecordModel.getVehiclePlateNumber());
        driverTextField.setText(readTripRecordModel.getDriver());
        timeDispatchedTextField.setText(readTripRecordModel.getTimeDispatched());
        timeVehicleArrivedTextField.setText(readTripRecordModel.getTimeVehicleArrived());
    }

    public static VBox generateUI() {
        VBox vbox = new VBox();
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10));
        gp.setHgap(4);
        gp.setVgap(10);
        VBox.setVgrow(gp, Priority.ALWAYS);

        gp.addRow(0, dispatchingBaseNumberLabel, dispatchingBaseNumberTextField, timePickedUpLabel, timePickedTextField);
        gp.addRow(1, pickupTextLabel, pickupTextField, destinationLabel, destinationTextField);
        gp.addRow(2, timeCompletedLabel, timeCompletedTextField, affiliatedBaseNumberLabel, affiliatedBaseNumberTextField);
        gp.addRow(3, pickupLatitudeLabel, pickupLatitudeTextField, pickupLongitudeLabel, pickupLongitudeTextField);
        gp.addRow(4, destinationLatitudeLabel, destinationLatitudeTextField, destinationLongitudeLabel, destinationLongitudeTextField);
        gp.addRow(5, TLCDriverLicenseNumberLabel, TLCDriverLicenseNumberTextField, vehiclePlateNumberLabel, vehiclePlateNumberTextField);
        gp.addRow(6, driverLabel, driverTextField, timeDispatchedLabel, timeDispatchedTextField);
        gp.addRow(7, timeVehicleArrivedLabel, timeVehicleArrivedTextField);

        Separator sep = new Separator(); // hr

        ButtonBar buttonBar = new ButtonBar();
        buttonBar.setPadding(new Insets(10));

        Button saveButton = new Button("Update");
        Button cancelButton = new Button("Cancel");

        buttonBar.setButtonData(cancelButton, ButtonBar.ButtonData.CANCEL_CLOSE);
        buttonBar.setButtonData(saveButton, ButtonBar.ButtonData.OK_DONE);

        buttonBar.getButtons().addAll(saveButton, cancelButton);
        vbox.getChildren().addAll(gp, sep, buttonBar);
        return vbox;
    }
}
