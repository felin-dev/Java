package _7_CollectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text = reader.readLine().split("\\s+");
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myListImpl = new MyListImpl();

        StringBuilder output = new StringBuilder();
        for (String word : text) {
            output.append(addCollection.add(word))
                    .append(" ");
        }

        output.append(System.lineSeparator());

        for (String word : text) {
            output.append(addRemoveCollection.add(word))
                    .append(" ");
        }

        output.append(System.lineSeparator());

        for (String word : text) {
            output.append(myListImpl.add(word))
                    .append(" ");
        }

        output.append(System.lineSeparator());

        int removeTimes = Integer.parseInt(reader.readLine());
        for (int i = 0; i < removeTimes; i++) {
            output.append(addRemoveCollection.remove())
                    .append(" ");
        }

        output.append(System.lineSeparator());

        while (removeTimes-- > 0) {
            output.append(myListImpl.remove())
                    .append(" ");
        }

        System.out.println(output.toString().trim());
    }
}
