module com.pterapan.demoio {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.pterapan.demoio.model to com.google.gson;
    opens com.pterapan.demoio to javafx.fxml;
    exports com.pterapan.demoio;
    exports com.pterapan.demoio.model;
}