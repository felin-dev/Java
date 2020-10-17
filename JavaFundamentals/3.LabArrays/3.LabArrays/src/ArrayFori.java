import java.util.Scanner;

public class ArrayFori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            names[i] = sc.nextLine();
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
