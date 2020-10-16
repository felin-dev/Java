import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int multiplicationNumber = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= 10; i++) {
            int currentMultiplicationNumber = i;
            int currentMultiplication = multiplicationNumber * currentMultiplicationNumber;
            System.out.printf("%n %d X %d = %d", multiplicationNumber, currentMultiplicationNumber, currentMultiplication);
        }
    }
}
