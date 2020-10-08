import java.util.*;
import java.util.stream.Collectors;

public class _7_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, List<String>>> countriesInfo = new LinkedHashMap<>();
        int count = Integer.parseInt(sc.nextLine());
        while (count-- > 0) {
            String[] countryInfo = sc.nextLine().split("\\s+");
            String continent = countryInfo[0];
            String country = countryInfo[1];
            String city = countryInfo[2];

            countriesInfo.putIfAbsent(continent, new LinkedHashMap<>());
            countriesInfo.get(continent).putIfAbsent(country, new LinkedList<>());
            countriesInfo.get(continent).get(country).add(city);
        }

        StringBuilder output = new StringBuilder();
        countriesInfo.forEach((continent, countries) -> {
            output.append(String.format("%s:%n", continent));
            countries.forEach((country, cities) -> {
                output.append(String.format("  %s -> ", country));
                output.append(cities.stream().map(Objects::toString).collect(Collectors.joining(", ")));
                output.append(String.format("%n"));
            });
        });

        System.out.println(output);
    }
}