package ru.mirea.task6.opt1;

public class Testing {
    public static void main(String[] args) {
        Nameable caracas = new Animal("Caracas");
        Nameable jupiter = new Planet("Jupiter");

        Car cadillac = new Car();
        Smartphone huawei = new Smartphone();

        cadillac.setBrand("Cadillac");
        huawei.setModel("Huawei P50");

        System.out.print("The kind of the animal: " + caracas.getName() +
                         "\nThe brand of the car: " + cadillac.getName() +
                         "\nThe model of the smartphone: " + huawei.getName() +
                         "\nThe name of the planet: " + jupiter.getName());
    }
}
