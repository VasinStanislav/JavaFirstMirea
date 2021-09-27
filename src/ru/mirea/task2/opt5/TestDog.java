package ru.mirea.task2.opt5;

import ru.mirea.task2.opt4.Dog;
import java.util.Scanner;

public class TestDog {
    public static void main(String[] args) {
        Dog[] puppies = new Dog[3];
        for (int i = 0; i< puppies.length; i++)    {
            puppies[i] = new Dog("", i+1);
        }

        puppies[0].setName("Бобик");
        puppies[1].setName("Макс");
        puppies[2].setName("Кегля");

        System.out.println("Информация о щенках:" +
                         "\nВсего " + puppies.length + " щенков");
        for (int i = 0; i<puppies.length; i++)  {
            System.out.println((i + 1) + "-ый " + "щенок:\n" + puppies[i]);
        }
    }
}
