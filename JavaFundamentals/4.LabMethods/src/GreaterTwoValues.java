import java.util.Scanner;

public class GreaterTwoValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String type = sc.nextLine();
        String first = sc.nextLine();
        String second = sc.nextLine();
        switch (type) {
            case "int":
                int maxInt = getMax(first, second);
                System.out.println(maxInt);
                break;
            case "char":
                char maxChar = getMaxChar(first, second);
                System.out.println(maxChar);
                break;
            case "string":
                String maxString = getMaxString(first, second);
                System.out.println(maxString);
                break;
        }
    }

    private static int getMax(String first, String second) {
        int firstNum = Integer.parseInt(first);
        int secondNum = Integer.parseInt(second);
        return Math.max(firstNum, secondNum);
    }

    private static char getMaxChar(String first, String second) {
        char firstChar = first.charAt(0);
        char secondChar = second.charAt(0);
        if (firstChar > secondChar) {
            return firstChar;
        } else {
            return secondChar;
        }
    }

    private static String getMaxString(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        } else {
            return second;
        }
    }
}
