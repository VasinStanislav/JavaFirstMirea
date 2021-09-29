package ru.mirea.task6.opt2;

public class Clothing implements Priceable{
    private float price;

    public Clothing(float price) {
        this.price = price;
    }

    public Clothing() {
        this(79.99f);
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price;
    }
}
