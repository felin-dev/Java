import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int trainWagons = Integer.parseInt(sc.nextLine());
        int[] peopleInside = new int[trainWagons];
        for (int i = 0; i < trainWagons; i++) {
            int currentNumber = Integer.parseInt(sc.nextLine());
            peopleInside[i] = currentNumber;

        }

        int sum = 0;
        for (int people : peopleInside) {
            System.out.print(people + " ");
            sum += people;
        }
        System.out.println("\n" + sum);
    }
}
