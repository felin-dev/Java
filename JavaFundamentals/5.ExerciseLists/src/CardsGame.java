import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> firstDeck = getArray(sc);
        List<Integer> secondDeck = getArray(sc);

        int length = firstDeck.size();
        for (int i = 0; i < length - 1; i++) {
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
            int firstDeckCard = firstDeck.get(i);
            int secondDeckCard = secondDeck.get(i);
            if (firstDeckCard == secondDeckCard) {
                firstDeck.remove(i);
                secondDeck.remove(i);
            } else if (firstDeckCard > secondDeckCard) {
                firstDeck.remove(i);
                firstDeck.add(firstDeckCard);
                firstDeck.add(secondDeckCard);
                secondDeck.remove(i);
            } else {
                secondDeck.remove(i);
                secondDeck.add(secondDeckCard);
                secondDeck.add(firstDeckCard);
                firstDeck.remove(i);
            }

            i = -1;
        }

        int firstDeckSum = getSum(firstDeck);
        int secondDeckSum = getSum(secondDeck);

        if (firstDeckSum > secondDeckSum) {
            System.out.println("First player wins! Sum: " + firstDeckSum);
        } else {
            System.out.println("Second player wins! Sum: " + secondDeckSum);
        }
    }

    private static Integer getSum(List<Integer> secondDeck) {
        int sum = 0;
        for (Integer number : secondDeck) {
            sum += number;
        }
        return sum;
    }

    private static List<Integer> getArray(Scanner sc) {
        String[] temp = sc.nextLine().split("\\s+");
        List<Integer> list = new ArrayList<>();
        for (String element : temp) {
            list.add(Integer.parseInt(element));
        }

        return list;
    }
}
