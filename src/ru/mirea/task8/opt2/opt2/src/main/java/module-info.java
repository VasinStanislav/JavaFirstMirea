module opt2.opt2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    //requires rt;


    opens opt2.opt2 to javafx.fxml;
    exports opt2.opt2;
}