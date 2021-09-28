package ru.mirea.task3.opt2;

public class Human {
    Head head;
    Body body;
    Hand[] hands;
    Leg[] legs;

    private String name;
    private char gender;
    private int weight;
    private int height;
    private int age;

    public Human(String name, char gender, int weight, int height, int age) {
        this.head = new Head();
        this.body = new Body();
        hands = new Hand[2];
        for (int i = 0; i < hands.length; i++)  {
            hands[i] = new Hand();
        }
        legs = new Leg[2];
        for (int i = 0; i < legs.length; i++)  {
            legs[i] = new Leg();
        }
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public Human() {
        this("Steven", 'M', 70, 180, 21);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ("Имя: " + this.name +
                "\nПол: " + this.gender +
                "\nВозраст: " + this.age +
                "\nРост: " + this.height +
                "\nВес: " + this.weight +
                "\nСостояние левой ноги:\n" + this.legs[0] +
                "\nСостояние правой ноги:\n" + this.legs[1] +
                "\nСостояние туловища:\n" + this.body +
                "\nСостояние левой руки:\n" + this.hands[0] +
                "\nСостояние правой руки:\n" + this.hands[1] +
                "\nСостояние головы:\n" + this.head);
    }
}
