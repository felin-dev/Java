package CarSecond;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");

            if (tokens.length == 1) {
                Car car = new Car(tokens[0]);
                System.out.println(car.carInfo());
            } else if (tokens.length == 2) {
                Car car = new Car(tokens[0], tokens[1]);
                System.out.println(car.carInfo());
            } else {
                Car car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
                System.out.println(car.carInfo());
            }
        }
    }
}