package ru.mirea.task3.opt2;

public class Hand {
    private boolean handing;
    private boolean broken;

    public Hand() {
        this.broken = false;
        this.handing = false;
    }

    public boolean isHanding() {
        return handing;
    }

    public boolean isBroken() {
        return broken;
    }

    public void breakHand() {
        broken = true;
    }

    public boolean grab()   {
        if (broken) {
            return false;
        }
        else    {
            this.handing = true;
            return true;
        }
    }

    public boolean open() {
        if (broken) {
            return false;
        } else {
            this.handing = false;
            return true;

        }
    }
}
