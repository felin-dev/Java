import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _6_MinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> minedMinerals = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("stop")) {
            String mineral = input;
            input = sc.nextLine();
            int quantity = Integer.parseInt(input);
            if (minedMinerals.containsKey(mineral)) {
                minedMinerals.put(mineral, minedMinerals.get(mineral) + quantity);
            } else {
                minedMinerals.put(mineral, quantity);
            }

            input = sc.nextLine();
        }

        StringBuilder output = new StringBuilder();
        minedMinerals.forEach((mineral, quantity) ->
                output.append(String.format("%s -> %d%n", mineral, quantity)));

        System.out.println(output);
    }
}