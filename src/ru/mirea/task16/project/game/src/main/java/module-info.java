module game.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens game.game to javafx.fxml;
    exports game.game;
}