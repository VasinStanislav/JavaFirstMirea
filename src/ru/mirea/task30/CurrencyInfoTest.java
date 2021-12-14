package ru.mirea.task30;

import org.junit.Assert;
import ru.mirea.task29.CurrencyInfo;

import java.util.Date;

public class CurrencyInfoTest {

    @org.junit.Test
    public void addCurrency() {
        CurrencyInfo currencyInfo = new CurrencyInfo(new Date());
        currencyInfo.addCurrency("Доллар США", 73.4698);
        currencyInfo.addCurrency("Китайский юань", 11.5466);
        currencyInfo.addCurrency("Украинская гривня", 2.7201);
        currencyInfo.addCurrency("Фунт стерлингов Соединенного Королевства", 97.0610);
        currencyInfo.addCurrency("Сингапурский доллар", 53.6864);

        Assert.assertNotNull(currencyInfo.getCurrencies());
    }

    @org.junit.Test
    public void equals() {
        CurrencyInfo currencyInfo1 = new CurrencyInfo(new Date());
        CurrencyInfo currencyInfo2 = new CurrencyInfo(new Date());

        currencyInfo1.addCurrency("Украинская гривня", 2.7201);
        currencyInfo2.addCurrency("Украинская гривня", 2.7201);

        Assert.assertEquals(currencyInfo1, currencyInfo2);

        currencyInfo1.addCurrency("Сингапурский доллар", 53.6864);
        //Assert.assertEquals(currencyInfo1, currencyInfo2);
    }
}