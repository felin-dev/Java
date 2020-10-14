import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        double oddSum = 0;
        double oddMin = 1000000000.0;
        double oddMax = -1000000000.0;

        double evenSum = 0;
        double evenMin = 1000000000.0;
        double evenMax = -1000000000.0;

        for (int i = 1; i <= n; i++) {
            double current = Double.parseDouble(sc.nextLine());

            if (i % 2 == 0) {
                evenSum += current;
                if (evenMax < current) {
                    evenMax = current;
                }

                if (evenMin > current) {
                    evenMin = current;
                }
            } else {
                oddSum +=current;
                if (oddMax < current) {
                    oddMax = current;
                }

                if (oddMin > current) {
                    oddMin = current;
                }
            }
        }

        System.out.printf("OddSum=%.2f,%n",oddSum);
        if (oddMin == 1000000000.0) {
            System.out.println("OddMin=No,");
        } else {
            System.out.printf("OddMin=%.2f,%n",oddMin);
        }
        if (oddMax == -1000000000.0) {
            System.out.println("OddMax=No,");
        } else {
            System.out.printf("OddMax=%.2f,%n",oddMax);
        }
        System.out.printf("EvenSum=%.2f,%n",evenSum);
        if (evenMin == 1000000000.0) {
            System.out.println("EvenMin=No,");
        } else {
            System.out.printf("EvenMin=%.2f,%n",evenMin);
        }
        if (evenMax == -1000000000.0) {
            System.out.println("EvenMax=No");
        } else {
            System.out.printf("EvenMax=%.2f%n",evenMax);
        }
    }
}
