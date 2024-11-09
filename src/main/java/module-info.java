module com.example.Fuelconsumption1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.Fuelconsumption1 to javafx.fxml;
    exports com.example.Fuelconsumption1;
}