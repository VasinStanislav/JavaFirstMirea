package t9.t9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class InteractiveGUIApp extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        AtomicInteger i = new AtomicInteger();
        AtomicInteger j = new AtomicInteger();
        AtomicReference<String> scorer = new AtomicReference<>("N/A");
        AtomicReference<String> winner = new AtomicReference<>("DRAW");
        Label labelResult = new Label("Result: " + i + " X " + j);
        Label labelLastScorer = new Label("Last Scorer: " + scorer);
        Label labelWinner = new Label("Winner: " + winner);
        Button buttonMadrid = new Button("Madrid"), buttonMilan = new Button("Milan");

        StackPane root = new StackPane();
        StackPane.setMargin(labelResult, new Insets(-140.0, 0.0, 0.0, 0.0));
        StackPane.setMargin(labelWinner, new Insets(140.0, 0.0, 0.0, 0.0));
        StackPane.setAlignment(buttonMilan, Pos.CENTER_LEFT);
        StackPane.setAlignment(buttonMadrid, Pos.CENTER_RIGHT);
        root.getChildren().addAll(labelResult, labelLastScorer, labelWinner,
                buttonMilan, buttonMadrid);

        buttonMilan.setOnAction(e -> {
            i.getAndIncrement();
            labelResult.setText("Result: " + i + " X " + j);
            scorer.set("Milan");
            labelLastScorer.setText("Last Scorer: " + scorer);
            int comparing = i.get() - j.get();
            if (comparing > 0) {
                winner.set("Milan");
            } else if (comparing < 0)    {
                winner.set("Madrid");
            } else {
                winner.set("DRAW");
            }
            labelWinner.setText("Winner: " + winner);
        });
        buttonMadrid.setOnAction(e -> {
            j.getAndIncrement();
            labelResult.setText("Result: " + i + " X " + j);
            scorer.set("Madrid");
            labelLastScorer.setText("Last Scorer: " + scorer);
            int comparing = i.get() - j.get();
            if (comparing > 0) {
                winner.set("Milan");
            } else if (comparing < 0)    {
                winner.set("Madrid");
            } else {
                winner.set("DRAW");
            }
            labelWinner.setText("Winner: " + winner);
        });

        Scene scene = new Scene(root, 250, 250);
        stage.setMinHeight(250);
        stage.setMinWidth(250);
        stage.setTitle("Current Match");
        stage.setScene(scene);
        stage.show();
    }
}


