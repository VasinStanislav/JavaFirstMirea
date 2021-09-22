package ru.mirea.task3.opt1;

public class Circle {
    private double radius;
    private boolean filled;

    public Circle(double radius, boolean filled) {
        this.radius = radius;
        this.filled = filled;
    }

    public Circle(double radius) {
        this(radius,false);
    }

    public Circle(boolean filled) {
        this(5.0, filled);
    }

    public Circle() {
        this(5.0, false);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getPerimeter()    {
        return(2*Math.PI*this.radius);
    }

    public double getArea() {
        return(Math.PI*Math.pow(this.radius, 2));
    }

    @Override
    public String toString() {
        return ("The radius of the circle: " + radius +
                "\nThe perimeter of the circle: " + this.getPerimeter() +
                "\nThe area of the circle: " + this.getArea() +
                "\nThe circle is" + (this.filled ? "" : " not") + " filled");
    }
}
