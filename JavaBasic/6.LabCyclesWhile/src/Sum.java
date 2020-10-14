import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int sum = 0;
        while(!input.equals("Stop")) {
            int currentNumber = Integer.parseInt(input);
            sum += currentNumber;
            input = sc.nextLine();
        }
        System.out.println(sum);
    }
}
