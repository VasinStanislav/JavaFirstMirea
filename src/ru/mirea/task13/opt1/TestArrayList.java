package ru.mirea.task13.opt1;

import ru.mirea.task12.opt1.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();

        Student s1 = new Student();
        Student s2 = new Student("10 А 3", "Василий Пупыркин", 5.0);
        Student s3 = new Student("Вячеслав Украинцев", 4.5);
        Student s4 = new Student("10 А 2");
        Student s5 = new Student("10 Б 1", "Антон Хомяков", 4.8);

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        int s3Index = students.indexOf(s3);
        System.out.println("Индекс Славы из 10 класса в списке учеников: " + s3Index);

        System.out.println("Самым первым пришёл на олимпиаду некто " + students.get(0).getName());

        System.out.println("Наличие пятого: " + students.contains(s5));

        students.set(0, new Student("10 В 1"));
        System.out.println("Выяснилось, что первым пребывшим оказался третий по списку ученик из 10 В " + students.get(0).getName());

        students.remove(3);
        System.out.println("Мы были вынуждены удалить ученика с индексом " +s4.getIDNumber() + " за списывание");

        students.add(3, new Student("10 А 2"));

        students.get(2).setIDNumber("10 Г 10");

        System.out.println("Список студентов, сдавших олимпиаду:\n" + students);

        students.clear();
        System.out.println("Все студенты были удалены с аудитории: " + students.toString());

        Student[] group1 = {new Student("11 А 1"), new Student("11 А 2"), new Student("11 А 3")};
        students.addAll(Arrays.asList(group1));
        System.out.println("На уроке " + students.size() + " учеников:\n" + students);

        Student[] group2 = students.toArray(new Student[0]);
    }
 }
