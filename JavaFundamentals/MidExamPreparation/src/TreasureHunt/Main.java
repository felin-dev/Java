package TreasureHunt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> treasures = Arrays
                .stream(sc.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!"Yohoho!".equals(input)) {
            String[] commandsList = input.split(" ");
            String currentCommand = commandsList[0];
            switch (currentCommand) {
                case "Loot":
                    for (int i = 1; i < commandsList.length; i++) {
                        if (!treasures.contains(commandsList[i])) {
                            treasures.add(0, commandsList[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commandsList[1]);
                    if (index < 0 || index >= treasures.size()) {
                        break;
                    }
                    treasures.add(treasures.remove(index));
                    break;
                case "Steal":
                    int stealCount = Integer.parseInt(commandsList[1]);
                    List<String> stolenTreasure = new ArrayList<>();
                    String output = "";
                    if (stealCount >= treasures.size()) {
                        output = String.join(", ", treasures);
                        System.out.println(output);
                        treasures.clear();
                        break;
                    }

                    for (int i = 0; i < stealCount; i++) {
                        stolenTreasure.add(0, treasures.remove(treasures.size()-1));
                    }

                    output = String.join(", ", stolenTreasure);
                    System.out.println(output);

                    break;
            }
            input = sc.nextLine();
        }
        if (!treasures.isEmpty()) {
            double sum = 0;
            for (String treasure : treasures) {
                sum += treasure.length();
            }
            double averageTreasureGained = sum / treasures.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGained);
        } else {

            System.out.println("Failed treasure hunt.");
        }
    }
}