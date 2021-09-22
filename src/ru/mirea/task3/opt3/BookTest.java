package ru.mirea.task3.opt3;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args)  {
        Book book = new Book("Ernest Miller Hemingway", "A Farewell to Arms");
        book.setYearOfComposition(1929);
        book.setPages(355);

        System.out.print("Enter the amount of pages you would like to read: ");
        Scanner sc = new Scanner(System.in);
        book.read(sc.nextInt());
        System.out.print(book);
    }
}
