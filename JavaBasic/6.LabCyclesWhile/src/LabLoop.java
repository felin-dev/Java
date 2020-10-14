import java.util.Scanner;

public class LabLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        while (!input.equals("Stop")) {
            input = sc.nextLine();
        }
    }
}
