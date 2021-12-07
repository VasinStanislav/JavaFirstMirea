module t27.t27 {
    requires javafx.controls;
    requires javafx.fxml;


    opens t27.t27 to javafx.fxml;
    exports t27.t27;
}