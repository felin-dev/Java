import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = sc.nextLine();
        while (!command.equals("end")) {
            String[] commandParts = command.split(" ");
            String commandName = commandParts[0];
            int argument = Integer.parseInt(commandParts[1]);

            switch (commandName) {
                case "Add":
                    numbers.add(argument);
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(argument));
                    break;
                case "RemoveAt":
                    numbers.remove(argument);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandParts[2]);
                    numbers.add(index, argument);
                    break;
            }

            command = sc.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
