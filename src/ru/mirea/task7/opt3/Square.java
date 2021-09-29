package ru.mirea.task7.opt3;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side)  {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return this.width;
    }

    public void setSide(double side)    {
        this.setLength(side);
        this.setWidth(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
    }

    @Override
    public String toString() {
        return ("The color of the square: " + this.color + "\nThe square is "
                + (this.filled ? "filled" : "not filled")
                + "\nThe side of the square: " + this.width
                + "\nThe area of the square: " + this.getArea()
                + "\nThe perimeter of the square: " + this.getPerimeter());
    }
}
