package game.game;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class GameEngine extends Application {
    private final Image IMAGE = new Image("file:src/ru/mirea/task16/project/game/src/main/resources/game/sprites/Semen.png");
    private Character character;
    private final Map<KeyCode, Boolean> keysMap = new HashMap<>();
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 32;
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;

    public static void main(String[] args) {
        launch();
    }

    /*---------------------------------------------------"Движок" игры-----------------------------------------*/

    @Override
    public void start(Stage stage) throws IOException {
        AtomicReference<Date> start = new AtomicReference<>();
        File file = new File("duration.txt");
        FileWriter writer = new FileWriter(file.getName(), false);

        Pane root = new Pane();
        Scene scene = new Scene(root, 1350.0, 645.30115335325, Color.BLACK);

        String menuImgPath = "file:src/ru/mirea/task16/project/game/src/main/resources/game/sprites/KOUD_menu_pic.jpg";
        Image menuImage = new Image(menuImgPath);
        ImageView menuImgView = new ImageView(menuImage);
        menuImgView.setFitHeight(645.30115335325);
        menuImgView.setFitWidth(1350.0);

        final ImageView imageView = new ImageView(IMAGE);
        character = new Character(imageView);
        imageView.setFitHeight(128);
        imageView.setFitWidth(128);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

        Rectangle rectangle = new Rectangle();
        rectangle.setX(scene.getWidth()/2.0 - 200.0);
        rectangle.setY(0.75*scene.getHeight() - 40.0);
        rectangle.setWidth(400.0);
        rectangle.setHeight(80.0);
        Text text = new Text("НАЖМИТЕ SPACE");
        text.setFill(Color.AQUA);
        text.setX(scene.getWidth()/2.0 - 125.0);
        text.setY(0.75*scene.getHeight() + 10.0);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 28));

        root.getChildren().addAll(menuImgView, rectangle, text);

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
            start.set(new Date());

            menuBox.removeSubMenu();
            FadeTransition ft = new FadeTransition(Duration.seconds(1), menuBox);
            if (menuBox.isVisible())    {
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
                menuBox.setVisible(false);
            }
            root.getChildren().remove(0);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint(" ");
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            scene.setFill(Color.BLACK);

            root.getChildren().add(character);
            character.setTranslateX(100.0);
            character.setTranslateY(scene.getHeight()/2.0 - 128.0);

            scene.setOnKeyPressed(keyEvent->keysMap.put(keyEvent.getCode(), true));
            scene.setOnKeyReleased(keyEvent -> keysMap.put(keyEvent.getCode(), false));

            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    try(FileWriter wr = new FileWriter("duration.txt"))
                    {
                        long time = System.currentTimeMillis() - start.get().getTime();
                        long seconds = TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS);
                        long minutes = seconds/60;
                        seconds = seconds%60;

                        wr.write(minutes + "m " + seconds + "s");
                        wr.flush();
                    }
                    catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }

                    update();
                }
            };
            timer.start();
        });
        options.setOnMouseClicked(mouseEvent -> menuBox.setSubMenu(optionsMenu));
        optionsBack.setOnMouseClicked(mouseEvent -> menuBox.setSubMenu(mainMenu));
        exitGame.setOnMouseClicked(mouseEvent -> System.exit(0));
        AtomicBoolean showed = new AtomicBoolean(false);
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE)   {
                root.getChildren().remove(2);
                root.getChildren().remove(1);
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

    /*---------------------------------------------------Нажатие кнопки-----------------------------------------*/

    public boolean isPressed(KeyCode key)   {
        return keysMap.getOrDefault(key, false);
    }

    /*---------------------------------------------------Обновление анимации-----------------------------------------*/

    public void update()    {
        if (isPressed(KeyCode.W))  {
            character.animation.play();
            character.animation.setOffsetY(96);
            if (isPressed(KeyCode.SHIFT))   {
                character.moveY(-9);
            } else {
                character.moveY(-5);
            }
        } else if (isPressed(KeyCode.S))    {
            character.animation.play();
            character.animation.setOffsetY(0);
            if (isPressed(KeyCode.SHIFT))   {
                character.moveY(9);
            } else {
                character.moveY(5);
            }
        } else if (isPressed(KeyCode.D))    {
            character.animation.play();
            character.animation.setOffsetY(64);
            if (isPressed(KeyCode.SHIFT))   {
                character.moveX(9);
            } else {
                character.moveX(5);
            }
        } else if (isPressed(KeyCode.A))    {
            character.animation.play();
            character.animation.setOffsetY(32);
            if (isPressed(KeyCode.SHIFT))   {
                character.moveX(-9);
            } else {
                character.moveX(-5);
            }
        } else {
            character.animation.stop();
        }
    }

    /*---------------------------------------------------Класс ячейки меню-----------------------------------------*/

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

    /*---------------------------------------------------Класс меню-----------------------------------------*/

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

    /*---------------------------------------------------Класс подменю-----------------------------------------*/

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

    /*---------------------------------------------------Класс анимации-----------------------------------------*/

    private static class SpriteAnimation  extends Transition    {
        private final ImageView imageView;
        private final int count;
        private final int columns;
        private int offsetX;
        private int offsetY;
        private final int width;
        private final int height;

        public SpriteAnimation(
                ImageView imageView,
                Duration duration,
                int count, int columns,
                int offsetX, int offsetY,
                int width, int height
        )   {
            this.imageView = imageView;
            this.count = count;
            this.columns = columns;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.width = width;
            this.height = height;
            setCycleDuration(duration);
            setCycleCount(Animation.INDEFINITE);
            setInterpolator(Interpolator.LINEAR);
            this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        }

        public void setOffsetX(int x)   {
            this.offsetX = x;
        }

        public void setOffsetY(int y)   {
            this.offsetY = y;
        }

        protected void interpolate(double frac) {
            final int index = Math.min((int)Math.floor(count*frac), count-1);
            final int x = (index%columns)*width+offsetX;
            final int y = (index/columns)*height+offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
        }
    }

    /*---------------------------------------------------Класс игрока-----------------------------------------*/

    private static class Character extends FlowPane    {
        ImageView imageView;
        int count = 3;
        int columns = 3;
        int offsetX = 0;
        int offsetY = 0;
        int width = 32;
        int height = 32;

        SpriteAnimation animation;

        public Character(ImageView imageView) {
            this.imageView = imageView;
            this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
            animation = new SpriteAnimation(imageView, Duration.millis(200.0), count, columns, offsetX, offsetY, width, height);
            getChildren().add(imageView);
        }

        public void moveX(int x)    {
            boolean right = x > 0;
            for (int i = 0; i < Math.abs(x); i++) {
                if (right)  {
                    this.setTranslateX(this.getTranslateX() + 1);
                } else  {
                    this.setTranslateX(this.getTranslateX() - 1);
                }
            }
        }

        public void moveY(int y)    {
            boolean right = y > 0;
            for (int i = 0; i < Math.abs(y); i++) {
                if (right)  {
                    this.setTranslateY(this.getTranslateY() + 1);
                } else  {
                    this.setTranslateY(this.getTranslateY() - 1);
                }
            }
        }
    }

    /*---------------------------------------------------Конец-----------------------------------------*/
}

