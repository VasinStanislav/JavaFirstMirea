package ru.mirea.task17.myenums;

enum Door   {
    WOODEN_DOOR(8, "Деревянная дверь"),
    METAL_DOOR(15, "Металлическая дверь"),
    SHEET_METAL_DOOR(10, "Дверь из листового металла"),
    RUSTY_DOOR(5, "Ржавая дверь"),
    GLASS_DOOR(2, "Стеклянная дверь"),
    LAMINATED_DOOR(3, "Пластиковая дверь");

    private final int durability;
    private final String type;

    Door(int durability, String type)    {
        this.durability = durability;
        this.type = type;
    }

    public int getDurability()  {
        return durability;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Дверь{" +
                "прочность=" + durability +
                ", тип двери='" + type + '\'' +
                '}';
    }
}

enum FloorCovering  {
    LINOLEUM,
    CARPET,
    WOOD,
    BRICK,
    MARBLE,
    VOID,
    PAVEMENT,
    SOIL,
    CLAY,
    GLASS,
    SHATTERED_GLASS,
    SPIKES,
    RUBBISH
}

enum Wall   {
    WOODEN_WALL,
    BRICK_WALL,
    STONE_WALL,
    RUSTY_METAL_WALL,
    MUD_WALL,
    GLASS_WALL,
    SPIKES,
    TRASH_HEAP
}

public class TestMyEnums {
    public static void main(String[] args)  {
        /* Тестирование перечисления типов дверей, которые будут использоваться в игре */

        System.out.println("-------------------------");

        Door prevDoor = Door.METAL_DOOR, nextDoor = Door.RUSTY_DOOR;

        for (Door door: Door.values())  {
            System.out.println(door);
        }

        System.out.println(nextDoor.compareTo(prevDoor)>0 ? prevDoor + " предшествует " + nextDoor :
                nextDoor + " предшествует " + prevDoor);

        System.out.println("-------------------------");

        /* Тестирование перечисления типов покрытий пола, которые будут использоваться в игре */

        for (FloorCovering floor: FloorCovering.values())   {
            System.out.println(floor + " " + floor.ordinal());
        }

        System.out.println("-------------------------");

        /* Тестирование перечисления типов покрытий пола, которые будут использоваться в игре */

        for (Wall wall: Wall.values())   {
            System.out.println(wall + " " + wall.ordinal());
        }

        System.out.print("-------------------------");
    }
}
