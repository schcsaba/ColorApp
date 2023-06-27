module csaba.colorapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens csaba.colorapp to javafx.fxml;
    exports csaba.colorapp;
    exports csaba.colorapp.controller;
    opens csaba.colorapp.controller to javafx.fxml;
}