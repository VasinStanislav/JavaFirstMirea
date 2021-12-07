package ru.mirea.task22;

public class ChairFactory {
    public Chair getChair(ChairTypes chairType) {
        Chair chair;

        switch (chairType)  {
            case MAGICAL:
                chair = new MagicalChair();
                break;
            case VICTORIAN:
                chair = new VictorianChair();
                break;
            case MULTIFUNCTIONAL:
                chair = new MultifunctionalChair();
                break;
            default:
                throw new IllegalArgumentException("Неверно задан тип стула: " + chairType);
        }

        return chair;
    }

}
