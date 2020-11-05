
package _6_GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] itemInfo = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < itemInfo.length; i += 2) {
            String type = itemInfo[i];
            long quantity = Long.parseLong(itemInfo[i + 1]);

            if (type.length() == 3) {
                bag.addCash(type, quantity);
            } else if (type.toLowerCase().endsWith("gem")) {
                bag.addGems(type, quantity);
            } else if (type.toLowerCase().equals("gold")) {
                bag.addGold(quantity);
            }
        }

        System.out.println(bag);
    }
}