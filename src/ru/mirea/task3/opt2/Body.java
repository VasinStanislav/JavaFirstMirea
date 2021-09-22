package ru.mirea.task3.opt2;

public class Body {
    private boolean fused;

    public Body() {
        this.fused = false;
    }

    public boolean isFused() {
        return fused;
    }

    public void bend() {
        this.fused = true;
    }
}
