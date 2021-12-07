module t25.t25 {
    requires javafx.controls;
    requires javafx.fxml;


    opens t25.t25 to javafx.fxml;
    exports t25.t25;
}