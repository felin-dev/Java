package FinalExam07dec2019;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "^(U\\$)(?<username>[A-Z][a-z]{2,})\\1(P@\\$)(?<password>[a-z]{5,}\\d+)\\3$";
        Pattern pattern = Pattern.compile(regex);
        int registrationCount = 0;
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String username = matcher.group("username");
                String password = matcher.group("password");
                System.out.println("Registration was successful");
                System.out.println(String.format("Username: %s, Password: %s", username, password));
                registrationCount++;
            } else {
                System.out.println("Invalid username or password");
            }
        }

        System.out.println(String.format("Successful registrations: %d", registrationCount));
    }
}