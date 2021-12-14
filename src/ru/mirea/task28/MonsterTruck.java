package ru.mirea.task28;

public class MonsterTruck {
    /*----------------------поля------------------*/
    private final int weight;
    String name;

    /*----------------------конструкторы машины------------------*/
    public MonsterTruck(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public MonsterTruck(String name) {
        this(5000, name);
    }

    public MonsterTruck() {
        this("BigFoot");
    }

    /*----------------------геттеры машины------------------*/
    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MonsterTruck{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }

    /*----------------------вложенные внутренний класс Двигатель-------*/
    public class Engine {
        private int power;
        private boolean isRunning;

        public Engine() {
            power = 1500;
            isRunning = true;
        }

        public void run()   {
            isRunning = true;
        }

        public void stop() {
            isRunning = false;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public boolean isRunning() {
            return isRunning;
        }

        public int getPower() {
            return power;
        }
    }

    /*----------------------вложенные внутренний класс Топливный бак-------*/
    public class FuelTank   {
        int maxCapacity;
        int currentCapacity;

        public FuelTank() {
            maxCapacity = 100;
            currentCapacity = 0;
        }

        public void fillTank(int fuel)   {

            /*----------------------анонимный класс, заправляюший бак------------------*/
            GasStation gasStation = new GasStation() {
                @Override
                public int fillAuto() {
                    if (fuel >= maxCapacity - currentCapacity)  {
                        return maxCapacity - currentCapacity;
                    } else return Math.max(fuel, 0);
                }
            };

            currentCapacity += gasStation.fillAuto();
        }

        public void burn()  {
            if (currentCapacity >= 30)  {
                currentCapacity-=30;
            } else {
                currentCapacity = 0;
            }
        }

        public int getMaxCapacity() {
            return maxCapacity;
        }

        public int getCurrentCapacity() {
            return currentCapacity;
        }
    }
}
