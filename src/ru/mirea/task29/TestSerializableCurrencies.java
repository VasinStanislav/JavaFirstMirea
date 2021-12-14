package ru.mirea.task29;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestSerializableCurrencies {
    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        String strDate = "Tue, November 25, 2021";
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMMM d, yyyy", Locale.ENGLISH);

        Date date = getDate(strDate, formatter);
        CurrencyInfo curInfo1 = new CurrencyInfo(date);
        curInfo1.addCurrency("Доллар США", 74.3726);
        curInfo1.addCurrency("Евро", 83.6394);

        strDate = "Wed, December 15, 2021";
        date = getDate(strDate, formatter);
        CurrencyInfo curInfo2 = new CurrencyInfo(date);
        curInfo2.addCurrency("Доллар США", 73.4698);
        curInfo2.addCurrency("Евро", 82.8299);

        System.out.println("//-----------ТЕСТ------------//");
        System.out.println("Сравниваем объекты: " + curInfo1.equals(curInfo2));

        FileOutputStream outputStream = new FileOutputStream("src/ru/mirea/task29/CurrencyInfo");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(curInfo1);
        objectOutputStream.close();

        Double value = curInfo2.convertTo("Доллар США", "Евро");
        System.out.println("Метод convertTo второго объекта. Результат:\n" +
                "Доллар США к Евро: " + value);

        FileInputStream fileInputStream = new FileInputStream("src/ru/mirea/task29/CurrencyInfo");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        curInfo2 = (CurrencyInfo) objectInputStream.readObject();
        objectInputStream.close();

        value = curInfo2.convertTo("Доллар США", "Евро");
        System.out.println("Метод convertTo второго объекта после переопределения " +
                "с помощью сериализации. Результат:\n" +
                "Доллар США к Евро: " + value);

        System.out.print("Сравниваем объекты: " + curInfo1.equals(curInfo2));
    }

    public static Date getDate(String strDate, SimpleDateFormat formatter)
    {
        Date date = new Date();
        try {
            date = formatter.parse(strDate);
        } catch (ParseException e)  {
            e.printStackTrace();
        }

        return date;
    }
}
