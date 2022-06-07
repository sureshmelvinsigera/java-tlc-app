package com.tlc.app.model;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.tlc.app.MainApplication;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadTripRecordModel {
    public SimpleIntegerProperty columnId;
    public SimpleStringProperty dispatchingBaseNumber;
    public SimpleStringProperty timePickedUp;
    public SimpleStringProperty pickup;
    public SimpleStringProperty destination;
    public SimpleStringProperty timeCompleted;
    public SimpleStringProperty affiliatedBaseNumber;
    public SimpleStringProperty pickupLatitude;
    public SimpleStringProperty pickupLongitude;
    public SimpleStringProperty destinationLatitude;
    public SimpleStringProperty destinationLongitude;
    public SimpleStringProperty TLCDriverLicenseNumber;
    public SimpleStringProperty vehiclePlateNumber;
    public SimpleStringProperty driver;
    public SimpleStringProperty timeDispatched;
    public SimpleStringProperty timeVehicleArrived;

    private static final TableView tableView = new TableView();

    static TableColumn idColumn = new TableColumn("ID");
    static TableColumn dispatchingBaseNumberColumn = new TableColumn("Dispatching Base Number");
    static TableColumn timePickedUpColumn = new TableColumn("Time Picked Up");
    static TableColumn pickupColumn = new TableColumn("Pick Up");
    static TableColumn destinationColumn = new TableColumn("Destination");
    static TableColumn timeCompletedColumn = new TableColumn("Time Completed");
    static TableColumn affiliatedBaseNumberColumn = new TableColumn("Affiliated Base Number");
    static TableColumn pickupLatitudeColumn = new TableColumn("Pickup Latitude");
    static TableColumn pickupLongitudeColumn = new TableColumn("Pickup Longitude");
    static TableColumn destinationLatitudeColumn = new TableColumn("Destination Latitude");
    static TableColumn destinationLongitudeColumn = new TableColumn("Destination Longitude");
    static TableColumn TLCDriverLicenseNumberColumn = new TableColumn("TLC Driver License Number");
    static TableColumn driverColumn = new TableColumn("Driver");
    static TableColumn timeDispatchedColumn = new TableColumn("Time Dispatched");
    static TableColumn timeVehicleArrivedColumn = new TableColumn("Time Vehicle Arrived");

    public static boolean checkColumns(String[] columnsArray) {
        return Arrays.asList(columnsArray).contains("Dispatching Base Number") &&
                Arrays.asList(columnsArray).contains("Time Picked Up") &&
                Arrays.asList(columnsArray).contains("Pickup") &&
                Arrays.asList(columnsArray).contains("Destination") &&
                Arrays.asList(columnsArray).contains("Time Completed") &&
                Arrays.asList(columnsArray).contains("Affiliated Base Number") &&
                Arrays.asList(columnsArray).contains("Pickup Latitude") &&
                Arrays.asList(columnsArray).contains("Pickup Longitude") &&
                Arrays.asList(columnsArray).contains("Destination Latitude") &&
                Arrays.asList(columnsArray).contains("Destination Longitude") &&
                Arrays.asList(columnsArray).contains("Tlc Driver License Number") &&
                Arrays.asList(columnsArray).contains("Vehicle Plate Number") &&
                Arrays.asList(columnsArray).contains("Driver") &&
                Arrays.asList(columnsArray).contains("Time Dispatched") &&
                Arrays.asList(columnsArray).contains("Time Vehicle Arrived");
    }

    public ReadTripRecordModel(Integer columnId, String dispatchingBaseNumber, String timePickedUp, String pickup, String destination,
                               String timeCompleted, String affiliatedBaseNumber,
                               String pickupLatitude, String pickupLongitude, String destinationLatitude,
                               String destinationLongitude, String TLCDriverLicenseNumber, String vehiclePlateNumber,
                               String driver, String timeDispatched, String timeVehicleArrived) {
        this.columnId = new SimpleIntegerProperty(columnId);
        this.dispatchingBaseNumber = new SimpleStringProperty(dispatchingBaseNumber);
        this.timePickedUp = new SimpleStringProperty(timePickedUp);
        this.pickup = new SimpleStringProperty(pickup);
        this.destination = new SimpleStringProperty(destination);
        this.timeCompleted = new SimpleStringProperty(timeCompleted);
        this.affiliatedBaseNumber = new SimpleStringProperty(affiliatedBaseNumber);
        this.pickupLatitude = new SimpleStringProperty(pickupLatitude);
        this.pickupLongitude = new SimpleStringProperty(pickupLongitude);
        this.destinationLatitude = new SimpleStringProperty(destinationLatitude);
        this.destinationLongitude = new SimpleStringProperty(destinationLongitude);
        this.TLCDriverLicenseNumber = new SimpleStringProperty(TLCDriverLicenseNumber);
        this.vehiclePlateNumber = new SimpleStringProperty(vehiclePlateNumber);
        this.driver = new SimpleStringProperty(driver);
        this.timeDispatched = new SimpleStringProperty(timeDispatched);
        this.timeVehicleArrived = new SimpleStringProperty(timeVehicleArrived);



    }

    public int getColumnId() {
        return columnId.get();
    }

    public SimpleIntegerProperty columnIdProperty() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId.set(columnId);
    }

    public String getDispatchingBaseNumber() {
        return dispatchingBaseNumber.get();
    }

    public SimpleStringProperty dispatchingBaseNumberProperty() {
        return dispatchingBaseNumber;
    }

    public void setDispatchingBaseNumber(String dispatchingBaseNumber) {
        this.dispatchingBaseNumber.set(dispatchingBaseNumber);
    }

    public String getTimePickedUp() {
        return timePickedUp.get();
    }

    public SimpleStringProperty timePickedUpProperty() {
        return timePickedUp;
    }

    public void setTimePickedUp(String timePickedUp) {
        this.timePickedUp.set(timePickedUp);
    }

    public String getPickup() {
        return pickup.get();
    }

    public SimpleStringProperty pickupProperty() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup.set(pickup);
    }

    public String getDestination() {
        return destination.get();
    }

    public SimpleStringProperty destinationProperty() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public String getTimeCompleted() {
        return timeCompleted.get();
    }

    public SimpleStringProperty timeCompletedProperty() {
        return timeCompleted;
    }

    public void setTimeCompleted(String timeCompleted) {
        this.timeCompleted.set(timeCompleted);
    }

    public String getAffiliatedBaseNumber() {
        return affiliatedBaseNumber.get();
    }

    public SimpleStringProperty affiliatedBaseNumberProperty() {
        return affiliatedBaseNumber;
    }

    public void setAffiliatedBaseNumber(String affiliatedBaseNumber) {
        this.affiliatedBaseNumber.set(affiliatedBaseNumber);
    }

    public String getPickupLatitude() {
        return pickupLatitude.get();
    }

    public SimpleStringProperty pickupLatitudeProperty() {
        return pickupLatitude;
    }

    public void setPickupLatitude(String pickupLatitude) {
        this.pickupLatitude.set(pickupLatitude);
    }

    public String getPickupLongitude() {
        return pickupLongitude.get();
    }

    public SimpleStringProperty pickupLongitudeProperty() {
        return pickupLongitude;
    }

    public void setPickupLongitude(String pickupLongitude) {
        this.pickupLongitude.set(pickupLongitude);
    }

    public String getDestinationLatitude() {
        return destinationLatitude.get();
    }

    public SimpleStringProperty destinationLatitudeProperty() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(String destinationLatitude) {
        this.destinationLatitude.set(destinationLatitude);
    }

    public String getDestinationLongitude() {
        return destinationLongitude.get();
    }

    public SimpleStringProperty destinationLongitudeProperty() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(String destinationLongitude) {
        this.destinationLongitude.set(destinationLongitude);
    }

    public String getTLCDriverLicenseNumber() {
        return TLCDriverLicenseNumber.get();
    }

    public SimpleStringProperty TLCDriverLicenseNumberProperty() {
        return TLCDriverLicenseNumber;
    }

    public void setTLCDriverLicenseNumber(String TLCDriverLicenseNumber) {
        this.TLCDriverLicenseNumber.set(TLCDriverLicenseNumber);
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber.get();
    }

    public SimpleStringProperty vehiclePlateNumberProperty() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber.set(vehiclePlateNumber);
    }

    public String getDriver() {
        return driver.get();
    }

    public SimpleStringProperty driverProperty() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver.set(driver);
    }

    public String getTimeDispatched() {
        return timeDispatched.get();
    }

    public SimpleStringProperty timeDispatchedProperty() {
        return timeDispatched;
    }

    public void setTimeDispatched(String timeDispatched) {
        this.timeDispatched.set(timeDispatched);
    }

    public String getTimeVehicleArrived() {
        return timeVehicleArrived.get();
    }

    public SimpleStringProperty timeVehicleArrivedProperty() {
        return timeVehicleArrived;
    }

    public void setTimeVehicleArrived(String timeVehicleArrived) {
        this.timeVehicleArrived.set(timeVehicleArrived);
    }

    @Override
    public String toString() {
        return "TripRecord{" +
                "dispatchingBaseNumber=" + dispatchingBaseNumber +
                ", timePickedUp=" + timePickedUp +
                ", pickup=" + pickup +
                ", destination=" + destination +
                ", timeCompleted=" + timeCompleted +
                ", affiliatedBaseNumber=" + affiliatedBaseNumber +
                ", pickupLatitude=" + pickupLatitude +
                ", pickupLongitude=" + pickupLongitude +
                ", destinationLatitude=" + destinationLatitude +
                ", destinationLongitude=" + destinationLongitude +
                ", TLCDriverLicenseNumber=" + TLCDriverLicenseNumber +
                ", vehiclePlateNumber=" + vehiclePlateNumber +
                ", driver=" + driver +
                ", timeDispatched=" + timeDispatched +
                ", timeVehicleArrived=" + timeVehicleArrived +
                '}';
    }

    public static void createColumnsWithLoadData(ObservableList<ReadTripRecordModel> tripRecordObservableList, Stage primaryStage) {
        idColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, Integer>("columnId")
        );

        dispatchingBaseNumberColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("dispatchingBaseNumber")
        );
        timePickedUpColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("timePickedUp")
        );
        pickupColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("pickup")
        );
        destinationColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("destination")
        );
        timeCompletedColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("timeCompleted")
        );

        affiliatedBaseNumberColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("affiliatedBaseNumber")
        );
        pickupLatitudeColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("pickupLatitude")
        );
        pickupLongitudeColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("pickupLongitude")
        );
        destinationLatitudeColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("destinationLatitude")
        );
        destinationLongitudeColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("destinationLongitude")
        );
        TLCDriverLicenseNumberColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("TLCDriverLicenseNumber")
        );
        driverColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("driver")
        );
        timeDispatchedColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("timeDispatched")
        );
        timeVehicleArrivedColumn.setCellValueFactory(
                new PropertyValueFactory<ReadTripRecordModel, String>("timeVehicleArrived")
        );

        MainApplication.tripRecordModelTableView.setItems(tripRecordObservableList);
        MainApplication.tripRecordModelTableView.getColumns().addAll(
                idColumn, dispatchingBaseNumberColumn, timePickedUpColumn,
                pickupColumn, destinationColumn, timeCompletedColumn,
                affiliatedBaseNumberColumn, pickupLatitudeColumn, pickupLongitudeColumn,
                destinationLatitudeColumn, destinationLongitudeColumn, TLCDriverLicenseNumberColumn,
                driverColumn, timeDispatchedColumn, timeVehicleArrivedColumn);
    }
}
