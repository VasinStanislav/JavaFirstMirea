package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ShowShapes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Ellipse ellipse = new Ellipse(300.0f, 300.0f, 100.0f, 50.0f);
        ellipse.setFill(Color.BURLYWOOD);
        Group root1 = new Group(ellipse);
        Scene scene1 = new Scene(root1);
        primaryStage.setScene(scene1);

        /*Line line = new Line(200.0f, 200.0f, 250.0f, 250.0f);
        line.setFill(Color.BLACK);
        Group root2 = new Group(line);
        Scene scene2 = new Scene(root2);
        primaryStage.setScene(scene2);*/

        primaryStage.setTitle("My Pretty Shapes");
        primaryStage.show();
    }
}
