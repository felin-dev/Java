import java.util.*;
import java.util.stream.Collectors;

public class _3_War {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayer = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int firstCard;
        int secondCard;
        int rounds = 50;
        while (rounds-- > 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
                firstCard = firstPlayer.iterator().next();
                firstPlayer.remove(firstCard);

                secondCard = secondPlayer.iterator().next();
                secondPlayer.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            } else if (secondCard > firstCard) {
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
