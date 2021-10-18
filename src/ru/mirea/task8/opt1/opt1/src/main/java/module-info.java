module opt1.opt1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    //requires rt;


    opens opt1.opt1 to javafx.fxml;
    exports opt1.opt1;
}