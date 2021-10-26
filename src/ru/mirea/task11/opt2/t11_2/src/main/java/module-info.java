module t11_2.t11_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens t11_2.t11_2 to javafx.fxml;
    exports t11_2.t11_2;
}