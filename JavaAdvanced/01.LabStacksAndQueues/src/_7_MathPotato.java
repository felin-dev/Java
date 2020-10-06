import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _7_MathPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> kids = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        int timesToJump = Integer.parseInt(sc.nextLine());

        for (int currentCycle = 1, startingIndex = 0; kids.size() != 1; currentCycle++) {
            int kidToRemove = (startingIndex + timesToJump % kids.size() - 1 + kids.size()) % kids.size();
            startingIndex = kidToRemove;
            if (isPrime(currentCycle)) {
                System.out.println("Prime " + kids.get(kidToRemove));
            } else {
                System.out.println("Removed " + kids.remove(kidToRemove));
            }
        }

        System.out.print("Last is " + kids.get(0));
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2, sqrt = (int) Math.sqrt(n); i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}