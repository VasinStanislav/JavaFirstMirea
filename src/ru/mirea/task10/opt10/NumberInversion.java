package ru.mirea.task10.opt10;

import java.util.Scanner;

public class NumberInversion {
    public static void main(String[] args){
        int num;
        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        System.out.print("Получилось число: " + invertNum(num,0));
    }

    public static int invertNum(int num, int i) {
        return ((num==0) ? i : invertNum( num/10, i*10 + num%10 ));
    }
}
