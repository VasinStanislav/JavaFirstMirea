package ru.mirea.task3.opt2;

public class Bones {
    private boolean broken;

    public Bones() {
        this.broken = false;
    }

    public boolean isBroken() {
        return broken;
    }

    public void breakSomething() {
        this.broken = true;
    }

    public void heal()  {
        this.broken = false;
    }
}
