package ru.mirea.task23;

import ru.mirea.task12.opt1.Student;
import ru.mirea.task3.opt1.Circle;

import java.io.File;
import java.util.HashMap;

public class TestHashCode {
    public static void main(String[] args)  {
        Student student1 = new HBEStudent(String.valueOf(6), "Vyalov V.", 4.8);
        Student student2 = new HBEStudent(String.valueOf(9), "Ryabin M.", 4.8);

        System.out.println("First student: hashCode = " + student1.hashCode());
        System.out.println("Second student: hashCode = " + student2.hashCode());
        System.out.println(student1.hashCode() == student2.hashCode());

        String str1 = "lowerCamelCase";
        String str2 = "UpperCamelCase";

        System.out.println("First line: hashCode = " + str1.hashCode());
        System.out.println("Second line: hashCode = " + str2.hashCode());
        System.out.println(str1.hashCode() == str2.hashCode());

        HashMap<Integer, String> employees = new HashMap<>();
        employees.put(1000, "Junior");
        employees.put(2000, "Engineer");

        System.out.println("First employee: hashCode = " + employees.get(1000).hashCode());
        System.out.println("Second employee: hashCode = " + employees.get(2000).hashCode());
        System.out.println(employees.get(1000).hashCode() == employees.get(2000).hashCode());

        File file1 = new File("strangeFile.txt");
        File file2 = new File("weirdFile.txt");

        System.out.println("First file: hashCode = " + file1.hashCode());
        System.out.println("Second file: hashCode = " + file2.hashCode());
        System.out.println(file1.hashCode() == file2.hashCode());

        Circle circle1 = new Circle(5.0, true);
        Circle circle2 = new Circle(5.0, false);

        System.out.println("First circle: hashCode = " + circle1.hashCode());
        System.out.println("Second circle: hashCode = " + circle2.hashCode());
        System.out.println(circle1.hashCode() == circle2.hashCode());
    }
}
