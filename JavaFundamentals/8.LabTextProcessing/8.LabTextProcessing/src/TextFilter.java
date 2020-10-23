import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] bannedWords = sc.nextLine().split(", ");
        String text = sc.nextLine();

        for (String bannedWord : bannedWords) {
            String stars = getStarString(bannedWord.length());
            text = text.replace(bannedWord, stars);
        }

        System.out.println(text);
    }

    private static String getStarString(int length) {
        String stars = "";
        List<String> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            result.add("*");
        }
        stars = String.join("", result);
        return stars;
    }
}
