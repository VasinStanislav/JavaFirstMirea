module t14_5.t14_5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens t14_5.t14_5 to javafx.fxml;
    exports t14_5.t14_5;
}