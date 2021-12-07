package ru.mirea.task22;

public class Client implements Chair {
    public void sit()   {
        System.out.println("Вы посетитель фабрики по производству стульев\n" +
                "Раз уж такое дело, вы решаете осмотреться, чтобы найти стулья, на которые можно опереться и выбраться из фабрики\n" +
                "Помимо этого вам нужен какой-то инструмент, чтобы сломать окно или дверь");
        defineUsage();
    }

    @Override
    public void defineUsage() {
        System.out.println("Вы в поисках стула");
    }
}
