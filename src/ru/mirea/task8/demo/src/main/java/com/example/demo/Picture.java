package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.List;

public class Picture extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Picture");
        List<String> unnamedParams = getParameters().getUnnamed();
        String url = new String();
        for (String param: unnamedParams){
            url = param;
        }
        Image image = new Image(url);
        ImageView imView = new ImageView(image);
        FlowPane root = new FlowPane();
        root.getChildren().addAll(imView);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
