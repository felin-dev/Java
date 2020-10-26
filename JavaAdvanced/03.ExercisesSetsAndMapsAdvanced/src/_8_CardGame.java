import java.util.*;

public class _8_CardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Set<String>> playersHands = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("JOKER")) {
            String player = input.split(":")[0];
            Set<String> cards = new HashSet<>(Arrays.asList(input.split(":\\s+")[1].split(",?\\s+")));
            playersHands.putIfAbsent(player, new HashSet<>());
            playersHands.get(player).addAll(cards);

            input = sc.nextLine();
        }

        getMapWithPoints(playersHands);

        StringBuilder output = new StringBuilder();
        playersHands.forEach((player, handPoints) ->
                output.append(String.format("%s: %s%n", player,
                        handPoints.toString().replaceAll("[\\[\\]]", ""))));

        System.out.println(output);
    }

    private static void getMapWithPoints(Map<String, Set<String>> playersHands) {
        for (String player : playersHands.keySet()) {
            Integer playerPoints = getPoints(playersHands.get(player));
            playersHands.get(player).clear();
            playersHands.get(player).add(playerPoints.toString());
        }
    }

    private static Integer getPoints(Set<String> cards) {
        int result = 0;
        for (String card : cards) {
            int currentResult;
            String currentPower;
            String currentType;
            if (card.length() != 2) {
                currentPower = "10";
                currentType = card.charAt(2) + "";
            } else {
                currentPower = card.charAt(0) + "";
                currentType = card.charAt(1) + "";
            }
            Map<String, Integer> getPowers = getPowers();
            currentResult = getPowers.get(currentPower) * getPowers.get(currentType);
            result += currentResult;
        }

        return result;
    }

    private static Map<String, Integer> getPowers() {
        Map<String, Integer> getPowers = new HashMap<>();
        getPowers.put("2", 2);
        getPowers.put("3", 3);
        getPowers.put("4", 4);
        getPowers.put("5", 5);
        getPowers.put("6", 6);
        getPowers.put("7", 7);
        getPowers.put("8", 8);
        getPowers.put("9", 9);
        getPowers.put("10", 10);
        getPowers.put("J", 11);
        getPowers.put("Q", 12);
        getPowers.put("K", 13);
        getPowers.put("A", 14);
        getPowers.put("S", 4);
        getPowers.put("H", 3);
        getPowers.put("D", 2);
        getPowers.put("C", 1);

        return getPowers;
    }
}