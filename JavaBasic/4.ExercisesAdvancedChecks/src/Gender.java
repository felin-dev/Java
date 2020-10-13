import java.security.InvalidAlgorithmParameterException;
import java.util.Scanner;

public class Gender {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String gender = sc.nextLine();
        int age = sc.nextInt();

        if (gender.equals("f")) {
            if (age < 16) {
                System.out.println("Miss");
            } else {
                System.out.println("Ms.");
            }
        }

        if (gender.equals("m")) {
            if (age < 16) {
                System.out.println("Mister");
            } else {
                System.out.println("Mr.");
            }
        }
    }
}
