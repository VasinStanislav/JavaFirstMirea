package ru.mirea.task3.opt2;

public class TestHuman {
    public static void main(String[] args)  {
        Human adult = new Human();
        adult.setName("Станислав Васин");
        adult.setAge(18);
        adult.setHeight(187);
        adult.setWeight(65);
        System.out.println("Я потерял ручку, надо найти её");
        adult.head.turnLeft();
        adult.head.turnRight();
        adult.head.turnDown();
        System.out.println("Я нашёл ручку!");
        adult.head.setFirstPosition();
        System.out.println("Сейчас я наклонюсь, чтобы поднять упавшую ручку");
        adult.body.bend();
        adult.body.breakSomething();
        System.out.println("Кажется, что-то хрустнуло");
        if (!adult.body.straightenBack())   {
            System.out.println("Я не могу выпрямить спину!!!");
        }
        for (int i = 0; i<adult.legs.length; i++) {
            adult.legs[i].move();
        }
        System.out.println("Пожалуй, полежу. Может пройдёт");
        for (int i = 0; i<adult.legs.length; i++) {
            adult.legs[i].stop();
        }
        adult.body.heal();
        if (adult.body.straightenBack())    {
            System.out.println("Мне стало лучше! Я смог выпрямиться!");
        }
        System.out.print(adult);
    }
}
