import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int side = Integer.parseInt(input);
        int area = side * side;
        System.out.println(area);
    }
}
