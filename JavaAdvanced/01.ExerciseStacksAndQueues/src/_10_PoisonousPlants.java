import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _10_PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());
        String[] plants = reader.readLine().split("\\s+");

        for (String plant : plants) {
            stack.push(Integer.valueOf(plant));
        }

        int daysUntilPlantsSurvive = getLivingPlats(stack);
        System.out.println(daysUntilPlantsSurvive);
    }

    private static int getLivingPlats(Deque<Integer> stack) {
        int days = 0;
        Deque<Integer> tempQueue = new ArrayDeque<>();
        int counter;
        while (true) {
            int previousSize = stack.size();
            counter = 0;
            while (!stack.isEmpty()) {
                int currentPlant = stack.pop();
                if (stack.peek() != null) {
                    int nextPlant = stack.peek();
                    if (currentPlant <= nextPlant) {
                        tempQueue.addFirst(currentPlant);
                        counter++;
                    }
                } else {
                    counter++;
                    tempQueue.addFirst(currentPlant);
                }
            }

            if (counter == previousSize) {
                return days;
            }

            while (!tempQueue.isEmpty()) {
                stack.push(tempQueue.poll());
            }

            days++;
        }
    }
}