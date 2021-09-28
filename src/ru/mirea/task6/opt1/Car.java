package ru.mirea.task6.opt1;

public class Car implements Nameable{
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public Car() {
        this("Lada");
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getName() {
        return this.brand;
    }
}
