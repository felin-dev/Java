import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String calculationType = sc.nextLine();
        int numberOne = Integer.parseInt(sc.nextLine());
        int numberTwo = Integer.parseInt(sc.nextLine());

        int total = calculation(numberOne, numberTwo, calculationType);
        System.out.println(total);
    }

    private static int calculation(int numberOne, int numberTwo, String calculationType) {
        int total = 0;
        switch (calculationType) {
            case "add":
                return numberOne + numberTwo;
            case "subtract":
                return numberOne - numberTwo;
            case "multiply":
                return numberOne * numberTwo;
            case "divide":
                return numberOne / numberTwo;
            default:
                System.out.println("Error!");
        }
        return total;
    }
}
