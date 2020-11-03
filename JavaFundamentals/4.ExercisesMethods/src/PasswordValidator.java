import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String password = sc.nextLine();
        validatePassword(password);
    }

    private static void validatePassword(String password) {
        boolean validPassword = true;
        if (!passwordLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            validPassword = false;
        }

        if (!validCharacters(password)) {
            System.out.println("Password must consist only of letters and digits");
            validPassword = false;
        }

        if (!passwordDigits(password)) {
            System.out.println("Password must have at least 2 digits");
            validPassword = false;
        }

        if (validPassword) {
            System.out.println("Password is valid");
        }
    }

    private static boolean validCharacters(String password) {
        boolean validCharacters = true;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (currentChar < 48 || currentChar > 57 && currentChar < 65 || currentChar > 90 && currentChar < 97 || currentChar > 172) {
                validCharacters = false;
                break;
            }
        }

        return validCharacters;
    }

    private static boolean passwordDigits(String password) {
        boolean enoughDigits = false;
        int numberOfDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (currentChar >= 48 && currentChar <= 57) {
                numberOfDigits++;
            }
        }

        if (numberOfDigits >= 2) {
            enoughDigits = true;
        }

        return enoughDigits;
    }

    private static boolean passwordLength(String password) {
        boolean passwordLength = true;
        if (password.length() < 6 || password.length() > 10) {
            passwordLength = false;
        }

        return passwordLength;
    }
}
