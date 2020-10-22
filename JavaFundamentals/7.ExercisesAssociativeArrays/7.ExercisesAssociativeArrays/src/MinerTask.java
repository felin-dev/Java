import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> items = new LinkedHashMap<>();

        String item = sc.nextLine();
        while (!"stop".equals(item)) {
            int count = Integer.parseInt(sc.nextLine());
            items.putIfAbsent(item, 0);
            int newCount = items.get(item) + count;
            items.put(item, newCount);

            item = sc.nextLine();
        }

        items
                .forEach((k, v) -> System.out.println(String.format("%s -> %d", k, v)));
    }
}
