import java.util.ArrayDeque;
import java.util.Scanner;

public class _2_SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbersAndOperations = sc.nextLine().split("\\s+");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        char currentOperation = 0;
        boolean operate = false;
        for (int i = 0; i < numbersAndOperations.length; i++) {
            if (!numbersAndOperations[i].equals("+") && !numbersAndOperations[i].equals("-")) {
                if (operate) {
                    int lastNumber = numbers.pop();
                    int currentNumber = Integer.parseInt(numbersAndOperations[i]);
                    int result = 0;
                    if (currentOperation == '+') {
                        result = lastNumber + currentNumber;
                    } else if (currentOperation == '-') {
                        result = lastNumber - currentNumber;
                    }
                    numbers.push(result);
                    operate = false;
                } else {
                    numbers.push(Integer.parseInt(numbersAndOperations[i]));
                }
            } else {
                String newOperation = numbersAndOperations[i];
                currentOperation = newOperation.charAt(0);
                operate = true;
            }
        }

        System.out.println(numbers.pop());
    }
}