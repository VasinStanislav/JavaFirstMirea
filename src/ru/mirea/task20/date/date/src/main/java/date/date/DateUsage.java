package date.date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUsage extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss");
        Date startingDate = new Date();

        Text text = new Text("Демонстрация работы с датой и временем\n" + dateFormat.format(startingDate));
        text.setFont(Font.font("Verdana", 20));
        text.setFill(Color.CHOCOLATE);


        Text curDate = new Text();
        curDate.setFont(Font.font("Verdana", 20));
        curDate.setFill(Color.CHOCOLATE);

        Text timeDiff = new Text();
        timeDiff.setFont(Font.font("Verdana", 12));
        timeDiff.setFill(Color.BLACK);

        Button getNewDateBtn = new Button("Получить дату");

        StackPane root = new StackPane();
        StackPane.setAlignment(text, Pos.TOP_CENTER);
        StackPane.setMargin(text, new Insets(20.0, 0.0, 0.0, 0.0));
        StackPane.setAlignment(getNewDateBtn, Pos.CENTER);
        StackPane.setAlignment(curDate, Pos.BOTTOM_CENTER);
        StackPane.setMargin(curDate, new Insets(0.0, 0.0, 20.0, 0.0));
        StackPane.setAlignment(timeDiff, Pos.BOTTOM_LEFT);
        root.getChildren().addAll(text, getNewDateBtn, curDate, timeDiff);
        Scene scene = new Scene(root);

        getNewDateBtn.setOnAction(actionEvent -> {
            Date currentDate = new Date();

            long time = currentDate.getTime() - startingDate.getTime();
            long seconds = TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS);
            long minutes = seconds/60;
            seconds = seconds%60;

            curDate.setText(dateFormat.format(currentDate));
            timeDiff.setText("Время работы программы: " + minutes + "m " + seconds + "s");
        });

        stage.setTitle("Использование даты и времени");
        stage.setScene(scene);
        stage.setHeight(500.0);
        stage.setWidth(500.0);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}