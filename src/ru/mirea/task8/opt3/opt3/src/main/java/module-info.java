module opt3.opt3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    //requires rt;


    opens opt3.opt3 to javafx.fxml;
    exports opt3.opt3;
}