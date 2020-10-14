import java.util.Scanner;

public class Acc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = sc.nextLine();
        String inputPassword = sc.nextLine();

        while (!password.equals(inputPassword)) {
            inputPassword = sc.nextLine();
        }

        System.out.printf("Welcome %s!", username);
    }
}
