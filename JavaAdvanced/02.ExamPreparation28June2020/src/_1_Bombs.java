import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class _1_Bombs {
    private static final int DATURA_BOMB = 40;
    private static final int CHERRY_BOMB = 60;
    private static final int SMOKE_DECOY_BOMB = 120;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> queueEffects = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queueEffects::offer);

        Deque<Integer> stackCasings = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stackCasings::push);

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;
        boolean bombPouchFilled = false;
        while (!queueEffects.isEmpty() && !stackCasings.isEmpty()) {
            int effect = queueEffects.peek();
            int casing = stackCasings.pop();
            int sum = effect + casing;

            if (sum == DATURA_BOMB) {
                queueEffects.poll();
                daturaBombs++;
            } else if (sum == CHERRY_BOMB) {
                queueEffects.poll();
                cherryBombs++;
            } else if (sum == SMOKE_DECOY_BOMB) {
                queueEffects.poll();
                smokeDecoyBombs++;
            } else {
                stackCasings.push(casing - 5);
            }

            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
                bombPouchFilled = true;
                break;
            }
        }

        StringBuilder output = new StringBuilder();
        if (bombPouchFilled) {
            output.append(String.format("Bene! You have successfully filled the bomb pouch!%n"));
        } else {
            output.append(String.format("You don't have enough materials to fill the bomb pouch.%n"));
        }

        if (queueEffects.isEmpty()) {
            output.append(String.format("Bomb Effects: empty%n"));
        } else {
            output.append("Bomb Effects: ");
            output.append(queueEffects.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            output.append(System.lineSeparator());
        }

        if (stackCasings.isEmpty()) {
            output.append(String.format("Bomb Casings: empty%n"));
        } else {
            output.append("Bomb Casings: ");
            output.append(stackCasings.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            output.append(System.lineSeparator());
        }

        output.append(String.format("Cherry Bombs: %d%n", cherryBombs));
        output.append(String.format("Datura Bombs: %d%n", daturaBombs));
        output.append(String.format("Smoke Decoy Bombs: %d%n", smokeDecoyBombs));
        System.out.println(output.toString().trim());
    }
}
