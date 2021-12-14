package ru.mirea.task26;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface PayStrategy {
    Map<String, String> DATA_BASE = new HashMap<>();

    boolean pay(int paymentAmount);
    void collectPaymentDetails() throws IOException;
}
