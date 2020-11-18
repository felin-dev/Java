package _5_Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d");
        for (String url : urls) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                output.append("Invalid URL!");
                output.append(System.lineSeparator());
            } else {
                output.append("Browsing: ").append(url).append("!")
                        .append(System.lineSeparator());
            }
        }

        return output.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        Pattern pattern = Pattern.compile("\\D");
        for (String number : numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                output.append("Invalid number!");
                output.append(System.lineSeparator());
            } else {
                output.append("Calling... ").append(number)
                        .append(System.lineSeparator());
            }
        }

        return output.toString().trim();
    }
}
