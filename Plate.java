package HW6;

public class Plate {

    private int food;
    public boolean emptyplate;

    public Plate(int food) {
        this.food = food;
    }

    public int decreaseFood(int foodToDecrease) {
        if (food >= foodToDecrease) {
            food = food - foodToDecrease;
            return food;
        }
        return food;
    }

    public void increaseFood() {
        food = food + 5;
    }

    public boolean isEmpty() {
        emptyplate = true;
        if (food < 11) {
            System.out.println("Еды в тарелке не достаточно даже для первого кота");
            emptyplate = false;
        }
        return emptyplate;
    }

    @Override
    public String toString() {
        return "Plate[" + food + "]";
    }
}
