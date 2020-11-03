import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = (int) sc.nextLine().charAt(0);
        int second = (int) sc.nextLine().charAt(0);
        String input = sc.nextLine();

        int min = Math.min(first, second);
        int max = Math.max(first, second);
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            int currentChar = input.charAt(i);
            if (currentChar > min && currentChar < max) {
                sum += currentChar;
            }
        }

        System.out.println(sum);
    }
}