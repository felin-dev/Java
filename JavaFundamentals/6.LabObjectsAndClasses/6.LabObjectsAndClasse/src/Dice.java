import java.util.Random;

public class Dice {
    private int sides;

    public int getSides() {
        return this.sides;
    }

    public void setSides(int side) {
        this.sides = side;
    }

    public int roll() {
        Random rand = new Random();

        return rand.nextInt(this.sides) + 1;
    }
}
