import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortProducts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        List<String> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String current = sc.nextLine();

            products.add(current);
        }

        Collections.sort(products);

        for (int i = 0; i < count; i++) {
            System.out.println((i+1) + "." + products.get(i));
        }
    }
}