package ru.mirea.task3.opt2;

public class Hand extends Bones {
    private boolean handing;

    public Hand() {
        super();
        this.handing = false;
    }

    public boolean isHanding() {
        return handing;
    }

    public boolean grab()   {
        if (this.isBroken()) {
            return false;
        }
        else    {
            this.handing = true;
            return true;
        }
    }

    public boolean open() {
        if (this.isBroken()) {
            return false;
        } else {
            this.handing = false;
            return true;

        }
    }

    @Override
    public String toString() {
        return ("Рука " + (this.isBroken() ? "не " : "") + "в порядке" +
                "\nРука " + (this.handing ? "сжата" : "разжата"));
    }
}
