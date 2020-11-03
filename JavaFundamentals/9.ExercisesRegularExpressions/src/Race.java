import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> racers = Arrays
                .stream(sc.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        Map<String, Integer> racerTimes = new LinkedHashMap<>();
        String input = sc.nextLine();
        String regexName = "[A-Za-z]+";
        String regexTime = "\\d";
        while (!"end of race".equals(input)) {
            StringBuilder currentRacer = new StringBuilder();
            Pattern pattern = Pattern.compile(regexName);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                currentRacer.append(matcher.group());
            }
            Pattern patternTime = Pattern.compile(regexTime);
            Matcher matcherTime = patternTime.matcher(input);
            int currentTime = 0;
            while (matcherTime.find()) {
                currentTime += Integer.parseInt(matcherTime.group());
            }

            if (racers.contains(currentRacer.toString())) {
                if (racerTimes.containsKey(currentRacer.toString())) {
                    int oldTime = racerTimes.get(currentRacer.toString());
                    racerTimes.put(currentRacer.toString(), currentTime + oldTime);
                } else {
                    racerTimes.putIfAbsent(currentRacer.toString(), currentTime);
                }
            }

            input = sc.nextLine();
        }

        ArrayList<String> places = new ArrayList<>() {
            {
                add("1st");
                add("2nd");
                add("3rd");
            }
        };
        racerTimes
                .entrySet()
                .stream()
                .sorted((k, v) -> v.getValue().compareTo(k.getValue()))
                .limit(3)
                .forEach(e -> System.out.println(String.format("%s place: %s", places.remove(0), e.getKey())));
    }
}