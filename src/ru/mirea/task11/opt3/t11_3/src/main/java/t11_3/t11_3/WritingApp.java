package t11_3.t11_3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WritingApp extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane root = new FlowPane(Orientation.VERTICAL);

        TextArea textArea = new TextArea("Здесь вы можете писать текст\n" +
                "Снизу вы можете выбрать шрифт и цвет текста");
        textArea.setPrefColumnCount(25);
        textArea.setPrefRowCount(10);

        ObservableList<String> colors = FXCollections.observableArrayList("Black", "Blue", "Red");
        ListView<String> colorsListView = new ListView<>(colors);
        MultipleSelectionModel<String> colorsSelectionModel = colorsListView.getSelectionModel();
        colorsSelectionModel.getSelectedItems().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> change) {
                int fInd = change.toString().lastIndexOf('[');
                int lInd = change.toString().lastIndexOf(']');
                String color = change.toString().substring(fInd+1, lInd);
                switch (color)  {
                    case "Red":
                        textArea.setStyle("-fx-text-fill: red ;");
                        break;
                    case "Black":
                        textArea.setStyle("-fx-text-fill: black ;");
                        break;
                    case "Blue":
                        textArea.setStyle("-fx-text-fill: blue ;");
                        break;
                    default:
                        break;
                }
            }
        });
        FlowPane.setMargin(colorsListView, new Insets(10.0, 0.0, 10.0, 0.0));
        colorsListView.setPrefSize(25.0, 75.0);

        ObservableList<String> fonts = FXCollections.observableArrayList("Times New Roman", "Arial", "Cambria");
        ListView<String> fontsListView = new ListView<>(fonts);
        MultipleSelectionModel<String> fontsSelectionModel = fontsListView.getSelectionModel();
        fontsSelectionModel.getSelectedItems().addListener(new ListChangeListener <String>(){
            @Override
            public void onChanged(Change<? extends String> change) {
                int fInd = change.toString().lastIndexOf('[');
                int lInd = change.toString().lastIndexOf(']');
                String font = change.toString().substring(fInd+1, lInd);
                textArea.setFont(new Font(font, 14));
            }
        });
        fontsListView.setPrefSize(25.0, 75.0);

        root.setPrefSize(400.0, 400.0);
        root.getChildren().addAll(textArea, colorsListView, fontsListView);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);
        stage.setTitle("Сочинение");
        stage.setScene(scene);
        stage.show();
    }

}