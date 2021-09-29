package ru.mirea.task7.opt6;

import ru.mirea.task7.opt5.Movable;
import ru.mirea.task7.opt5.MovablePoint;

public class MovableRectangle implements Movable {
    private MovablePoint topLeft, bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        this.topLeft.moveUp();
        this.bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        this.topLeft.moveDown();
        this.bottomRight.moveDown();
    }

    @Override
    public void moveLeft(){
        this.topLeft.moveLeft();
        this.bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        this.topLeft.moveRight();
        this.bottomRight.moveRight();
    }

    @Override
    public String toString() {
        return ("The coordinates of the top left point: {" + this.topLeft.x + ", " + this.topLeft + "}" +
                "\nThe coordinates of the bottom right point: {" + this.bottomRight.x + ", " + this.bottomRight + "}" +
                "\nThe speed on the x-axis: " + this.bottomRight.xSpeed +
                "\nThe speed on the y-axis: " + this.bottomRight.ySpeed);
    }
}
