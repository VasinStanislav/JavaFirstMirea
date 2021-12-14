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
    private String cardNumber;
    private String cvvYear;
    private boolean signedIn;

    static {
        DATA_BASE.put("1221 132", "4222");
    }

    private boolean cardIsPresent() {
        return card != null;
    }

    public void setSignedIn(boolean signedIn)   {
        this.signedIn = signedIn;
    }

    private boolean verify()    {
        setSignedIn(cardNumber.equals(DATA_BASE.get(cvvYear)));
        return  signedIn;
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
            while (card == null) {
                System.out.print("Введите номер карты: ");
                String number = READER.readLine();
                System.out.print("Введите дату окончания срока карты 'mm/yy': ");
                String date = READER.readLine();
                System.out.print("Введите CVV код: ");
                String cvv = READER.readLine();

                cardNumber = number;
                cvvYear = date + " " + cvv;

                if (verify())   {
                    card = new CreditCard(number, date, cvv);
                    System.out.println("Проверка прошла успешно.");
                } else {
                    System.out.println("Неверно введены данные карты!");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
