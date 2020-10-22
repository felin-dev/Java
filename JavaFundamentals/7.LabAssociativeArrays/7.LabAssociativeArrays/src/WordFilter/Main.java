package WordFilter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> evenLengthWords = Arrays.stream(sc.nextLine().split(" "))
                .filter(w -> w.length() % 2 == 0)
                .collect(Collectors.toList());

        for (String evenLengthWord : evenLengthWords) {
            System.out.println(evenLengthWord);
        }
    }
}