package HW6;

import java.util.concurrent.ThreadLocalRandom;

public class Cat {

    private String name;
    private int appetite;
    private volatile int satiety;
//    private volatile boolean satiety = false;

    public Cat(String name) {
        this(name, 10, 5);
//        this.name = name;
//        this.appetite = 10;
//        satiety = false;
    }

    public Cat(String name, int appetite, int satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;

        // Thread backgroundSatietyManagement = new Thread(() -> {
        //     while (true) {
        //         satiety = satiety+1;
        //         try {
        //             Thread.sleep(5 * 1000L);
        //         } catch (InterruptedException e) {
        //             throw new RuntimeException(e);
        //         }
        //     }
        // });
        // backgroundSatietyManagement.setDaemon(true);
        // backgroundSatietyManagement.start();
    }


    public void eat(Plate plate) {
        if (satiety<appetite) {
            plate.decreaseFood(appetite-satiety);
            satiety=appetite;
        }
    }
    public void makeHungry() {
        int hunger = ThreadLocalRandom.current().nextInt(3,6);
        satiety=satiety-hunger;
    }
    @Override
    public String toString() {
        return name + "{appetite=" + appetite + ", satiety=" + satiety + "}";
    }
}
