import java.util.Scanner;

public class MetersToKilometers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double meters = Integer.parseInt(sc.nextLine());
        System.out.printf("%.2f", meters / 1000);
    }
}
