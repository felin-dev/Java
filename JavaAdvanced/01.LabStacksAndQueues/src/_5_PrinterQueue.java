import java.util.ArrayDeque;
import java.util.Scanner;

public class _5_PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String task = sc.nextLine();
        while (!task.equals("print")) {
            if (!task.equals("cancel")) {
                printerQueue.offer(task);
            } else {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.poll());
                }
            }

            task = sc.nextLine();
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}