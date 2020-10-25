import java.util.Scanner;

public class ActivationKeys_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String activationKey = sc.nextLine();
        String input = sc.nextLine();
        while (!"Generate".equals(input)) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];
            //The first line of the input will be your raw activation key. It will consist of letters and numbers only.
            //After that, until the "Generate" command is given, you will be receiving strings with
            // instructions for different operations that need to be performed upon the raw activation key.
            //There are several types of instructions, split by ">>>":
            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (activationKey.contains(substring)) {
                        System.out.println(String.format("%s contains %s", activationKey, substring));
                    } else {
                        System.out.println("Substring not found!");
                    }
                    //•	Contains>>>{substring} – checks if the raw activation key contains the given substring.
                    //o	If it does prints: "{raw activation key} contains {substring}".
                    //o	If not, prints: "Substring not found!"
                    break;
                case "Flip":{
                    String lowerOrUpper = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    activationKey = getUpperOrLower(activationKey, lowerOrUpper, startIndex, endIndex);
                    printKey(activationKey);
                    break;}
                case "Slice":{
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    activationKey = slice(activationKey, startIndex, endIndex);

                    //•	Slice>>>{startIndex}>>>{endIndex}
                    //o	Deletes the characters between the start and end indices (end index is exclusive).
                    //o	Both indices will be valid.
                    //o	Prints the activation key.
                    printKey(activationKey);
                    break;}
            }

            input = sc.nextLine();
        }

        System.out.print("Your activation key is: ");
        printKey(activationKey);
    }

    private static String slice(String activationKey, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder(activationKey);
        sb.replace(startIndex, endIndex, "");

        return sb.toString();
    }

    private static String getUpperOrLower(String activationKey, String lowerOrUpper, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();
        if (startIndex > 0) {
            sb.append(activationKey, 0, startIndex);
        }

        switch (lowerOrUpper) {
            case "Upper":
                sb.append(activationKey.substring(startIndex, endIndex).toUpperCase());
                break;
            case "Lower":
                sb.append(activationKey.substring(startIndex, endIndex).toLowerCase());
                break;
        }

        if (endIndex < activationKey.length()) {
            sb.append(activationKey.substring(endIndex));
        }
        //•	Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}
        //o	Changes the substring between the given indices (the end index is exclusive) to upper or lower case.
        //o	All given indexes will be valid.
        //o	Prints the activation key.
        return sb.toString();
    }

    private static void printKey(String activationKey) {
        System.out.println(activationKey);
    }
}