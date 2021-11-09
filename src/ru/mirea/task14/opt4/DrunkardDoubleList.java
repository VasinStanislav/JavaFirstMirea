package ru.mirea.task14.opt4;

import java.util.LinkedList;
import java.util.Scanner;

public class DrunkardDoubleList {
    public static void main(String[] args) {
        LinkedList<Integer> firstPDeck  = new LinkedList<>();
        LinkedList<Integer> secondPDeck = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            firstPDeck.add(sc.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            secondPDeck.add(sc.nextInt());
        }

        int counter = 0;
        Integer card1, card2;

        while(!firstPDeck.isEmpty() && !secondPDeck.isEmpty() && counter<106)   {
            card1 = firstPDeck.peekFirst();
            card2 = secondPDeck.peekFirst();

            if (card1 == 9 && card2 == 0)   {
                secondPDeck.addLast(card1);
                secondPDeck.addLast(card2);
            } else if (card2 == 9 && card1 == 0)    {
                firstPDeck.addLast(card1);
                firstPDeck.addLast(card2);
            } else if (card1>card2) {
                firstPDeck.addLast(card1);
                firstPDeck.addLast(card2);
            } else if (card1<card2) {
                secondPDeck.addLast(card1);
                secondPDeck.addLast(card2);
            }

            firstPDeck.removeFirst();
            secondPDeck.removeFirst();

            counter++;
        }

        System.out.print(counter == 106 ? "botva" : ((secondPDeck.isEmpty() ? "first " : "second ") + counter));
    }
}
