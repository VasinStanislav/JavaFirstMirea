package t14_5.t14_5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;

import java.util.*;

public class DrunkardStackUpgraded extends Application {
    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label labelHeader = new Label("Введите номера для карт в колодах игроков");
        Label labelP1 = new Label("Игрок №1");
        Label labelP2 = new Label("Игрок №2");

        TextField textP1 = new TextField();
        TextField textP2 = new TextField();
        textP1.setPrefColumnCount(5);
        textP2.setPrefColumnCount(5);

        Button buttonAccept = new Button("Принять");
        Button buttonGenerate = new Button("Сгенерировать");

        AnchorPane.setTopAnchor(labelHeader, 10.0);
        AnchorPane.setLeftAnchor(labelHeader, 15.0);
        AnchorPane.setRightAnchor(labelHeader, 15.0);

        AnchorPane.setTopAnchor(labelP1, 130.0);
        AnchorPane.setLeftAnchor(labelP1, 40.0);
        AnchorPane.setBottomAnchor(labelP1, 150.0);

        AnchorPane.setTopAnchor(labelP2, 130.0);
        AnchorPane.setRightAnchor(labelP2, 40.0);
        AnchorPane.setBottomAnchor(labelP2, 150.0);

        AnchorPane.setTopAnchor(textP1, 170.0);
        AnchorPane.setLeftAnchor(textP1, 40.0);
        AnchorPane.setBottomAnchor(textP1, 130.0);

        AnchorPane.setTopAnchor(textP2, 170.0);
        AnchorPane.setRightAnchor(textP2, 40.0);
        AnchorPane.setBottomAnchor(textP2, 130.0);

        AnchorPane.setLeftAnchor(buttonAccept, 40.0);
        AnchorPane.setBottomAnchor(buttonAccept, 50.0);

        AnchorPane.setRightAnchor(buttonGenerate, 40.0);
        AnchorPane.setBottomAnchor(buttonGenerate, 50.0);

        AnchorPane root = new AnchorPane(labelHeader, labelP1, labelP2, textP1, textP2);
        root.getChildren().addAll(buttonAccept, buttonGenerate);

        Scene scene = new Scene(root);
        stage.setTitle("Пьяница");

        List<String> unnamedParams = getParameters().getUnnamed();
        String path = "";
        for (String param: unnamedParams){
            path = param;
        }
        File file = new File(path);
        String iconPath = file.toURI().toURL().toString();
        Image icon = new Image(iconPath);
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.setMinHeight(380.0);
        stage.setMaxHeight(380.0);
        stage.setMinWidth(291.0);
        stage.show();

        /* --------------------------------------------- */

        buttonAccept.setOnAction(acceptEvent -> {
            StringBuilder txt1 = new StringBuilder(textP1.getText());
            StringBuilder txt2 = new StringBuilder(textP2.getText());
            String result = getGameResult(txt1, txt2);
            Alert alertResult = new Alert(Alert.AlertType.INFORMATION);
            alertResult.setTitle("Результат");
            alertResult.setHeaderText("Итог игры");
            if (Objects.equals(result, "botva"))  {
                alertResult.setContentText("Ботва!");
            }
            else {
                alertResult.setContentText("Победитель: " + result.substring(0, result.lastIndexOf(' ')) + "!" +
                        "\nКоличество ходов: " + result.substring(result.lastIndexOf(' ')));
            }
            alertResult.showAndWait();
        });


        buttonGenerate.setOnAction(generateEvent -> {
            String txt = getRandomText();
            txt = txt.substring(1, txt.length()-1);
            txt = txt.replace(",", "");
            String txt1, txt2;
            txt1 = txt.substring(0, txt.length()/2);
            txt2 = txt.substring(txt.length()/2+1);
            textP1.setText(txt1);
            textP2.setText(txt2);
        });
    }

    public String getGameResult(StringBuilder deck1, StringBuilder deck2) {
        Stack<Integer> firstPDeck  = new Stack<>();
        Stack<Integer> secondPDeck = new Stack<>();

        deck1.reverse();
        for (Character el: deck1.toString().toCharArray()) {
            if (el!=' ') {
                firstPDeck.push(((int) el - 48));
            }
        }

        deck2.reverse();
        for (Character el: deck2.toString().toCharArray()) {
            if (el!=' ') {
                secondPDeck.push(((int) el - 48));
            }
        }

        int counter = 0;

        Integer buf;
        while (!firstPDeck.empty() && !secondPDeck.empty() && counter<106) {
            if (firstPDeck.peek() == 9 && secondPDeck.peek() == 0)   {
                buf = secondPDeck.pop();
                if (secondPDeck.empty()) {
                    secondPDeck.push(firstPDeck.pop());
                } else  {
                    secondPDeck.add(secondPDeck.lastIndexOf(secondPDeck.firstElement()), firstPDeck.pop());
                }
                secondPDeck.add(secondPDeck.lastIndexOf(secondPDeck.firstElement()), buf);
            } else if(secondPDeck.peek() == 9 && firstPDeck.peek() == 0)   {
                firstPDeck.add(firstPDeck.lastIndexOf(firstPDeck.firstElement()), firstPDeck.pop());
                firstPDeck.add(firstPDeck.lastIndexOf(firstPDeck.firstElement()), secondPDeck.pop());
            } else if(firstPDeck.peek()>secondPDeck.peek()) {
                firstPDeck.add(firstPDeck.lastIndexOf(firstPDeck.firstElement()), firstPDeck.pop());
                firstPDeck.add(firstPDeck.lastIndexOf(firstPDeck.firstElement()), secondPDeck.pop());
            } else if(secondPDeck.peek()>firstPDeck.peek()){
                buf = secondPDeck.pop();
                if (secondPDeck.empty()) {
                    secondPDeck.push(firstPDeck.pop());
                } else  {
                    secondPDeck.add(secondPDeck.lastIndexOf(secondPDeck.firstElement()), firstPDeck.pop());
                }
                secondPDeck.add(secondPDeck.lastIndexOf(secondPDeck.firstElement()), buf);
            }
            counter++;
        }

        return (counter == 106 ? "botva" : ((secondPDeck.empty() ? "первый игрок " : "второй игрок ") + counter));
    }

    public static String getRandomText()    {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);
        return arr.toString();
    }
}