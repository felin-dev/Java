package _6_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> peopleComparedByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleComparedByAge = new TreeSet<>(new AgeComparator());
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] personInfo = reader.readLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person person = new Person(name, age);
            peopleComparedByName.add(person);
            peopleComparedByAge.add(person);
        }

        StringBuilder output = new StringBuilder();
        for (Person person : peopleComparedByName) {
            output.append(person).append(System.lineSeparator());
        }

        for (Person person : peopleComparedByAge) {
            output.append(person).append(System.lineSeparator());
        }

        System.out.println(output);
    }
}
