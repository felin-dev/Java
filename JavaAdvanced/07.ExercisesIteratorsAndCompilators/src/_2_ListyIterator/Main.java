package _2_ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ListyIterator listyIterator = new ListyIterator(Arrays.stream(reader.readLine().split("\\s+")).skip(1)
                .collect(Collectors.toCollection(ArrayList::new)));
        String command = reader.readLine();
        while (!command.equals("END")) {
            switch (command) {
                case "Move": {
                    System.out.println(listyIterator.move());
                    break;
                }
                case "Print": {
                    listyIterator.print();
                    break;
                }
                case "HasNext": {
                    System.out.println(listyIterator.hasNext());
                    break;
                }
                case "PrintAll": {
                    for (String data : listyIterator) {
                        System.out.printf("%s ",data);
                    }
                    System.out.println();
                    break;
                }
            }

            command = reader.readLine();
        }
    }
}
