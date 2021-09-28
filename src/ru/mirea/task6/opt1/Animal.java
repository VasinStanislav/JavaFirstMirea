package ru.mirea.task6.opt1;

public class Animal implements Nameable{
    private String kind;

    public Animal(String kind) {
        this.kind = kind;
    }

    public Animal() {
        this("Brown Bear");
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String getName() {
        return this.kind;
    }
}
