package ru.mirea.task14.opt3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DrunkardDequeue {
    public static void main(String[] args)  {
        ArrayDeque<Integer> firstPDeck  = new ArrayDeque<>();
        ArrayDeque<Integer> secondPDeck = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            firstPDeck.offerLast(sc.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            secondPDeck.offerLast(sc.nextInt());
        }

        int counter = 0;
        Integer card1, card2;

        while (!firstPDeck.isEmpty() && !secondPDeck.isEmpty() && counter<106) {
            card1 = firstPDeck.peekFirst();
            card2 = secondPDeck.peekFirst();

            if (card1 == 9 && card2 == 0)   {
                secondPDeck.offerLast(card1);
                secondPDeck.offerLast(card2);
            } else if (card2 == 9 && card1 == 0)    {
                firstPDeck.offerLast(card1);
                firstPDeck.offerLast(card2);
            } else if (card1>card2) {
                firstPDeck.offerLast(card1);
                firstPDeck.offerLast(card2);
            } else if (card1<card2) {
                secondPDeck.offerLast(card1);
                secondPDeck.offerLast(card2);
            }

            firstPDeck.removeFirst();
            secondPDeck.removeFirst();

            counter++;
        }

        System.out.print(counter == 106 ? "botva" : ((secondPDeck.isEmpty() ? "first " : "second ") + counter));
    }
}
