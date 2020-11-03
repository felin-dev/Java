import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartyHost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+", 2);
            String name = tokens[0];
            if ("is going!".equals(tokens[1])) {
                if (list.contains(name)) {
                    System.out.println(name + " is already in the list!");
                } else {
                    list.add(name);
                }
            } else if ("is not going!".equals(tokens[1])) {
                if (list.contains(name)) {
                    list.remove(name);
                } else {
                    System.out.println(name + " is not in the list!");
                }
            }
        }

        System.out.println(String.join("\n", list));
    }
}
