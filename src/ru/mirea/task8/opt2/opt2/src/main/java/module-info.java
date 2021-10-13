module opt2.opt2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens opt2.opt2 to javafx.fxml;
    exports opt2.opt2;
}