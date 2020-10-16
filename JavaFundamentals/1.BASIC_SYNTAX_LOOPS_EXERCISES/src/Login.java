import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String username = sc.nextLine();
        String password = "";
        for (int i = username.length()-1; i >= 0; i--) {
            password += ("" + username.charAt(i));
        }

        boolean loggedIn = false;
        for (int i = 0; i < 4; i++) {
            String passwordOutput = sc.nextLine();
            if (passwordOutput.equals(password)) {
                System.out.printf("User %s logged in.", username);
                loggedIn = true;
                break;
            }
            if (i < 3) {
                System.out.println("Incorrect password. Try again.");
            }
        }

        if (!loggedIn) {
            System.out.printf("User %s blocked!", username);
        }
    }
}
