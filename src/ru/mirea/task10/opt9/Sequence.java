package ru.mirea.task10.opt9;

import java.util.Scanner;

public class Sequence {
    public static void main(String[] args)  {
        int a, b;
        System.out.print("Введите значение для числа a(кол-во нулей): ");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        System.out.print("Введите значение для числа b(кол-во единиц): ");
        b = sc.nextInt();
        System.out.print("Количество последовательностей из " + a + " нулей и "
                + b + " единиц, " + "в которых никакие два нуля не стоят рядом: "
                + getAmount(a, b));
    }

    public static int getAmount(int a, int b) {
        if (a > b + 1) {
            return 0;
        }

        if (a == 0 || b == 0) {
            return 1;
        }

        return (getAmount(a,b-1)+getAmount(a-1,b-1));
    }
}
