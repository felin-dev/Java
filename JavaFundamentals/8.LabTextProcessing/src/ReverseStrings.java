import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        while (!word.equals("end")) {
            String reverse = reverse(word);

            System.out.printf("%s = %s%n", word, reverse);

            word = sc.nextLine();
        }
    }

    private static String reverse(String word) {
        StringBuilder result = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            result.append(word.charAt(i));
        }

        return result.toString();
    }
}