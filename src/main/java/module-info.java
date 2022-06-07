module com.tlc.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires opencsv;


    opens com.tlc.app to javafx.fxml;
    exports com.tlc.app;
    exports com.tlc.app.model;
}