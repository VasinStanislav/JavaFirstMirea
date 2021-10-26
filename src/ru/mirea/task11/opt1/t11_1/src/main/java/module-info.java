module t11_1.t11_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens t11_1.t11_1 to javafx.fxml;
    exports t11_1.t11_1;
}