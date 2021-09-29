package ru.mirea.task7.opt5;

public class MovablePoint implements Movable {
    public int x, y, xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        this.y++;
    }

    @Override
    public void moveDown() {
        this.y--;
    }

    @Override
    public void moveLeft() {
        this.x--;
    }

    @Override
    public void moveRight() {
        this.x++;
    }

    @Override
    public String toString() {
        return ("The coordinates of the point: {" + this.x + ", " + this.y + "}" +
                "\nThe speed on the x-axis: " + this.xSpeed +
                "\nThee speed on the y-axis: " + this.ySpeed);
    }
}
