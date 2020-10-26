package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> customList = new CustomList<String>();
        String input = reader.readLine();
        while (!input.equals("END")) {
            String[] tasks = input.split("\\s+");
            String command = tasks[0];
            switch (command) {
                case "Add": {
                    String element = tasks[1];
                    customList.add(element);
                    break;
                }
                case "Remove": {
                    int index = Integer.parseInt(tasks[1]);
                    customList.remove(index);
                    break;
                }
                case "Contains": {
                    String element = tasks[1];
                    System.out.println(customList.contains(element));
                    break;
                }
                case "Swap": {
                    int indexOne = Integer.parseInt(tasks[1]);
                    int indexTwo = Integer.parseInt(tasks[2]);

                    customList.swap(indexOne, indexTwo);
                    break;
                }
                case "Greater": {
                    String element = tasks[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                }
                case "Max": {
                    System.out.println(customList.getMax());
                    break;
                }
                case "Min": {
                    System.out.println(customList.getMin());
                    break;
                }
                case "Print": {
                    System.out.print(customList);
                    break;
                }
                case "Sort": {
                    customList.sort();
                    break;
                }
                default:
                    System.out.println("Invalid command!");
                    break;
            }

            input = reader.readLine();
        }
    }
}
