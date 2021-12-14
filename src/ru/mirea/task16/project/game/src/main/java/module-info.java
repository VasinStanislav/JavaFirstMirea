module game.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;
    requires org.junit.jupiter.api;


    opens game.game to javafx.fxml;
    exports game.game;
}