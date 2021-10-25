module t9.t9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens t9.t9 to javafx.fxml;
    exports t9.t9;
}