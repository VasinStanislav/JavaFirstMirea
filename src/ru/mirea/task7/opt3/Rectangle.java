package ru.mirea.task7.opt3;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.length * this.width;
    }

    @Override
    public double getPerimeter() {
        return 2 * this.length + 2 * this.width;
    }

    @Override
    public String toString() {
        return ("The color of the rectangle: " + this.color + "\nThe rectangle is "
                + (this.filled ? "filled" : "not filled")
                + "\nThe width of the rectangle: " + this.width
                + "\nThe length of the rectangle: " + this.length
                + "\nThe area of the rectangle: " + this.getArea()
                + "\nThe perimeter of the rectangle: " + this.getPerimeter());
    }
}
