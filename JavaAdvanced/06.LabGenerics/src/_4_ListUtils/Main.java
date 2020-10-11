package _4_ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerListUtils = new ArrayList<>();
        Collections.addAll(integerListUtils, 1, 2, 18, 2, -1);

        Integer maxInteger = ListUtils.getMax(integerListUtils);
        System.out.println(maxInteger);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        String minString = ListUtils.getMin(strings);
        System.out.println(minString);
    }
}
