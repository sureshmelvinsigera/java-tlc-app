package com.tlc.app.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class SingleTripRecordViewUI {
    public static VBox generateUI() {
        VBox vbox = new VBox();

        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10));
        gp.setHgap(4);
        gp.setVgap(10);

        VBox.setVgrow(gp, Priority.ALWAYS);

        Label lblTitle = new Label("Support Ticket");

        Label dispatchingBaseNumberLabel = new Label("Dispatching Base Number:");
        TextField dispatchingBaseNumberTextField = new TextField();


        Label timePickedUpLabel = new Label("Time Picked Up:");
        TextField timePickedTextField = new TextField();

        Label pickupTextLabel = new Label("Pickup:");
        TextField pickupTextField = new TextField();

        Label destinationLabel = new Label("Destination:");
        TextField destinationTextField = new TextField();

        Label timeCompletedLabel = new Label("Time Completed:");
        TextField timeCompletedTextField = new TextField();

        Label affiliatedBaseNumberLabel = new Label("Affiliated Base Number:");
        TextField affiliatedBaseNumberTextField = new TextField();

        Label pickupLatitudeLabel = new Label("Pickup Latitude:");
        TextField pickupLatitudeTextField = new TextField();

        Label pickupLongitudeLabel = new Label("Pickup Longitude:");
        TextField pickupLongitudeTextField = new TextField();

        Label destinationLatitudeLabel = new Label("Destination Latitude:");
        TextField destinationLatitudeTextField = new TextField();

        Label destinationLongitudeLabel = new Label("Destination Longitude:");
        TextField destinationLongitudeTextField = new TextField();

        Label TLCDriverLicenseNumberLabel = new Label("Tlc Driver License Number:");
        TextField TLCDriverLicenseNumberTextField = new TextField();

        Label vehiclePlateNumberLabel = new Label("Vehicle Plate Number:");
        TextField vehiclePlateNumberTextField = new TextField();

        Label driverLabel = new Label("Driver:");
        TextField driverTextField = new TextField();

        Label timeDispatchedLabel = new Label("Time Dispatched:");
        TextField timeDispatchedTextField = new TextField();

        Label timeVehicleArrivedLabel = new Label("Time Vehicle Arrived:");
        TextField timeVehicleArrivedTextField = new TextField();


        Label lblPriority = new Label("Priority");
        ObservableList<String> priorities =
                FXCollections.observableArrayList("Medium", "High", "Low");
        ComboBox<String> cbPriority = new ComboBox<>(priorities);

        Label lblSeverity = new Label("Severity");
        ObservableList<String> severities = FXCollections.observableArrayList("Blocker", "Workaround", "N/A");
        ComboBox<String> cbSeverity = new ComboBox<>(severities);

        Label lblCategory = new Label("Category");
        ObservableList<String> categories = FXCollections.observableArrayList("Bug", "Feature");
        ComboBox<String> cbCategory = new ComboBox<>(categories);

        Label lblProblem = new Label("Problem");
        TextField tfProblem = new TextField();

        Label lblDescription = new Label("Description");
        TextArea taDescription = new TextArea();

//        gp.add(lblTitle, 1, 0);  // empty item at 0,0

        gp.add(dispatchingBaseNumberLabel, 1, 1);
        gp.add(dispatchingBaseNumberTextField, 0, 2);

        gp.add(timePickedUpLabel, 1, 2);
        gp.add(timePickedTextField, 0, 3);

//        gp.add(pickupTextLabel, 0, 2);
//        gp.add(pickupTextField, 1, 2);
//
//        gp.add(destinationLabel, 0, 3);
//        gp.add(destinationTextField, 1, 3);
//
//        gp.add(timeCompletedLabel, 0, 4);
//        gp.add(timeCompletedTextField, 1, 4);
//
//        gp.add(affiliatedBaseNumberLabel, 0, 5);
//        gp.add(affiliatedBaseNumberTextField, 1, 5);
//
//        gp.add(pickupLatitudeLabel, 0, 6);
//        gp.add(pickupLatitudeTextField, 1, 6);
//
//        gp.add(pickupLongitudeLabel, 0, 7);
//        gp.add(pickupLongitudeTextField, 1, 7);
//
//        gp.add(destinationLatitudeLabel, 0, 8);
//        gp.add(destinationLatitudeTextField, 1, 8);
//
//        gp.add(destinationLongitudeLabel, 0, 9);
//        gp.add(destinationLongitudeTextField, 1, 9);
//
//        gp.add(TLCDriverLicenseNumberLabel, 0, 10);
//        gp.add(TLCDriverLicenseNumberTextField, 1, 10);
//
//        gp.add(vehiclePlateNumberLabel, 0, 11);
//        gp.add(vehiclePlateNumberTextField, 1, 11);
//
//        gp.add(driverLabel, 0, 12);
//        gp.add(driverTextField, 1, 12);
//
//        gp.add(timeDispatchedLabel, 0, 13);
//        gp.add(timeDispatchedTextField, 1, 13);
//
//        gp.add(timeVehicleArrivedLabel, 0, 14);
//        gp.add(timeVehicleArrivedTextField, 1, 14);

//        gp.add(pickupLongitudeLabel, 0, 4);
//        gp.add(pickupLongitudeLabel, 1, 4);

//        GridPane.setColumnSpan(lblTitle, 5);
//        GridPane.setColumnSpan(dispatchingBaseNumberTextField, 3);
//        GridPane.setColumnSpan(tfProblem, 5);
//        GridPane.setColumnSpan(taDescription, 5);

        Separator sep = new Separator(); // hr

        ButtonBar buttonBar = new ButtonBar();
        buttonBar.setPadding(new Insets(10));

        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        buttonBar.setButtonData(saveButton, ButtonBar.ButtonData.OK_DONE);
        buttonBar.setButtonData(cancelButton, ButtonBar.ButtonData.CANCEL_CLOSE);

        buttonBar.getButtons().addAll(saveButton, cancelButton);

        vbox.getChildren().addAll(gp, sep, buttonBar);
        return vbox;
    }
}
