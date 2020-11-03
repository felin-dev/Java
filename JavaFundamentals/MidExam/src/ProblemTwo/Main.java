package ProblemTwo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> modificationList = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!"end".equals(input)) {
            String[] commands = input.split("\\s+");
            String initialCommand = commands[0];
            switch (initialCommand) {
                case "swap" : {
                    int indexOne = Integer.parseInt(commands[1]);
                    int indexTwo = Integer.parseInt(commands[2]);
                    int firstNumber = modificationList.get(indexOne);
                    int secondNumber = modificationList.get(indexTwo);
                    modificationList.set(indexOne, secondNumber);
                    modificationList.set(indexTwo, firstNumber);
//                    modificationList.remove(Integer.valueOf(secondNumber));
//                    modificationList.add(indexOne, secondNumber);
//                    modificationList.remove(Integer.valueOf(firstNumber));
//                    modificationList.add(indexTwo, firstNumber);
                    break;
                }
                case "multiply" : {
                    int indexOne = Integer.parseInt(commands[1]);
                    int indexTwo = Integer.parseInt(commands[2]);
                    int multiply = modificationList.get(indexOne) * modificationList.get(indexTwo);
                    modificationList.remove(indexOne);
                    modificationList.add(indexOne, multiply);
                    break;
                }
                case "decrease" : {
                    for (int i = 0; i < modificationList.size(); i++) {
                        int currentNumber = modificationList.get(i);
                        currentNumber--;
                        modificationList.set(i, currentNumber);
                    }
                    break;
                }
            }

            input = sc.nextLine();
        }

        for (int i = 0; i < modificationList.size() - 1; i++) {
            System.out.print(modificationList.get(i) + ", ");
        }
        System.out.print(modificationList.get(modificationList.size()-1));
    }
}
