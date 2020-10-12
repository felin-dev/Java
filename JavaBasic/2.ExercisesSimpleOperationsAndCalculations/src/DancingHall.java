import java.util.Scanner;

public class DancingHall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double lenght = Double.parseDouble(sc.nextLine());
        double width = Double.parseDouble(sc.nextLine());
        double wardrobeSide = Double.parseDouble(sc.nextLine());
        double hallArea = lenght * width * 10000;
        double wardrob = wardrobeSide * wardrobeSide * 10000;
        double bench = hallArea / 10;
        double peopleSpace = 7040;
        double freeHallArea = hallArea - bench - wardrob;
        double peopleDancing = freeHallArea / peopleSpace;
        double down = Math.floor(peopleDancing);
        System.out.printf("%.0f", down);
    }
}
