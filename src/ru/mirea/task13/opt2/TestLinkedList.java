package ru.mirea.task13.opt2;

import java.util.Arrays;
import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args)  {
        String str1 = "Программирование на Джаве";
        String str2 = "Математический анализ";
        String str3 = "Электротехника";
        String str4 = "Алгоритмические основы обработки данных";
        String str5 = "Архитектура вычислительных машин и систем";
        String str6 = "Теория автоматов";
        String str7 = "Философия";
        String str8 = "Физическая культура и спорт";
        String str9 = "Иностранный язык";
        String str10 = "Вычислительная математика";


        String[] subjects = {str1, str2, str3, str4, str5, str6, str7, str8, str9, str10};

        LinkedList<String> myFavSubjects = new LinkedList<String>();

        myFavSubjects.addAll(Arrays.asList(subjects));
        myFavSubjects.remove(str3);
        myFavSubjects.remove(2);
        myFavSubjects.remove(str7);
        myFavSubjects.removeLast();

        System.out.println(myFavSubjects);

        LinkedList<String> schedule = new LinkedList<String>();
        schedule.add(str10);
        schedule.addFirst(str4);
        schedule.add(2, str5);
        schedule.addLast(str2);
        schedule.set(1, str6);

        System.out.println("Расписание в четверг с первой пары по четвёртую:\n" + schedule);
        System.out.println("Я иду в вуз. Сейчас будут занятия по предмету \"" + schedule.peekFirst() + "\"");
        System.out.println("Я сижу на занятиях по предмету \"" + schedule.peekLast() + "\". Скоро пойду домой спать");

        schedule.pollLast();
        schedule.pollFirst();
        schedule.pollLast();
        schedule.pollFirst();

        System.out.println("Сегодня пятница. У меня " + schedule.size() + " пар");
    }
}
