import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int currentYield = Integer.parseInt(sc.nextLine());
        int spiceProduced = 0;
        int days = 0;
        while (currentYield >= 100) {
            spiceProduced += currentYield - 26;
            currentYield -= 10;
            days++;
        }

        if (spiceProduced >= 26) {
            spiceProduced -= 26;
        }
        System.out.println(days);
        System.out.println(spiceProduced);
    }
}