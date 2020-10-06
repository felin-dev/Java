import java.util.ArrayDeque;
import java.util.Scanner;

public class _8_BrowserFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String navigation = sc.nextLine();
        String currentAddress;
        while (!navigation.equals("Home")) {
            if (navigation.equals("back")) {
                if (history.isEmpty() || history.size() == 1) {
                    System.out.println("no previous URLs");
                    navigation = sc.nextLine();
                    continue;
                } else {
                    forward.addFirst(history.pop());
                    currentAddress = history.peek();
                }
            } else if (navigation.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                    navigation = sc.nextLine();
                    continue;
                } else {
                    currentAddress = forward.peek();
                    history.push(forward.poll());
                }
            } else {
                history.push(navigation);
                currentAddress = navigation;
                forward.clear();
            }

            System.out.println(currentAddress);
            navigation = sc.nextLine();
        }
    }
}