package PassReset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] password = sc.nextLine().split("");
        List<String> tempPassword = new ArrayList<>();

        String input = sc.nextLine();
        while (!"Done".equals(input)) {
            String[] commands = input.split("\\s+");
            String initialCommand = commands[0];
            switch (initialCommand) {
                case "TakeOdd" : {
                    for (int i = 0; i < password.length; i++) {
                        if (i % 2 != 0) {
                            tempPassword.add(tempPassword.size(), password[i]);
                        }
                    }
                    password = getPasswordFromTempPassword(tempPassword);
                    printPassword(password);
                    tempPassword.clear();
                    break;
                }
                case "Cut" : {
                    int indexToCut = Integer.parseInt(commands[1]);
                    int lengthToCut = indexToCut + Integer.parseInt(commands[2]);
                    fillTempPasswordFromString(password, tempPassword);
                    if (indexToCut < 0 || indexToCut >= tempPassword.size()
                            || lengthToCut < 0) {
                        break;
                    }
                    if (lengthToCut >= tempPassword.size()) {
                        lengthToCut = tempPassword.size() - 1;
                    }
                    for (int i = indexToCut; i < lengthToCut; i++) {
                        tempPassword.remove(i);
                        i--;
                        lengthToCut--;
                    }
                    password = getPasswordFromTempPassword(tempPassword);
                    printPassword(password);
                    tempPassword.clear();
                    break;
                }
                case "Substitute" : {
                    String substring = commands[1];
                    String substitute = commands[2];
                    String tempStringPassword = String.join("", password);
                    if (tempStringPassword.contains(substring)) {
                        String replacedPassword = tempStringPassword.replaceAll(substring, substitute);
                        password = replacedPassword.split("");
                        printPassword(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
                }
            }

            input = sc.nextLine();
        }

        System.out.print("Your password is: ");
        printPassword(password);
    }

    private static String[] getPasswordFromTempPassword(List<String> tempPassword) {
        String[] password;
        String stringJoin = String.join("", tempPassword);
        String[] split = stringJoin.split("");
        password = split.clone();
        return password;
    }

    private static void fillTempPasswordFromString(String[] password, List<String> tempPassword) {
        for (int i = 0; i < password.length; i++) {
            tempPassword.add(i, password[i]);
        }
    }

    private static void printPassword(String[] password) {
        for (String digit : password) {
            System.out.print(digit);
        }
        System.out.println();
    }
}
