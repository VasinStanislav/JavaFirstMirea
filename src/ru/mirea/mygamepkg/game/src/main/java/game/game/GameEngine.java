package game.game;

import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;

public class GameEngine extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = new AnchorPane();

        Image image = new Image("file:src/ru/mirea/mygamepkg/game/src/main/resources/game/sprites/Semen1.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200.0);
        imageView.setFitWidth(200.0);
        root.getChildren().add(imageView);

        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        stage.setTitle("Knockin` on the unknown door");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }

    private class SpriteAnimation extends Transition {
        private final ImageView imageView;
        private final int count;
        private final int offsetX;
        private final int offsetY;
        private final int width;
        private final int height;

        public SpriteAnimation(ImageView imageView, Duration duration, int count, int offsetX, int offsetY, int width, int height) {
            this.imageView = imageView;
            this.count = count;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.width = width;
            this.height = height;
            setCycleDuration(duration);
        }

        @Override
        protected void interpolate(double v) {
            final int index = Math.min((int)Math.floor(v*count), count-1);
            final int x = width + offsetX;
            final int y = height + offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
        }
    }
}

