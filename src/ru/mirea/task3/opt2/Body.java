package ru.mirea.task3.opt2;

public class Body extends Bones{
    private boolean fused;

    public Body() {
        super();
        this.fused = false;
    }

    public boolean isFused() {
        return fused;
    }

    public boolean bend() {
        if (this.isBroken())    {
            return false;
        }
        this.fused = true;
        return true;
    }

    public boolean straightenBack() {
        if (this.isBroken())    {
            return false;
        }
        this.fused = false;
        return true;
    }

    @Override
    public String toString() {
        return ("Туловище " + (this.isBroken() ? "не " : "") + "в порядке" +
                "\nТуловище " + (this.fused ? "согнуто" : "не согнуто"));
    }
}
