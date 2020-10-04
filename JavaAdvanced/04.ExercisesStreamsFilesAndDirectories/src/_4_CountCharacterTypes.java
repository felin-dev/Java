import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class _4_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String pathFile = "input.txt";
        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;
        String vowels = "aeiou";
        String punctuation = "!,.?";

        BufferedReader reader = new BufferedReader(new FileReader(pathFile));
        String line = reader.readLine();
        while (line != null) {
            String[] words = line.split("\\s+");
            for (String word :words){
                for (char symbol : word.toCharArray()) {
                    String charsAsString = String.valueOf(symbol);
                    if (vowels.contains(charsAsString)) {
                        countVowels++;
                    } else if (punctuation.contains(charsAsString)) {
                        countPunctuation++;
                    } else {
                        countConsonants++;
                    }
                }
            }

            line = reader.readLine();
        }
        reader.close();

        PrintWriter writer = new PrintWriter("charCount.txt");
        writer.println("Vowels: " + countVowels);
        writer.println("Consonants: " + countConsonants);
        writer.println("Punctuation: " + countPunctuation);
        writer.close();
    }
}