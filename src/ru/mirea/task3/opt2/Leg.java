package ru.mirea.task3.opt2;

public class Leg extends Bones {
    private boolean inMovement;

    public Leg() {
        super();
        inMovement = false;
    }

    public boolean isInMovement() {
        return inMovement;
    }

    public boolean move()   {
        if (this.isBroken()) {
            return false;
        }
        else {
            this.inMovement = true;
            return true;
        }
    }

    public void stop() {
        this.inMovement = false;
    }

    @Override
    public void breakSomething() {
        super.breakSomething();
        this.stop();
    }

    @Override
    public String toString() {
        return ((!inMovement ? "Не в движении" : "В движении") +
                "\nНога " + (this.isBroken() ? "не " : "") + "в порядке");
    }
}
