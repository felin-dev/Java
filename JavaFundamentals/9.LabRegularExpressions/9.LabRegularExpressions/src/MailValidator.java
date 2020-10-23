import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String regex = "\\w+@(?<domain>[A-Za-z]+)\\.([A-Za-z]+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group("domain"));
        }
    }
}
