import java.util.Scanner;

public class GuessThePassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        String pass = "s3cr3t!P@ssw0rd";
        if (password.equals(pass)) {
            System.out.println("Welcome");
        } else {
            System.out.println("Wrong password!");
        }
    }
}
