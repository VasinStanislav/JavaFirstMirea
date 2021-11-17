package game.game;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameEngine extends Application {
    private final Image IMAGE = new Image("file:src/ru/mirea/mygamepkg/game/src/main/resources/game/sprites/Semen.png");
    private static final int COUNT = 4;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 32;
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1350.0, 645.30115335325);

        String menuImgPath = "file:src/ru/mirea/mygamepkg/game/src/main/resources/game/sprites/KOUD_menu_pic.jpg";
        Image menuImage = new Image(menuImgPath);
        ImageView menuImgView = new ImageView(menuImage);
        menuImgView.setFitHeight(645.30115335325);
        menuImgView.setFitWidth(1350.0);

        final ImageView imageView = new ImageView(IMAGE);
        imageView.setFitHeight(128);
        imageView.setFitWidth(128);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        final Animation animation = new SpriteAnimation(imageView, Duration.millis(500.0),
                COUNT, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);

        root.getChildren().add(menuImgView);

        MenuItem newGame = new MenuItem("НОВАЯ ИГРА");
        MenuItem options = new MenuItem("НАСТРОЙКИ");
        MenuItem exitGame = new MenuItem("ВЫХОД");
        SubMenu mainMenu = new SubMenu(newGame, options, exitGame);

        MenuItem sound = new MenuItem("ЗВУК");
        MenuItem video = new MenuItem("ВИДЕО");
        MenuItem keys = new MenuItem("УПРАВЛЕНИЕ");
        MenuItem optionsBack = new MenuItem("НАЗАД");
        SubMenu optionsMenu = new SubMenu(sound, video, keys, optionsBack);

        MenuBox menuBox = new MenuBox(mainMenu);

        newGame.setOnMouseClicked(mouseEvent -> {
            menuBox.removeSubMenu();
            FadeTransition ft = new FadeTransition(Duration.seconds(1), menuBox);
            if (menuBox.isVisible())    {
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                menuBox.setVisible(false);
            }
            root.getChildren().remove(0);
            scene.setFill(Color.BLACK);
            stage.setFullScreen(true);
        });
        options.setOnMouseClicked(mouseEvent -> menuBox.setSubMenu(optionsMenu));
        optionsBack.setOnMouseClicked(mouseEvent -> menuBox.setSubMenu(mainMenu));
        exitGame.setOnMouseClicked(mouseEvent -> System.exit(0));
        AtomicBoolean showed = new AtomicBoolean(false);
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE)   {
                FadeTransition ft = new FadeTransition(Duration.seconds(1), menuBox);
                if (!menuBox.isVisible() && !showed.get())   {
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    menuBox.setVisible(true);
                    showed.set(true);
                }
            }
        });

        root.getChildren().add(menuBox);

        stage.setWidth(1350.0);
        stage.setHeight(645.30115335325);
        stage.setResizable(false);
        stage.setTitle("KNOTUD: menu");
        stage.setScene(scene);
        stage.show();
    }

    private static class MenuItem extends StackPane {
        public MenuItem(String name) {
            Rectangle bg = new Rectangle(200, 20, Color.WHITE);
            bg.setOpacity(0.5);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            this.setAlignment(Pos.CENTER);
            this.getChildren().addAll(bg, text);
            FillTransition st = new FillTransition(Duration.seconds(0.5), bg);
            this.setOnMouseEntered(event->  {
                st.setFromValue(Color.DARKGRAY);
                st.setToValue(Color.DARKGOLDENROD);
                st.setCycleCount(Animation.INDEFINITE);
                st.setAutoReverse(true);
                st.play();
            });
            setOnMouseExited(event->    {
                st.stop();
                bg.setFill(Color.WHITE);
            });
        }
    }

    private static class MenuBox extends Pane   {
        static SubMenu subMenu;

        public MenuBox(SubMenu subMenu) {
            MenuBox.subMenu = subMenu;

            setVisible(false);
            Rectangle bg = new Rectangle(1350.0, 645.30115335325, Color.LIGHTBLUE);
            bg.setOpacity(0.4);
            getChildren().addAll(bg, subMenu);
        }

        public void setSubMenu(SubMenu subMenu) {
            getChildren().remove(MenuBox.subMenu);
            MenuBox.subMenu = subMenu;
            getChildren().add(MenuBox.subMenu);
        }

        public void removeSubMenu() {
            getChildren().remove(MenuBox.subMenu);
        }
    }

    private static class SubMenu extends VBox {
        public SubMenu(MenuItem...items) {
            this.setSpacing(15);
            this.setTranslateX(100);
            this.setTranslateY(50);
            for (MenuItem item: items)  {
                this.getChildren().add(item);
            }
        }
    }

    private static class SpriteAnimation extends Transition {
        private final ImageView imageView;
        private final int count;
        private final int offsetX;
        private final int offsetY;
        private final int width;
        private final int height;

        public SpriteAnimation(ImageView imageView, Duration duration,
                               int count, int offsetX, int offsetY,
                               int width, int height) {
            this.imageView = imageView;
            this.count = count;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.width = width;
            this.height = height;
            setCycleDuration(duration);
        }

        @Override
        protected void interpolate(double v) {
            final int index = Math.min((int)Math.floor(v*count), count-1);
            final int x = width + offsetX;
            final int y = index * height + offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
        }
    }
}

