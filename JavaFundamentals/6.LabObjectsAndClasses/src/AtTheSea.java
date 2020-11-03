import java.util.Scanner;

public class AtTheSea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Въведете броя на дните за почивката.");
        int days = Integer.parseInt(sc.nextLine()) - 1;
        System.out.println("Въведете броя на хората.");
        int people = Integer.parseInt(sc.nextLine());
        System.out.println("Въведете цената на спането.");
        int pricePerDay = Integer.parseInt(sc.nextLine());
        int sum = (days * pricePerDay) * people;
        System.out.printf("Цената на почивката е %d за %d дни за %d човека.", sum, days, people);
    }
}
