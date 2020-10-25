import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int coolThreshold = getThreshold(input);
        System.out.println(String.format("Cool threshold: %d", coolThreshold));

        String regex = "([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int coolEmojisCount = 0;
        List<String> emojis = new ArrayList<>();
        while (matcher.find()) {
            emojis.add(matcher.group(0));
            coolEmojisCount++;
        }
        removeUncoolEmojis(emojis, coolThreshold);

        System.out.println(String.format("%d emojis found in the text. The cool ones are:", coolEmojisCount));
        emojis.forEach(e -> System.out.println(String.format("%s", e)));
    }

    private static void removeUncoolEmojis(List<String> emojis, int coolThreshold) {
        for (int i = 0; i < emojis.size(); i++) {
            String emoji = emojis.get(i);
            int sum = 0;
            for (int j = 2; j < emoji.length() -2; j++) {
                sum += emoji.charAt(j);
            }

            if (sum < coolThreshold) {
                emojis.remove(emoji);
                i--;
            }
        }
    }

    private static int getThreshold(String input) {
        int threshold = 1;
        String regex = "\\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            threshold *= Integer.parseInt(matcher.group());
        }

        return threshold;
    }
}