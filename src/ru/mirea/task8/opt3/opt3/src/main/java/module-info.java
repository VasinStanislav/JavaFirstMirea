module opt3.opt3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens opt3.opt3 to javafx.fxml;
    exports opt3.opt3;
}