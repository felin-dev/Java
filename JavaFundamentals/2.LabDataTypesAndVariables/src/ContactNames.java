import java.util.Scanner;

public class ContactNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstName= sc.nextLine();
        String lastName = sc.nextLine();
        String separator = sc.nextLine();

        System.out.printf("%s%s%s", firstName, separator, lastName);
    }
}
