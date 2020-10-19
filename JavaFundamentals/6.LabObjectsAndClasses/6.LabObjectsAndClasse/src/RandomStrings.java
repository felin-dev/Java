import java.util.Random;
import java.util.Scanner;

public class RandomStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");

        Random rand = new Random();
        for (int i = 0; i < words.length; i++) {
            int randomIndex = rand.nextInt(words.length);

            String temp = words[i];
            words[i] = words[randomIndex];
            words[randomIndex] = temp;
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
