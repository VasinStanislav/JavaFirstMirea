package t11_2.t11_2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class PosReaction extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label labelNorth = new Label("NORTH");
        Label labelWest = new Label("WEST");
        Label labelCenter = new Label("CENTER");
        Label labelEast = new Label("EAST");
        Label labelSouth = new Label("SOUTH");

        BorderPane.setAlignment(labelNorth, Pos.TOP_CENTER);
        BorderPane.setAlignment(labelWest, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(labelCenter, Pos.CENTER);
        BorderPane.setAlignment(labelEast, Pos.CENTER_LEFT);
        BorderPane.setAlignment(labelSouth, Pos.BOTTOM_CENTER);

        BorderPane root = new BorderPane(labelCenter, labelNorth, labelEast, labelSouth, labelWest);
        root.setPrefSize(500, 500);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //root.getChildren().add(new Label("It is moving!!!"));
                System.out.print("./");
            }
        };

        root.getCenter().addEventHandler(MouseEvent.MOUSE_ENTERED, eventHandler);
        root.getLeft().addEventHandler(MouseEvent.MOUSE_ENTERED, eventHandler);
        root.getRight().addEventHandler(MouseEvent.MOUSE_ENTERED, eventHandler);
        root.getTop().addEventHandler(MouseEvent.MOUSE_ENTERED, eventHandler);
        root.getBottom().addEventHandler(MouseEvent.MOUSE_ENTERED, eventHandler);
        Scene scene = new Scene(root);

        stage.setTitle("PosReaction");
        stage.setScene(scene);
        stage.show();
    }

}