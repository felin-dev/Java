import java.util.Scanner;

public class CountingFromTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstNumberString = sc.nextLine();
        String secondNumberString = sc.nextLine();

        int firstNumber = Integer.parseInt(firstNumberString);
        int secondNumber = Integer.parseInt(secondNumberString);
        while (firstNumber <= secondNumber) {
            System.out.println(firstNumber);
            firstNumber++;
        }
    }
}
