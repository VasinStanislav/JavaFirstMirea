package t11_1.t11_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class GuessingGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Integer randNum = (int)(0.0 + Math.random()*20.0);

        Label label = new Label("Угадайте число от 0 до 20. У вас 3 попытки");
        Label labelTryAgain = new Label();
        Button button = new Button("Принять");
        TextField textField = new TextField();
        textField.setPrefColumnCount(3);

        AnchorPane.setTopAnchor(label, 10.0);
        AnchorPane.setLeftAnchor(label, 14.0);
        AnchorPane.setTopAnchor(labelTryAgain, 100.0);
        AnchorPane.setLeftAnchor(labelTryAgain, 106.0);
        AnchorPane.setTopAnchor(textField, 125.0);
        AnchorPane.setLeftAnchor(textField, 110.0);
        AnchorPane.setRightAnchor(textField, 110.0);
        AnchorPane.setBottomAnchor(button, 10.0);
        AnchorPane.setLeftAnchor(button, 80.0);
        AnchorPane.setRightAnchor(button, 80.0);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(label, labelTryAgain, button, textField);

        AtomicBoolean enough = new AtomicBoolean(false);
        AtomicInteger counter = new AtomicInteger(0);
        button.setOnAction(event -> {
            counter.getAndIncrement();
            int cnt = counter.get();
            if (cnt > 3) {
                enough.set(true);
            }

            if (!enough.get()) {
                if (textField.getText().equals(randNum.toString())) {
                    labelTryAgain.setText("");
                    Alert alertWin = new Alert(Alert.AlertType.INFORMATION, "You won! The right answer was " + randNum);
                    alertWin.setTitle("Guess the number");
                    alertWin.setHeaderText("Congratulations!");
                    alertWin.showAndWait();
                    enough.set(true);
                } else {
                    if (cnt == 3) {
                        labelTryAgain.setText("");
                        Alert alertLose = new Alert(Alert.AlertType.INFORMATION, "You lose! The right answer was " + randNum);
                        alertLose.setTitle("Guess the number");
                        alertLose.setHeaderText("Oops!");
                        alertLose.showAndWait();
                    } else {
                        labelTryAgain.setText("Try Again");
                    }
                }
            }
        });

        Scene scene = new Scene(root, 280, 250);
        primaryStage.setTitle("Guess the number");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(250);
        primaryStage.setMinWidth(280);
        primaryStage.setMaxWidth(280);
        primaryStage.show();
    }
}