package PrintTopTree;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((l, r) -> r.compareTo(l))
                .limit(3)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
