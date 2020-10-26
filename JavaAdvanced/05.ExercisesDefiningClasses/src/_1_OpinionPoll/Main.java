package _1_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Person> people = new ArrayList<>();
        while (n-- > 0) {
            String input = sc.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);

            if (age > 30) {
                Person person = new Person(name, age);
                people.add(person);
            }
        }

        people.sort(Comparator.comparing(Person::getName));
        StringBuilder output = new StringBuilder();
        for (Person person : people) {
            output.append(person.toString());
        }

        System.out.println(output);
    }
}