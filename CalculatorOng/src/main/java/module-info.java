module com.example.calculatorong {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculatorong to javafx.fxml;
    exports com.example.calculatorong;
}