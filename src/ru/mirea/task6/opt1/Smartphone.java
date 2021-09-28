package ru.mirea.task6.opt1;

public class Smartphone implements Nameable{
    private String model;

    public Smartphone(String model) {
        this.model = model;
    }

    public Smartphone() {
        this("SM-A515F");
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return this.model;
    }
}
