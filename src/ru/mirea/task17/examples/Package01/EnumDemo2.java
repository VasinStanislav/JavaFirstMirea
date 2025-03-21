package ru.mirea.task17.examples.Package01;

// В программе демонстрируется применение методов values() и valueOf()
class EnumDemo2 {
    public static void main(String[] args) {
        Apple ap;
        System.out.println("Константы перечислимого типа Apple:");

        // создается переменная allApples, которой присваивается ссылка на массив значений перечислимого типа.
        Apple[] allApples = Apple.values();
        for (Apple a : allApples) {
            System.out.println(a);
        }

        System.out.println("\nКонстанты перечислимого типа Apple:");

        // цикл for можно написать и без переменной allApples
        for (Apple a : Apple.values() ) {
            System.out.print(a + " ");
        }

        System.out.println("\n");

        // метод valueOf() возвращает значение перечислимого типа, связанное с именем константы того же типа,
        // передаваемым этому методу в виде символьной строки.
        ap = Apple.valueOf("Winesap");
        System.out.println("Пepeмeннaя ар содержит " + ap);
    }
}
/* ----------------------------------------
Константы перечислимого типа Apple:
Jonathan
GoldenDel
RedDel
Winesap
Cortland

Константы перечислимого типа Apple:
Jonathan GoldenDel RedDel Winesap Cortland

Пepeмeннaя ар содержит Winesap
 */