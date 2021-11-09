package ru.mirea.task14.opt1;

import java.util.Scanner;
import java.util.Stack;

public class DrunkardStack {
    public static void main(String[] args)  {
        Stack<Integer> firstPDeck  = new Stack<>();
        Stack<Integer> secondPDeck = new Stack<>();
        firstPDeck.setSize(5);
        secondPDeck.setSize(5);

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            firstPDeck.set(4-i, sc.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            secondPDeck.set(4-i, sc.nextInt());
        }

        int counter = 0;

        Integer buf;
        while (!firstPDeck.empty() && !secondPDeck.empty() && counter<106) {
            if (firstPDeck.peek() == 9 && secondPDeck.peek() == 0)   {
                buf = secondPDeck.pop();
                if (secondPDeck.empty()) {
                    secondPDeck.push(firstPDeck.pop());
                } else  {
                    secondPDeck.add(secondPDeck.lastIndexOf(secondPDeck.firstElement()), firstPDeck.pop());
                }
                secondPDeck.add(secondPDeck.lastIndexOf(secondPDeck.firstElement()), buf);
            } else if(secondPDeck.peek() == 9 && firstPDeck.peek() == 0)   {
                firstPDeck.add(firstPDeck.lastIndexOf(firstPDeck.firstElement()), firstPDeck.pop());
                firstPDeck.add(firstPDeck.lastIndexOf(firstPDeck.firstElement()), secondPDeck.pop());
            } else if(firstPDeck.peek()>secondPDeck.peek()) {
                firstPDeck.add(firstPDeck.lastIndexOf(firstPDeck.firstElement()), firstPDeck.pop());
                firstPDeck.add(firstPDeck.lastIndexOf(firstPDeck.firstElement()), secondPDeck.pop());
            } else if(secondPDeck.peek()>firstPDeck.peek()){
                buf = secondPDeck.pop();
                if (secondPDeck.empty()) {
                    secondPDeck.push(firstPDeck.pop());
                } else  {
                    secondPDeck.add(secondPDeck.lastIndexOf(secondPDeck.firstElement()), firstPDeck.pop());
                }
                secondPDeck.add(secondPDeck.lastIndexOf(secondPDeck.firstElement()), buf);
            }
            counter++;
        }

        System.out.print(counter == 106 ? "botva" : ((secondPDeck.empty() ? "first " : "second ") + counter));
    }
}
