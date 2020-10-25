package FinalRetake10apr2020;

        import java.util.*;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wordsString = sc.nextLine();
        List<String> mirrorWords = new ArrayList<>();
        String regex = "([@#])(?<word>[A-Za-z]{3,})\\1\\1(?<reversedWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(wordsString);
        int pairWordsCount = 0;
        boolean matcherFound = false;
        while (matcher.find()) {
            String word = matcher.group("word");
            String reversedWord = matcher.group("reversedWord");
            String mirror = getMirror(reversedWord);
            if (word.equals(mirror)) {
                mirrorWords.add(word + " <=> " + reversedWord);
            }
            pairWordsCount++;
            matcherFound = true;
        }

        if (!matcherFound){
            System.out.println("No word pairs found!");
        } else {
            System.out.println(pairWordsCount + " word pairs found!");
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        }
    }

    private static String getMirror(String reversedWord) {
        return new StringBuilder(reversedWord).reverse().toString();
    }
}