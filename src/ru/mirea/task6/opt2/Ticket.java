package ru.mirea.task6.opt2;

public class Ticket implements Priceable{
    private float price;

    public Ticket(float price) {
        this.price = price;
    }

    public Ticket() {
        this(29.99f);
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price;
    }
}
