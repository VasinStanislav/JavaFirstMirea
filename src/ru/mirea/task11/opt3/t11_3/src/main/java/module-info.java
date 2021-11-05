module t11_3.t11_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens t11_3.t11_3 to javafx.fxml;
    exports t11_3.t11_3;
}