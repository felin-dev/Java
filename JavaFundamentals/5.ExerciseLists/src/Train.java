import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> train = readIntList(sc);
        int capacity = Integer.parseInt(sc.nextLine());

        String input = sc.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");
            if ("Add".equals(tokens[0])) {
                int people = Integer.parseInt(tokens[1]);
                train.add(people);
            } else {
                int peopleToAdd = Integer.parseInt(tokens[0]);
                for (int waggon = 0; waggon < train.size(); waggon++) {
                    int sum = train.get(waggon) + peopleToAdd;
                    if (train.get(waggon) + peopleToAdd <= capacity) {
                        train.set(waggon, sum);
                        break;
                    }
                }
            }

            input = sc.nextLine();
        }

        printTrain(train);
    }

    private static void printTrain(List<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }
    }

    private static List<Integer> readIntList(Scanner sc) {
        List<Integer> train = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
        for (String element : input) {
            train.add(Integer.parseInt(element));
        }

        return train;
    }
}
