import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split("\\s+");
        List<String> list = getList(data);

        String input = sc.nextLine();
        while (!"3:1".equals(input)) {
            String[] commands = input.split("\\s+");
            switch (commands[0]) {
                case "merge":
                    merge(list, commands[1], commands[2]);
                    break;
                case "divide":
                    //to do...
                    break;
            }

            input = sc.nextLine();
        }

        System.out.println(String.join(" ", list));
    }

    private static void merge(List<String> list, String firstIndex, String secondIndex) {
        int start = Integer.parseInt(firstIndex);
        int end = Integer.parseInt(secondIndex);
        for (int i = start; i < end - 1; i++) {
            String concatenate = list.get(i) + list.get(i + 1);
            list.remove(i);
            list.remove(i);
            list.add(i, concatenate);
        }
    }

    private static List<String> getList(String[] input) {
        List<String> list = new ArrayList<>();
        for (String s : input) {
            list.add(s);
        }

        return list;
    }
}
