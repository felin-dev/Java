import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String list = sc.nextLine();
        String listTwo = sc.nextLine();

        List<Integer> first = inputToList(list);
        List<Integer> second = inputToList(listTwo);

        int minLength = Math.min(first.size(), second.size());

        for (int i = 0; i < minLength; i++) {
            System.out.print(first.get(i) + " ");
            System.out.print(second.get(i) + " ");
        }

        printAfterIndex(first, minLength);
        printAfterIndex(second, minLength);

    }

    private static void printAfterIndex(List<Integer> list, int startingIndex) {
        for (int i = startingIndex; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static List<Integer> inputToList(String input) {
        String[] parts = input.split(" ");

        List<Integer> result = new ArrayList<>();

        for (String part : parts) {
            int current = Integer.parseInt(part);

            result.add(current);
        }

        return result;
    }
}