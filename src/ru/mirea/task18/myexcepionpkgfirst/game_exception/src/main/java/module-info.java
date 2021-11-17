module game_exception.game_exception {
    requires javafx.controls;
    requires javafx.fxml;


    opens game_exception.game_exception to javafx.fxml;
    exports game_exception.game_exception;
}