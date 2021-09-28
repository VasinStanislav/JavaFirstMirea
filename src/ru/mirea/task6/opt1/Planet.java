package ru.mirea.task6.opt1;

public class Planet implements Nameable{
    private String planetName;

    public Planet(String planetName) {
        this.planetName = planetName;
    }

    public Planet() {
        this("Earth");
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    @Override
    public String getName() {
        return this.planetName;
    }
}
