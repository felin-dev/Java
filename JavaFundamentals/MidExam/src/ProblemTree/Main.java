package ProblemTree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        int average = sum / numbers.size();

        List<Integer> numbersAboveAverage = new ArrayList<>();
        getNumbersAboveAverage(numbers, average, numbersAboveAverage);
        Collections.sort(numbersAboveAverage);
        Collections.reverse(numbersAboveAverage);

        if (numbersAboveAverage.isEmpty()) {
            System.out.println("No");
        } else {
            printNumbers(numbersAboveAverage);
        }
    }

    private static void getNumbersAboveAverage(List<Integer> numbers, int average, List<Integer> numbersAboveAverage) {
        for (int currentNumber : numbers) {
            if (currentNumber > average) {
                numbersAboveAverage.add(currentNumber);
            }
        }
    }

    private static void printNumbers(List<Integer> numbers) {
        List<Integer> fiveNumbers = new ArrayList<>();
        int maxNumbers = 0;
        maxNumbers = Math.min(numbers.size(), 5);
        for (int i = 0; i < maxNumbers; i++) {
            int currentNumber = numbers.get(i);
            fiveNumbers.add(fiveNumbers.size(), currentNumber);
        }
        for (int i = 0; i < fiveNumbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + " ");
        }

        System.out.print(fiveNumbers.get(fiveNumbers.size() - 1));
    }
}