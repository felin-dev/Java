import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1_LootBox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> dequeBox = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(dequeBox::offer);
        Deque<Integer> stackBox = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stackBox::push);

        List<Integer> claimedItems = new ArrayList<>();
        while (!dequeBox.isEmpty() && !stackBox.isEmpty()) {
            int secondBoxItem = stackBox.pop();
            int sum = (!dequeBox.isEmpty() ? dequeBox.peek() : 0) + secondBoxItem;
            if (sum % 2 == 0) {
                dequeBox.poll();
                claimedItems.add(sum);
            } else {
                dequeBox.offer(secondBoxItem);
            }

            if (dequeBox.isEmpty()) {
                System.out.println("First lootbox is empty");
            }

            if (stackBox.isEmpty()) {
                System.out.println("Second lootbox is empty");
            }
        }

        int totalSum = 0;
        for (Integer itemsRating : claimedItems) {
            totalSum += itemsRating;
        }

        if (totalSum >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", totalSum);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", totalSum);
        }
    }
}
