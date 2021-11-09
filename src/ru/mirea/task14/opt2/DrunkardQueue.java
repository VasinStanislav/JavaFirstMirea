package ru.mirea.task14.opt2;


import java.util.ArrayDeque;
import java.util.Scanner;

public class DrunkardQueue {
    public static void main(String[] args)  {
        ArrayDeque<Integer> firstPDeck  = new ArrayDeque<>();
        ArrayDeque<Integer> secondPDeck = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            firstPDeck.offer(sc.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            secondPDeck.offer(sc.nextInt());
        }

        int counter = 0;
        Integer card1, card2;

        while (!firstPDeck.isEmpty() && !secondPDeck.isEmpty() && counter<106) {
            card1 = firstPDeck.peek();
            card2 = secondPDeck.peek();

            if (card1 == 9 && card2 == 0)   {
                secondPDeck.offer(card1);
                secondPDeck.offer(card2);
            } else if (card2 == 9 && card1 == 0)    {
                firstPDeck.offer(card1);
                firstPDeck.offer(card2);
            } else if (card1>card2) {
                firstPDeck.offer(card1);
                firstPDeck.offer(card2);
            } else if (card1<card2) {
                secondPDeck.offer(card1);
                secondPDeck.offer(card2);
            }

            firstPDeck.remove();
            secondPDeck.remove();

            counter++;
        }

        System.out.print(counter == 106 ? "botva" : ((secondPDeck.isEmpty() ? "first " : "second ") + counter));
    }
}
