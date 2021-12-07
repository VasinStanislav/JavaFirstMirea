package t25.t25;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DecoratorPatternDemo extends Application {
    private static FlowPane root;

    public static FlowPane getRoot()    {
        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
        root = new FlowPane();

        ShapeDecorator shapeDecorator1 = new ShapeDecorator(ShapeTypes.CIRCLE);
        javafx.scene.shape.Circle shape1 = (javafx.scene.shape.Circle) shapeDecorator1.getFigure();
        shape1.setRadius(50.0);


        ShapeDecorator shapeDecorator2 = new ShapeDecorator(ShapeTypes.RECTANGLE);
        javafx.scene.shape.Rectangle shape2 = (javafx.scene.shape.Rectangle) shapeDecorator2.getFigure();
        shape2.setHeight(50.0);
        shape2.setWidth(100.0);

        root.setOrientation(Orientation.HORIZONTAL);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(shape1, shape2);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

enum ShapeTypes {
    CIRCLE,
    RECTANGLE
}

interface Shape  {
    void draw();
}

class Circle implements Shape   {
    public javafx.scene.shape.Shape shape;

    @Override
    public void draw() {
        shape = new javafx.scene.shape.Circle();
    }

    public javafx.scene.shape.Shape getShape()  {
        return shape;
    }
}

class Rectangle implements Shape {
    public javafx.scene.shape.Shape shape;

    @Override
    public void draw() {
        shape = new javafx.scene.shape.Rectangle();
    }

    public javafx.scene.shape.Shape getShape()  {
        return shape;
    }
}

class ShapeDecorator implements Shape   {
    public Shape shape;
    private javafx.scene.shape.Shape figure;
    private final ShapeTypes shapeType;

    ShapeDecorator(ShapeTypes shapeType)    {
        this.shapeType = shapeType;
        switch (shapeType) {
            case CIRCLE -> shape = new Circle();
            case RECTANGLE -> shape = new Rectangle();
            default -> {}
        }
        draw();
    }

    public javafx.scene.shape.Shape getFigure() {
        return figure;
    }

    @Override
    public void draw() {
        switch (shapeType) {
            case CIRCLE -> figure = new javafx.scene.shape.Circle();
            case RECTANGLE -> figure = new javafx.scene.shape.Rectangle();
            default -> {}
        }
    }
}

class RedShapeDecorator extends ShapeDecorator  {
    public Shape shape;

    RedShapeDecorator(ShapeTypes shapeType) {
        super(shapeType);
        switch (shapeType) {
            case CIRCLE -> shape = new Circle();
            case RECTANGLE -> shape = new Rectangle();
            default -> {}
        }
        draw();
    }

    public void setRedBorder()  {

    }

    @Override
    public void draw() {
        shape.draw();
    }
}

