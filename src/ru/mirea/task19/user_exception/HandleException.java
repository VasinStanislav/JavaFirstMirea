package ru.mirea.task19.user_exception;

import java.util.Scanner;

public class HandleException {
    public static void main(String[] args) throws ArithmeticException  {
        RightTriangle rightTriangle;

        try {
            System.out.println("Введите угол A для прямоугольного треугольника: ");
            Scanner sc = new Scanner(System.in);
            double alpha = sc.nextDouble();
            System.out.println("Введите угол B для прямоугольного треугольника: ");
            double beta = sc.nextDouble();

            if (alpha + beta != 90.0 || (alpha >= 90.0 || alpha <= 0) ||
                    (beta >= 90.0 || beta <= 0))    {
                throw new ArithmeticException("Неверно заданы углы для прямого треугольника!");
            }

            rightTriangle = new RightTriangle(alpha, beta);
            System.out.print(rightTriangle);
        } catch (ArithmeticException e) {
            System.out.print("Программа не может быть корректно выполнена, поскольку: " + e);
        }
    }
}
