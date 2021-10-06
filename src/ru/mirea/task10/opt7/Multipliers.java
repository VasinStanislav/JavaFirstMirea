package ru.mirea.task10.opt7;

import java.util.Scanner;

public class Multipliers {
    public static void main(String[] args)  {
        Integer n, div;
        System.out.print("Введите натуральное число больше 1: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        div = 2;
        System.out.print("n = 1");
        find(n, div);
    }

    public static void find(Integer n, Integer div)   {
        if (n == 1) {
            return;
        }
        if (n % div == 0)   {
            System.out.print(" * " + div.toString());
            find(n/div, div);
        }
        else    {
            find(n, div+1);
        }
    }
}
