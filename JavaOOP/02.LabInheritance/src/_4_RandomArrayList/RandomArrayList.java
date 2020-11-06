package _4_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {
    public E getRandomElement() {
        Random random = new Random();

        int randomIndex = random.nextInt(super.size());

        return super.remove(randomIndex);
    }
}
