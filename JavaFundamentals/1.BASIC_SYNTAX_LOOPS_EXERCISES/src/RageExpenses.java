import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(sc.nextLine());
        double headsetPrice = Double.parseDouble(sc.nextLine());
        double mousePrice = Double.parseDouble(sc.nextLine());
        double keyboardPrice = Double.parseDouble(sc.nextLine());
        double monitorPrice = Double.parseDouble(sc.nextLine());

        double brokenHeadset = 0;
        double brokenMouse = 0;
        double brokenKeyboard = 0;
        double brokenMonitor = 0;
        boolean brokenHeadTime = false;
        int brokenKeyboardTime = 0;
        for (int i = 1; i <= lostGamesCount; i++) {
            if (i % 2 == 0) {
                brokenHeadset++;
                brokenHeadTime = true;
            }
            if (i % 3 == 0) {
                brokenMouse++;
                if (brokenHeadTime) {
                    brokenKeyboard++;
                    brokenKeyboardTime ++;
                    if (brokenKeyboardTime == 2) {
                        brokenMonitor++;
                        brokenKeyboardTime = 0;
                    }
                }
            }
            brokenHeadTime = false;
        }

        double headsetTotal = brokenHeadset * headsetPrice;
        double mouseTotal = brokenMouse * mousePrice;
        double keyboardTotal = brokenKeyboard * keyboardPrice;
        double monitorTotal = brokenMonitor * monitorPrice;

        double sum = headsetTotal + mouseTotal + keyboardTotal + monitorTotal;
        System.out.printf("Rage expenses: %.2f lv.", sum);
    }
}
