import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOne = Integer.parseInt(sc.nextLine());
        String operator = sc.nextLine();
        int numberTwo = Integer.parseInt(sc.nextLine());
        int result = operation(numberOne, numberTwo, operator);
        System.out.println(result);
    }

    private static int operation(int numberOne, int numberTwo, String operator) {
        switch (operator) {
            case "+": return numberOne + numberTwo;
            case "-": return numberOne - numberTwo;
            case "*": return numberOne * numberTwo;
            case "/": return numberOne / numberTwo;
            default:
                throw new UnsupportedOperationException(operator);
        }
    }
}
