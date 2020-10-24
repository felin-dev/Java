package PasswordResset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] startingPassword = sc.nextLine().split("");
        List<String> password = new ArrayList<>(Arrays.asList(startingPassword));

        String input = sc.nextLine();
        while (!"Done". equals(input)) {
            String[] commands = input.split("\\s+");
            String currentCommand = commands[0];
            switch (currentCommand) {
                case "TakeOdd" : {
                    List<String> tempPassword = new ArrayList<>();
                    getOddPasswordIndexes(password, tempPassword);
                    password.clear();
                    password.addAll(tempPassword);
                    printPassword(password);
                    //Takes only the characters at odd indices and concatenates them together to
                    //obtain the new raw startingPassword and then prints it.
                    break;
                }
                case "Cut" :
                    //•	Cut {index} {length}
                    //o	Gets the substring with the given length starting from the given index from the startingPassword and removes its first occurrence of it, then prints the startingPassword on the console.
                    //o	The given index and length will always be valid.
                    int startIndex = Integer.parseInt(commands[1]);
                    int length = startIndex + Integer.parseInt(commands[2]);
                    if (startIndex < 0 || startIndex >= password.size()
                            || length < 0) {
                        break;
                    }
                    if (length >= password.size()) {
                        length = password.size() - 1;
                    }
                    for (int i = startIndex; i < length; i++) {
                        password.remove(i);
                        length--;
                        i--;
                    }
                    printPassword(password);
                    break;
                case "Substitute" :
                    //•	Substitute {substring} {substitute}
                    //o	If the raw password contains the given substring, replaces all of its
                    //occurrences with the substitute text given and prints the result.
                    //o	If it doesn’t, prints "Nothing to replace!"
                    String substring = commands[1];
                    String substitute = commands[2];

                    String passwordString = String.join("",password);
                    if (passwordString.contains(substring)) {
                        String replacedPassword = passwordString.replaceAll(substring, substitute);
                        String[] replacedSplitPassword = replacedPassword.split("");
                        System.out.println(replacedPassword);
                        password.clear();
                        password.addAll(Arrays.asList(replacedSplitPassword));
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input = sc.nextLine();
        }

        System.out.print("Your password is: ");
        printPassword(password);
    }

    private static void printPassword(List<String> password) {
        for (String character : password) {
            System.out.print(character);
        }
        System.out.println();
    }

    private static void getOddPasswordIndexes(List<String> password, List<String> tempPassword) {
        for (int i = 1; i < password.size(); i++) {
            if (i % 2 != 0) {
                String currentChar = password.get(i);
                tempPassword.add(currentChar);
            }
        }
    }
}
