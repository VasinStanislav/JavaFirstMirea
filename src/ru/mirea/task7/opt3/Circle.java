package ru.mirea.task7.opt3;

public class Circle extends Shape {
    protected double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (Math.PI * Math.pow(this.radius, 2));
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * this.radius);
    }

    @Override
    public String toString() {
        return ("The color of the circle: " + this.color + "\nThe circle is "
                + (this.filled ? "filled" : "not filled")
                + "\nThe radius of the circle: " + this.radius
                + "\nThe area of the circle: " + this.getArea()
                + "\nThe perimeter of the circle: " + this.getPerimeter());
    }
}
