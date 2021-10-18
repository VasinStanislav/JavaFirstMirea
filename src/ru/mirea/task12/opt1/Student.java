package ru.mirea.task12.opt1;

public class Student {
    String iDNumber;
    String name;
    Double gPA;

    public Student() {
        this("\t20И0385", "Нечипоренко Олег", 5.0);
    }

    public Student(String iDNumber) {
        this(iDNumber, "Нечипоренко Олег", 5.0);
    }

    public Student(String name, Double gPA) {
        this("\t20И0385", name, gPA);
    }

    public Student(String iDNumber, String name, Double gPA) {
        this.iDNumber = iDNumber;
        this.name = name;
        this.gPA = gPA;
    }

    public String getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGPA() {
        return gPA;
    }

    public void setGPA(Double gPA) {
        this.gPA = gPA;
    }
}
