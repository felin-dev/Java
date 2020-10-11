package _2_GenericArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = ArrayCreator.create(10, "none");
        Integer[] array2 = ArrayCreator.create(int.class, 0, 3);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }
}