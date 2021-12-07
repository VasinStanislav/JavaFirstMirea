package ru.mirea.task22;

public class TestChairFactory {
    public static void main(String[] args) {
        ChairFactory chairFactory = new ChairFactory();

        Client client = new Client();
        client.sit();

        Chair chair;

        int chType = (int) (1.0 + Math.random()*3.0);

        switch (chType) {
            case 1:
               chair = chairFactory.getChair(ChairTypes.MAGICAL);
               break;
            case 2:
                chair = chairFactory.getChair(ChairTypes.VICTORIAN);
                break;
            case 3:
                chair = chairFactory.getChair(ChairTypes.MULTIFUNCTIONAL);
                break;
            default:
                chair = null;
                break;
        }

        try {
            chair.defineUsage();
        } catch (IllegalArgumentException exception)    {
            System.out.println("Возникло исключение" + exception);
        }
    }
}
