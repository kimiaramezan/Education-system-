module com.example.demo12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo12 to javafx.fxml;
    exports com.example.demo12;
    exports com.example.demo12.Controller;
    opens com.example.demo12.Controller to javafx.fxml;
    exports com.example.demo12.Model;
    opens com.example.demo12.Model to javafx.fxml;


}