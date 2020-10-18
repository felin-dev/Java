import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();
        int repeating = Integer.parseInt(sc.nextLine());

        String output = repeatString(string, repeating);
        System.out.println(output);
    }

    private static String repeatString(String string, int repeating) {
        String output = "";
        for (int i = 0; i < repeating; i++) {

            output = output.concat(string);
        }
        return output;
    }
}
