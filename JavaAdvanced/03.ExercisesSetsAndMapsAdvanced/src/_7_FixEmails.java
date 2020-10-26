import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _7_FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> usersInfo = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("stop")) {
            String username = input;
            String domain = sc.nextLine();
            Pattern pattern = Pattern.compile("\\.(?<domain>[a-z]+)");
            Matcher matcher = pattern.matcher(domain);
            if (matcher.find()) {
                String domainCheck = matcher.group("domain");
                if (!domainCheck.equals("uk") && !domainCheck.equals("com") && !domainCheck.equals("us")) {
                    usersInfo.put(username, domain);
                }
            }

            input = sc.nextLine();
        }

        StringBuilder output = new StringBuilder();
        usersInfo.forEach((user, email) ->
                output.append(String.format("%s -> %s%n", user, email)));

        System.out.println(output);
    }
}