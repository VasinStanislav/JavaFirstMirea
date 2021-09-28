package ru.mirea.task3.opt2;

public class Head extends Bones{
    private int alpha, beta;

    public Head() {
        super();
        this.alpha = 0;
        this.beta = 0;
    }

    public int getX() {
        return alpha;
    }

    public int getY() {
        return beta;
    }

    public boolean turnUp() {
        if (this.isBroken() || this.alpha == 90) {
            return false;
        }
        this.alpha += 90;
        return true;
    }

    public boolean turnDown() {
        if (this.isBroken() || this.alpha == -90) {
            return false;
        }
        this.alpha += (-90);
        return true;
    }

    public boolean turnLeft() {
        if (this.isBroken() || this.beta == (-90)) {
            return false;
        }
        this.beta += (-90);
        return true;
    }

    public boolean turnRight() {
        if (this.isBroken() || this.beta == 90) {
            return false;
        }
        this.beta += 90;
        return true;
    }

    public boolean setFirstPosition() {
        if (this.isBroken()) {
            return false;
        }
        this.beta = 0;
        this.alpha = 0;
        return true;
    }

    @Override
    public String toString() {
        return ("Голова " + (this.isBroken() ? "не " : "") + "в порядке" +
                "\nУгол поворота головы относительно вертикали: " + this.beta + "°" +
                "\nУгол поворота головы относительно горизонтали: " + this.alpha + "°");
    }
}
