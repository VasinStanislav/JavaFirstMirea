package ru.mirea.task26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Client {
    private static final List<Integer> priceOnProducts = new LinkedList<>();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.add(22000);
        priceOnProducts.add(1990);
    }

    public static void main(String[] args) throws IOException {
            Integer cost = 0;
            for (Integer it: priceOnProducts)    {
                cost += it;
            }
            order.setTotalCost(cost);

            if (strategy == null) {
                System.out.println("Пожалуйста, выберите способ оплаты:\n" +
                        "1 - Электронный Кошелек\n" +
                        "2 - Кредитная Карта");
                String paymentMethod = reader.readLine();

                if (paymentMethod.equals("1")) {
                    strategy = new PayByDigitalWallet();
                } else {
                    strategy = new PayByCreditCard();
                }
            }

            order.processOrder(strategy);

            if (strategy.pay(order.getTotalCost())) {
                System.out.print("Оплата произведена успешно.");
            } else {
                System.out.print("Ошибка! Пожалуйста, проверьте свои данные.");
            }

            order.setClosed(true);
    }
}
