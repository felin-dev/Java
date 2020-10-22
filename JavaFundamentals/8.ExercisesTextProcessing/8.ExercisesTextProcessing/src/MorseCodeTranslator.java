import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> morseCodeWords = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        List<Character> digits = new ArrayList<>();
        for (String morseCodeDigit : morseCodeWords) {
            char currentDigit = getDigit(morseCodeDigit);
            digits.add(currentDigit);
        }

        morseCodeWords.clear();
        StringBuilder word = new StringBuilder();
        for (Character digit : digits) {
            if (digit != '?') {
                word.append(digit);
            } else {
                morseCodeWords.add(word.toString());
                word.setLength(0);
            }
        }

        morseCodeWords.add(word.toString());
        System.out.println(String.join(" ", morseCodeWords));
    }

    private static char getDigit(String morseCodeDigit) {
        switch (morseCodeDigit) {
            case ".-":
                return 'A';
            case "-...":
                return 'B';
            case "-.-.":
                return 'C';
            case "-..":
                return 'D';
            case ".":
                return 'E';
            case "..-.":
                return 'F';
            case "--.":
                return 'G';
            case "....":
                return 'H';
            case "..":
                return 'I';
            case ".---":
                return 'J';
            case "-.-":
                return 'K';
            case ".-..":
                return 'L';
            case "--":
                return 'M';
            case "-.":
                return 'N';
            case "---":
                return 'O';
            case ".--.":
                return 'P';
            case "--.-":
                return 'Q';
            case ".-.":
                return 'R';
            case "...":
                return 'S';
            case "-":
                return 'T';
            case "..-":
                return 'U';
            case "...-":
                return 'V';
            case ".--":
                return 'W';
            case "-..-":
                return 'X';
            case "-.--":
                return 'Y';
            case "--..":
                return 'Z';
        }
        return '?';
    }
}