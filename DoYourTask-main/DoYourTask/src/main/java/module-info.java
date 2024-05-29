module com.example.doyourtask {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.doyourtask to javafx.fxml;
    exports com.example.doyourtask;
    exports com.example.doyourtask.controller;
    opens com.example.doyourtask.controller to javafx.fxml;
    exports com.example.doyourtask.model;
}