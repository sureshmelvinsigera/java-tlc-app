module com.tlc.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tlc.app to javafx.fxml;
    exports com.tlc.app;
}