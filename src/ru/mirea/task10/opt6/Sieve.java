package ru.mirea.task10.opt6;

import java.util.Scanner;

public class Sieve {
    public static void main(String[] args)  {
        Integer n;
        System.out.print("Введите натуральное число больше 1: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.print((isPrime(n, 2)) ? "YES" : "NO");
    }

    public static boolean isPrime(Integer n, Integer divider)   {
        if (n < 2) {
            return false;
        }
        else if (n == 2) {
            return true;
        }
        else if (n % divider == 0) {
            return false;
        }
        else if (divider < n / 2) {
            return isPrime(n, divider + 1);
        } else {
            return true;
        }
    }
}
