import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String regexName = "[@](?<name>\\w+)[|]";
        String regexAge = "[#](?<age>\\d+)[*]";
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            Pattern patternName = Pattern.compile(regexName);
            Pattern patternAge = Pattern.compile(regexAge);
            Matcher name = patternName.matcher(input);
            Matcher age = patternAge.matcher(input);
            while (name.find()) {
                System.out.print(String.format("%s is ", name.group("name")));
            }
            while (age.find()) {
                System.out.print(String.format("%s years old.%n", age.group("age")));
            }
        }
    }
}
