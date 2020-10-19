import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationsAdvanced {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = sc.nextLine();
        while (!command.equals("end")) {
            String[] commandParts = command.split(" ");
            String commandName = commandParts[0];

            switch (commandName) {
                case "Contains":
                    contains(numbers, commandParts);
                    break;
                case "Print":
                    printEvenOrOdd(numbers, commandParts);
                    break;
                case "Get":
                    getSum(numbers);
                    break;
                case "Filter":
                    filter(numbers, commandParts);
                    break;
                default:
                    throw new IllegalStateException(commandName);
            }

            command = sc.nextLine();
        }
    }

    private static void filter(List<Integer> numbers, String[] command) {
        int wantedNumber = Integer.parseInt(command[2]);
        switch (command[1]) {
            case "<":
                for (int number : numbers) {
                    if (number < wantedNumber) {
                        System.out.print(number + " ");
                    }
                }

                System.out.println();
                break;
            case ">":
                for (int number : numbers) {
                    if (number > wantedNumber) {
                        System.out.print(number + " ");
                    }
                }

                System.out.println();
                break;
            case "<=":
                for (int number : numbers) {
                    if (number <= wantedNumber) {
                        System.out.print(number + " ");
                    }
                }

                System.out.println();
                break;
            case ">=":
                for (int number : numbers) {
                    if (number >= wantedNumber) {
                        System.out.print(number + " ");
                    }
                }

                System.out.println();
                break;
            default:
                throw new IllegalStateException(command[1]);
        }
    }

    private static void getSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        System.out.println(sum);
    }

    private static void printEvenOrOdd(List<Integer> numbers, String[] commandParts) {
        String evenOrOdd = commandParts[1];
        for (int number : numbers) {
            if (evenOrOdd.equals("even")) {
                if (number % 2 == 0) {
                    System.out.print(number + " ");
                }
            } else {
                if (number % 2 != 0) {
                    System.out.print(number + " ");
                }
            }
        }

        System.out.println();
    }

    private static void contains(List<Integer> numbers, String[] commandPart) {
        boolean contains = false;
        int wantedNumber = Integer.parseInt(commandPart[1]);
        for (int number : numbers) {
            if (number == wantedNumber) {
                contains = true;
                break;
            }
        }

        if (contains) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }
}