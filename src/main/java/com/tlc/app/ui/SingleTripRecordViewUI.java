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

        gp.addRow(0,dispatchingBaseNumberLabel, dispatchingBaseNumberTextField, timePickedUpLabel, timePickedTextField);
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
        Button deleteButton = new Button("Delete");

        buttonBar.setButtonData(cancelButton, ButtonBar.ButtonData.CANCEL_CLOSE);
        buttonBar.setButtonData(saveButton, ButtonBar.ButtonData.OK_DONE);

        buttonBar.getButtons().addAll(saveButton, cancelButton);

        vbox.getChildren().addAll(gp, sep, buttonBar);
        return vbox;
    }
}
