import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _1_FlowerWreaths {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::valueOf)
                .forEach(lilies::push);

        Deque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::valueOf)
                .forEach(roses::offer);

        int wreaths = 0;
        int reservedFlowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int liliesToCheck = lilies.pop();
            int rosesToCheck = roses.poll();
            int result = liliesToCheck + rosesToCheck;
            if (result == 15) {
                wreaths++;
            } else if (result < 15) {
                reservedFlowers += result;
            } else {
                while (true) {
                    liliesToCheck -= 2;
                    result = liliesToCheck + rosesToCheck;
                    if (result == 15) {
                        wreaths++;
                        break;
                    } else if (result < 15) {
                        reservedFlowers += result;
                        break;
                    }
                }
            }
        }

        int fromReserve = 0;
        while (reservedFlowers >= 15) {
            reservedFlowers -= 15;
            fromReserve++;
        }

        wreaths += fromReserve;

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", (5 - wreaths));
        }
    }
}
