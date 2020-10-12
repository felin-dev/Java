import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.print("Hello, " + name + "!");
    }
}
