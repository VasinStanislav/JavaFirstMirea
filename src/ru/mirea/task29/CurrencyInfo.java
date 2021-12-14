package ru.mirea.task29;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CurrencyInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Date date;
    private final Map<String, Double> currencies = new HashMap<>();

    public CurrencyInfo(Date date) {
        this.date = date;
    }

    public void addCurrency(String currency, Double value)  {
        if (value >= 0) {
            currencies.put(currency, value);
        } else {
            currencies.put(currency, 0.0);
        }
    }

    public Map<String, Double> getCurrencies() {
        return currencies;
    }

    public Double getExchangeRate(String currency)  {
        return currencies.getOrDefault(currency, 0.0);
    }

    public Double convertTo(String currency1, String currency2)   {
        Double val1 = currencies.getOrDefault(currency1, 0.0);
        Double val2 = currencies.getOrDefault(currency2, 0.0);

        if (val1 > 0 && val2 > 0)   {
            return val2/val1;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "CurrencyInfo{" +
                "date=" + date +
                ", currencies=" + currencies +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null)    {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return  false;
        }
        CurrencyInfo that = (CurrencyInfo) obj;
        return toString().equals(that.toString());
    }
}
