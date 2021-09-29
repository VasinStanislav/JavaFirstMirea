package ru.mirea.task7.opt5;

public class MovableCircle implements Movable{
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        this.center.moveUp();
    }

    @Override
    public void moveDown() {
        this.center.moveDown();
    }

    @Override
    public void moveLeft() {
        this.center.moveLeft();
    }

    @Override
    public void moveRight() {
        this.center.moveRight();
    }

    @Override
    public String toString() {
        return ("The coordinates of the center of circle: {" + this.center.x + ", " + this.center.y + "}" +
                "\nThe speed on the x-axis: " + this.center.xSpeed +
                "\nThe speed on the y-axis: " + this.center.ySpeed +
                "\nThe radius of the circle: " + this.radius);
    }
}
