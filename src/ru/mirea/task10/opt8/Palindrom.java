package ru.mirea.task10.opt8;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args)  {
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите слово: ");
        str = sc.nextLine();
        char[] string = new char[str.length()];
        string = str.toCharArray();
        System.out.print(isPal(string, 0) ? "YES" : "NO");
    }

    public static boolean isPal(char[] str, int i) {
        return (i < str.length/2 ? str[i] == str[str.length - i - 1] ? isPal(str, i+1) : false : true);
    }
}
