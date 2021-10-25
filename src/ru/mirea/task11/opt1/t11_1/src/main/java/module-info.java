module t11_1.t11_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens t11_1.t11_1 to javafx.fxml;
    exports t11_1.t11_1;
}