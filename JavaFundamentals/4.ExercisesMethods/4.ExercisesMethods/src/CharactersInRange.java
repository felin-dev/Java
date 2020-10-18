import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char first = sc.nextLine().charAt(0);
        char second = sc.nextLine().charAt(0);

        if (first < second) {
            symbolsInRange(first, second);
        } else {
            symbolsInRange(second, first);
        }
    }

    private static void symbolsInRange(char start, char end) {
        for (int i = ++start; i < end; i++) {
            System.out.printf("%c ", i);
        }
    }
}
