package HW6;

//import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static Cat[] myCat = new Cat[6];

    public static void main(String[] args) throws InterruptedException {
        // Кот (имя, аппетит, сытность)
        // Тарелка (содержит какое-то количество еды)
        // Кот ест из тарлеки. Если в тарелке не достаточно еды - кот ее не трогает

        // ДЗ:
        // while (true) -> while (!plate.isEmpty())
        // 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной
        // тарелки.
        // В конце каждого цикла мы досыпаем в тарелку еду.
        // Для досыпания еды сделать метод increaseFood в классе Plate.
        // 2. Поменять поле satiety у кота с boolean на int.
        // Допустим у кота апптит 10, сытность 3. Значит кот захочет поесть 7 единиц.
        // 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду уменьшал
        // сытость кота на 1.

        String[] catname = new String[] { "vaska", "richka", "katka", "murka", "pushok", "milka" };
        for (int i = 0; i < 5; i++) {
            myCat[i] = new Cat(catname[i], 10 + i, i + 8);
        }
        Plate plate = new Plate(100);
        boolean emptyplate = true;
        while (emptyplate) {
            System.out.println("проголодались");
            for (int i = 0; i < 5; i++) {
                myCat[i].makeHungry();
                System.out.println(myCat[i]);
            }
            System.out.println(plate);
            System.out.println("наелись");
            for (int i = 0; i < 5; i++) {
                myCat[i].eat(plate);
                System.out.println(myCat[i]);
            }
            System.out.println(plate);
            System.out.println("добавляем еду в тарелку");
            plate.increaseFood();
            System.out.println(plate);
            emptyplate = plate.isEmpty();
            Thread.sleep(1000);
        }
    }
}
