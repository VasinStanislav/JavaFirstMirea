package opt1.opt1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class ShowShapes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        for (int i = 0; i<20; i++) {
            Shape figure = getRandomShape();
            Group f = new Group(figure);
            root.getChildren().add(f);
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setHeight(900.0);
        primaryStage.setWidth(1600.0);
        primaryStage.setTitle("My Pretty Shapes");
        primaryStage.show();
    }

    public static float getRandomX()    {
        float a = 0.0f, b = 1600.0f;
        float randomX = a + (float)(Math.random()*b);
        return randomX;
    }

    public static float getRandomY()    {
        float a = 0.0f, b = 900.0f;
        float randomY = a + (float)(Math.random()*b);
        return randomY;
    }

    public static float getRandomValue()    {
        return getRandomValue(200.0f);
    }

    public static float getRandomValue(float limit)    {
        float a = 0.0f, b = limit;
        float randomValue = a + (float)(Math.random()*b);
        return randomValue;
    }

    public static Color getRandomColor()    {
        int R = 0, G = 0, B = 0;
        do  {
            R = (int)(Math.random()*255);
            G = (int)(Math.random()*255);
            B = (int)(Math.random()*255);
        } while (R == 255 && G == 255 && B == 255);
        Color color = Color.rgb(R, G, B);
        return color;
    }

    public static Shape getRandomShape()    {
        int amountOfShapes = 11;
        int shapeType = (int)(Math.random()*amountOfShapes);

        Shape figure;
        switch (shapeType)  {
            case 1:
                figure = new Line(getRandomX(), getRandomY(),
                        getRandomValue(), getRandomValue());
                break;
            case 2:
                figure = new Rectangle(getRandomX(), getRandomY(),
                        getRandomValue(), getRandomValue());
                break;
            case 3:
                Rectangle r = new Rectangle(getRandomX(), getRandomY(),
                        getRandomValue(), getRandomValue());
                r.setArcHeight(getRandomValue()/10.0f);
                r.setArcWidth(getRandomValue()/10.0f);
                figure = (Shape)r;
                break;
            case 4:
                figure = new Circle(getRandomX(), getRandomY(),
                        getRandomValue()/2.0f);
                break;
            case 5:
                figure = new Ellipse(getRandomX(), getRandomY(),
                        getRandomValue()/2.0f, getRandomValue()/2.0f);
                break;
            case 6:
                Polygon polygon = new Polygon();
                float centerX = getRandomX();
                float centerY = getRandomY();
                int amountOfAngles = (int)(getRandomValue(20.0f));
                float radius = getRandomValue()/2.0f;
                Double[] coordinates = new Double[amountOfAngles*2];
                int j = 0, k = 0;
                for (int i = 0; i < coordinates.length; i++)    {
                    if (i%2 == 0)   {
                        coordinates[i] = centerX + radius*Math.cos(90 + 2*180*j/amountOfAngles);
                        j++;
                    }
                    else    {
                        coordinates[i] = centerY + radius*Math.sin(90 + 2*180*k/amountOfAngles);
                        k++;
                    }
                }
                polygon.getPoints().addAll(coordinates);
                figure = (Shape)polygon;
                break;
            case 7:
                figure = new CubicCurve(getRandomX(), getRandomY(), getRandomX(), getRandomY(),
                        getRandomX(), getRandomY(), getRandomX(), getRandomY());
                break;
            case 8:
                figure = new QuadCurve(getRandomX(), getRandomY(), getRandomX(), getRandomY(),
                        getRandomX(), getRandomY());
                break;
            case 9:
                figure = new Arc(getRandomX(), getRandomY(), getRandomValue(), getRandomValue(),
                        getRandomValue(360.0f), getRandomValue(360.0f));
                break;
            default:
                figure = new Line();
                break;
        }

        figure.setFill(getRandomColor());
        return figure;
    }
}
