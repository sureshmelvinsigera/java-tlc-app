package com.tlc.app;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.tlc.app.model.ReadTripRecordModel;
import com.tlc.app.ui.SingleTripRecordViewUI;
import com.tlc.app.util.Validate;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainApplication extends Application {
    public final static ObservableList<ReadTripRecordModel> readTripRecordModelObservableList = FXCollections.observableArrayList();
    public static TableView<ReadTripRecordModel> tripRecordModelTableView = new TableView<>();

    public VBox form(){
        VBox vBox = new VBox();

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(
                new Label("Your Name"),
                new TextField(),
                new Label("Your Username"),
                new TextField(),
                new Label("Your Password"),
                new PasswordField(),
                new Label("Confirm Password"),
                new PasswordField(),
                new Button("REGISTER"));

        return vBox;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TLC UP 1.1");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 250, Color.WHITE);

        MenuBar menubar = new MenuBar();
        root.setTop(menubar);

        Menu fileMenu = new Menu("File");
        MenuItem openCSVFile = new MenuItem("Open Project       Ctrl+Shift+o");
        MenuItem closeApplication = new MenuItem("Exit");
        closeApplication.setOnAction(e -> Platform.exit());
        fileMenu.getItems().addAll(openCSVFile, new SeparatorMenuItem(), closeApplication);
        Menu viewMenu = new Menu("View");
        CheckMenuItem check1 = new CheckMenuItem("Editor");
        check1.setSelected(true);
        CheckMenuItem check2 = new CheckMenuItem("Line Number");
        check2.setSelected(true);
        viewMenu.getItems().addAll(check1, check2, new SeparatorMenuItem());

        Menu toolbar = new Menu("Toolbar");
        toolbar.getItems().addAll(
                new CheckMenuItem("File"),
                new CheckMenuItem("Run"),
                new CheckMenuItem("Debug")
        );
        viewMenu.getItems().add(toolbar);
        menubar.getMenus().addAll(fileMenu, viewMenu);

        VBox applicationMiddle = new VBox();
        applicationMiddle.setStyle("-fx-background-color: yellow;");
        applicationMiddle.getChildren().add(SingleTripRecordViewUI.generateUI());
        root.setCenter(tripRecordModelTableView);

        root.setBottom(applicationMiddle);

        openCSVFile.setOnAction(actionEvent -> {
            System.out.println("Clicked");
            FileChooser csvFileChooser = new FileChooser();
            csvFileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
            File csvFile = csvFileChooser.showOpenDialog(primaryStage);
            try {
                CSVReader reader = new CSVReader(new FileReader(csvFile));
                String[] columnsArray;
                columnsArray = reader.readNext();
                boolean proceed = ReadTripRecordModel.checkColumns(columnsArray);
                if (proceed) {
                    int columnId = 1;
                    while ((columnsArray = reader.readNext()) != null) {
                        ReadTripRecordModel readTripRecordModel = new ReadTripRecordModel(
                                columnId,
                                columnsArray[0], columnsArray[1], columnsArray[2],
                                columnsArray[3], columnsArray[4], columnsArray[5],
                                columnsArray[6], columnsArray[7], columnsArray[8],
                                columnsArray[9], columnsArray[10], columnsArray[11],
                                columnsArray[12], columnsArray[13], columnsArray[14]);
                        readTripRecordModelObservableList.add(readTripRecordModel);
                        columnId++;

                    }
                    ReadTripRecordModel.createColumnsWithLoadData(readTripRecordModelObservableList, primaryStage);
                    if (Bindings.isEmpty(tripRecordModelTableView.getItems()).get()) {

                    }
                    tripRecordModelTableView.setRowFactory(tv -> new TableRow<>() {
                        @Override
                        public void updateItem(ReadTripRecordModel tripRecord, boolean empty) {
                            super.updateItem(tripRecord, empty);
                            if (tripRecord == null) {
                                setStyle("-fx-background-color: #701212FF;");
                            } else if (Validate.validateRow(tripRecord)) {
                                setStyle("-fx-background-color: #FF0000FF;");
                            } else {
                                setStyle("-fx-background-color: #00D0F6FF;");
                            }
                        }
                    });
                } else {
                    Alert csvFileLoadingErrorAlertBox = new Alert(Alert.AlertType.ERROR);
                    csvFileLoadingErrorAlertBox.setTitle("Error Reading Trip Records");
                    csvFileLoadingErrorAlertBox.setHeaderText("Missing Column Error");
                    csvFileLoadingErrorAlertBox.setContentText("""
                            File """ + csvFile.getName() + """
                             is missing one or more columns.
                            
                            Please download Trip Record CSV Spec(csv) for correct formatting.
                            https://www1.nyc.gov/assets/tlc/downloads/xls/csv_spec_November2018-FINAL.XLS""");

                    csvFileLoadingErrorAlertBox.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

                    csvFileLoadingErrorAlertBox.show();
                }
            } catch (CsvValidationException | IOException e) {
                e.printStackTrace();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}