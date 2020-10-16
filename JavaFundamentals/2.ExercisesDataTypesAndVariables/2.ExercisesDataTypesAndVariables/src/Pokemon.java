import java.util.Scanner;

public class Pokemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startPokePower = Integer.parseInt(sc.nextLine());
        int distanceBetweenTargets = Integer.parseInt(sc.nextLine());
        int exhaustion = Integer.parseInt(sc.nextLine());

        int currentPokePower = startPokePower;
        int targetsEliminated = 0;
        while (currentPokePower >= distanceBetweenTargets) {
            currentPokePower -= distanceBetweenTargets;
            targetsEliminated++;
            boolean isHalfPower = currentPokePower == startPokePower / 2.0;
            boolean isSafeToDivide = exhaustion != 0;
            if (isHalfPower && isSafeToDivide) {
                currentPokePower /= exhaustion;
            }
        }

        System.out.println(currentPokePower);
        System.out.println(targetsEliminated);
    }
}
