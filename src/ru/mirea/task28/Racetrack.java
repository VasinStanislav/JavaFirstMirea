package ru.mirea.task28;

public class Racetrack {
    public static void main(String[] args) {
        MonsterTruck monsterTruck = new MonsterTruck();
        MonsterTruck.Engine engine = monsterTruck.new Engine();
        MonsterTruck.FuelTank fuelTank = monsterTruck.new FuelTank();

        System.out.println("Шоу монстр-трака!\nСведения о траке");
        System.out.println(monsterTruck);

        System.out.println("Заливаем монстр-трак топливом до края!");
        fuelTank.fillTank(150);
        System.out.println("В баке " + fuelTank.getCurrentCapacity() + " литров");

        System.out.println("Монстр-трак выполняет трюк!");
        fuelTank.burn();

        fuelTank.burn();
        int meters = getMeters(fuelTank.getMaxCapacity() - fuelTank.currentCapacity);
        System.out.println("Монстр-трак проехал " + meters + " метров");

        System.out.println("Ещё один трюк!");
        fuelTank.burn();

        System.out.println("Ещё один трюк!");
        fuelTank.burn();
        if (fuelTank.getCurrentCapacity() == 0) {
            engine.stop();
            System.out.println("Топливо кончилось!");
        }

        System.out.print("Шоу закончено");
    }

    public static int getMeters(int burnedFuel) {
        return 5*burnedFuel;
    }
}
