package ru.mirea.task6.opt2;

public class Furniture implements Priceable{
    private float price;

    public Furniture(float price) {
        this.price = price;
    }

    public Furniture() {
        this(299.99f);
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price;
    }
}
