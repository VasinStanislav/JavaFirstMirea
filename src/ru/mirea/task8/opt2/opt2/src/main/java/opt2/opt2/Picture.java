package opt2.opt2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class Picture extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Picture");

        List<String> unnamedParams = getParameters().getUnnamed();
        String path = new String();
        for (String param: unnamedParams){
            path = param;
        }
        File file = new File(path);
        String picturePath = file.toURI().toURL().toString();

        Image image = new Image(picturePath);
        ImageView imView = new ImageView(image);
        FlowPane root = new FlowPane();
        root.getChildren().addAll(imView);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}

