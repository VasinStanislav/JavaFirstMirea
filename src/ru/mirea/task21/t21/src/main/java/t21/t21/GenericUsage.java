package t21.t21;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class GenericUsage extends Application {
    private static final HashMap<KeyCode, Boolean> keys = new HashMap<>();

    @Override
    public void start(Stage stage) throws IOException{
        BorderPane root = new BorderPane();
        Button wKey = new Button("W");
        Button aKey = new Button("A");
        Button sKey = new Button("S");
        Button dKey = new Button("D");
        Label label = new Label("");

        wKey.setPrefSize(50.0, 50.0);
        aKey.setPrefSize(50.0, 50.0);
        sKey.setPrefSize(50.0, 50.0);
        dKey.setPrefSize(50.0, 50.0);

        BorderPane.setAlignment(wKey, Pos.CENTER);
        root.setTop(wKey);
        BorderPane.setAlignment(aKey, Pos.CENTER);
        root.setLeft(aKey);
        root.setCenter(sKey);
        BorderPane.setAlignment(dKey, Pos.CENTER);
        root.setRight(dKey);
        BorderPane.setAlignment(label, Pos.TOP_CENTER);
        BorderPane.setMargin(label, new Insets(0.0, 10.0, 0.0, 0.0));
        root.setBottom(label);

        Scene scene = new Scene(root, 500.0, 500.0);

        scene.setOnKeyPressed(keyEvent->keys.put(keyEvent.getCode(), true));
        scene.setOnKeyReleased(keyEvent->keys.put(keyEvent.getCode(), false));

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (isPressed(KeyCode.W))  {
                    label.setText("W is being pressed");
                } else if (isPressed(KeyCode.S))    {
                    label.setText("S is being pressed");
                } else if (isPressed(KeyCode.D))    {
                    label.setText("D is being pressed");
                } else if (isPressed(KeyCode.A))    {
                    label.setText("A is being pressed");
                } else  {
                    label.setText("");
                }
            }
        };
        timer.start();

        stage.setScene(scene);
        stage.setTitle("Generic usage in my game");
        stage.show();
    }

    public static boolean isPressed(KeyCode key)   {
        return keys.getOrDefault(key, false);
    }

    public static void main(String[] args) {
        launch();
    }
}