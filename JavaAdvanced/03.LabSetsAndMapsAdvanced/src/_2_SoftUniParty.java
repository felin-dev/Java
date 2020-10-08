import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _2_SoftUniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Set<String> vips = new TreeSet<>();
        Set<String> regulars = new TreeSet<>();

        while (!input.equals("PARTY")) {
            if(Character.isDigit(input.charAt(0))) {
                vips.add(input);
            } else {
                regulars.add(input);
            }

            input = sc.nextLine();
        }

        input = sc.nextLine();

        while (!input.equals("END")) {
            vips.remove(input);
            regulars.remove(input);

            input = sc.nextLine();
        }

        System.out.println(vips.size() + regulars.size());
        if (!vips.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), vips));
        }
        if (!regulars.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), regulars));
        }
    }
}