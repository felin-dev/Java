import java.util.Scanner;

public class MakeInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        double percent = Double.parseDouble(scan.nextLine());

        //find volume
        double liter = length * width * height / 1000.0;
        double stuff = liter * percent / 100;
        double totalLiters = liter - stuff;
        System.out.printf("%.3f", totalLiters);
    }
}
