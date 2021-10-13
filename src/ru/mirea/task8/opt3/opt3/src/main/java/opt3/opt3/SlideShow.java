package opt3.opt3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class SlideShow extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        List<String> unnamedParams = getParameters().getUnnamed();
        String path = new String();
        for (String param: unnamedParams){
            path = param;
        }
        File file = new File(path);
        String picturePath = file.toURI().toURL().toString();
        Image image = new Image(picturePath);

        ImageView imView = new ImageView();
        imView.setImage(image);
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 700, 500);
        scene.setFill(Color.LIME);
        HBox box = new HBox();
        box.getChildren().add(imView);
        root.getChildren().add(box);
        stage.setTitle("What a turn-up!");
        root.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        stage.show();
    }
}
