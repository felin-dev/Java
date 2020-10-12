import java.util.Scanner;

public class InchToCM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double inches = Double.parseDouble(input);
        double cantimeters = inches * 2.54;
        System.out.println(cantimeters);
    }
}
