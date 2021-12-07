module date.date {
    requires javafx.controls;
    requires javafx.fxml;


    opens date.date to javafx.fxml;
    exports date.date;
}