package ru.mirea.task26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CreditCard    {
    private int amount;
    private final String number;
    private final String date;
    private final String cvv;

    CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getCvv() {
        return cvv;
    }
}

public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    private boolean cardIsPresent() {
        return card != null;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("Оплачивается " + paymentAmount + " кредитной картой.");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() throws IOException {
        try {
            System.out.print("Введите номер карты: ");
            String number = READER.readLine();
            System.out.print("Введите дату окончания срока карты 'mm/yy': ");
            String date = READER.readLine();
            System.out.print("Enter the CVV code: ");
            String cvv = READER.readLine();
            card = new CreditCard(number, date, cvv);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
