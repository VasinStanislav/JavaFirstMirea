package ru.mirea.task3.opt2;

public class Leg {
    private boolean broken;
    private boolean inMovement;

    public Leg() {
        this.broken = false;
        this.broken = false;
    }

    public boolean isBroken() {
        return broken;
    }

    public boolean isInMovement() {
        return inMovement;
    }

    public void breakLeg() {
        this.broken = true;
        this.stop();
    }

    public boolean move()   {
        if (broken) {
            return false;
        }
        else {
            this.inMovement = true;
            return true;
        }
    }

    public void stop()   {
        this.inMovement = false;
    }
}
