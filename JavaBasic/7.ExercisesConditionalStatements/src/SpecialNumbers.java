import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());

        int specialCounter = 0;
        for (int x = 1111; x < 10000; x++) {
            for (int y = 0; y < 4; y++) {
                char currentChar = String.valueOf(x).charAt(y);
                int currentNumber = Integer.parseInt(String.valueOf(currentChar));
                if (currentNumber > 0) {
                    if (number % currentNumber == 0) {
                        specialCounter++;
                    }
                }
            }

            if (specialCounter == 4) {
                System.out.printf("%d ", x);
            }
            specialCounter = 0;
        }
        //System.out.println(specialNumber);
    }
}
