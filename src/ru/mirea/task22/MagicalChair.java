package ru.mirea.task22;

public class MagicalChair implements Chair {

    @Override
    public void defineUsage() {
        System.out.println("Вы видите перед собой магический стул\n" +
                "Вы хотите сесть на него... Подходя все ближе и ближе, вы начинаете поддаваться искушению\n" +
                "Стул оказывается удобным креслом... Вы зачарованы и не в силах встать");
    }
}
