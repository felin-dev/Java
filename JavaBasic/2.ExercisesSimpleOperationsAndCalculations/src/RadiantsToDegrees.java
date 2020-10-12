import java.util.Scanner;

public class RadiantsToDegrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radians = Double.parseDouble(sc.nextLine());
        double degrees = (radians * 180) / Math.PI;
        System.out.printf("%.0f", degrees);
    }
}
