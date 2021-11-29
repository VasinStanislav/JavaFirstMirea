module t21.t21 {
    requires javafx.controls;
    requires javafx.fxml;


    opens t21.t21 to javafx.fxml;
    exports t21.t21;
}