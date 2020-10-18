import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        System.out.println(findNumberOfVowels(input));
    }

    private static int findNumberOfVowels(String input) {
        char currentChar;
        int vowelsCount = 0;
        for (int i = 0; i < input.length(); i++) {
            currentChar = input.toLowerCase().charAt(i);
            switch (currentChar) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelsCount++;
                    break;
            }
        }
        return vowelsCount;
    }
}
