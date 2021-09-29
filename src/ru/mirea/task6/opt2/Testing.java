package ru.mirea.task6.opt2;

public class Testing {
    public static void main(String[] args) {
        Priceable ticket = new Ticket();
        Furniture pillow = new Furniture();
        Clothing jacket = new Clothing(39.99f);

        pillow.setPrice(6.99f);

        System.out.print("The cost of the train ticket: " + ticket.getPrice() + " USD" +
                         "\nThe cost of the jacket: " + jacket.getPrice() + " USD" +
                         "\nThe cost of the pillow: " + pillow.getPrice() + " USD");
    }
}
