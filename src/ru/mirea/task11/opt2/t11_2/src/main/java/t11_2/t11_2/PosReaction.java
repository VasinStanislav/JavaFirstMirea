package t11_2.t11_2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
                Alert alertWelcome = new Alert(Alert.AlertType.INFORMATION);
                alertWelcome.setTitle("Welcome!");

                if (mouseEvent.getX() >= (root.getWidth()/2.0 + root.getWidth()/4.0)) {
                    if (mouseEvent.getY() >= 4.0 * root.getHeight()/5.0) {
                        alertWelcome.setHeaderText("Добро пожаловать в зону Юга");
                    } else if (mouseEvent.getY() <= root.getHeight()/5.0)  {
                        alertWelcome.setHeaderText("Добро пожаловать в зону Севера");
                    } else  {
                        alertWelcome.setHeaderText("Добро пожаловать в зону Запада");
                    }
                } else if (mouseEvent.getX() <= (root.getWidth()/2.0 - root.getWidth()/4.0))    {
                    if (mouseEvent.getY() >= 4.0 * root.getHeight()/5.0) {
                        alertWelcome.setHeaderText("Добро пожаловать в зону Юга");
                    } else if (mouseEvent.getY() <= root.getHeight()/5.0)  {
                        alertWelcome.setHeaderText("Добро пожаловать в зону Севера");
                    } else  {
                        alertWelcome.setHeaderText("Добро пожаловать в зону Востока");
                    }
                } else  {
                    if (mouseEvent.getY() >= 4.0 * root.getHeight()/5.0) {
                        alertWelcome.setHeaderText("Добро пожаловать в зону Юга");
                    } else if (mouseEvent.getY() <= root.getHeight()/5.0)  {
                        alertWelcome.setHeaderText("Добро пожаловать в зону Севера");
                    } else  {
                        alertWelcome.setHeaderText("Добро пожаловать в зону Центра");
                    }
                }

                alertWelcome.showAndWait();
            }
        };

        root.addEventHandler(MouseEvent.MOUSE_MOVED, eventHandler);
        Scene scene = new Scene(root);

        stage.setTitle("PosReaction");
        stage.setScene(scene);
        stage.show();
    }

}