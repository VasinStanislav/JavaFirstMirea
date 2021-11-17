package game_exception.game_exception;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class GameException extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = new AnchorPane();

        String path = "src/ru/mirea/task18/myexcepionpkgfirst/game_exception/src/main/resources/game_exception/game_exception/Semen1.png";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String newImPath = "file:";

        try {
            InputStream input = classLoader.getResourceAsStream(path);
            if (input == null)  {
                throw new IOException();
            }
            newImPath = input.toString();
        } catch (IOException e) {
            newImPath += path;
        }

        Image image = new Image(newImPath);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100.0);
        imageView.setFitWidth(100.0);
        root.getChildren().add(imageView);

        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        stage.setTitle("Knockin` on the unknown door");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
}