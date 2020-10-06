import java.util.ArrayDeque;
import java.util.Scanner;

public class _1_BrowserInstructions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String currentAddress = "";
        String navigation = sc.nextLine();
        while (!navigation.equals("Home")) {
            if (navigation.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    navigation = sc.nextLine();
                    continue;
                } else {
                    currentAddress = history.pop();
                }
            } else {
                if (!currentAddress.isEmpty()) {
                    history.push(currentAddress);
                }

                currentAddress = navigation;
            }

            System.out.println(currentAddress);
            navigation = sc.nextLine();
        }
    }
}