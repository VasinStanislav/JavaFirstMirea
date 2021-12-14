package ru.mirea.task26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayByDigitalWallet implements PayStrategy{
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATA_BASE.put("cool_slava1999", "slava@edu.mirea.ru");
        DATA_BASE.put("based_pog1", "bpog1@edu.mirea.ru");
    }

    public void setSignedIn(boolean signedIn)   {

    }

    private boolean verify()    {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return  signedIn;
    }

    @Override
    public boolean pay(int paymentAmount) {
        return false;
    }

    @Override
    public void collectPaymentDetails() throws IOException {
        try {
            while (!signedIn) {
                System.out.print("Введите логин почты: ");
                email = READER.readLine();
                System.out.print("Введите пароль: ");
                password = READER.readLine();
                if (verify()) {
                    System.out.println("Проверка прошла успешно.");
                } else {
                    System.out.println("Неверный адрес или пароль!");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
