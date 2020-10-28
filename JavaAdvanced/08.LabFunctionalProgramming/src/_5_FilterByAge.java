import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _5_FilterByAge {
    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Person> people = IntStream.range(0, n)
                .mapToObj(i -> {
                    String[] tasks = sc.nextLine().split(",\\s+");
                    String name = tasks[0];
                    int age = Integer.parseInt(tasks[1]);
                    return new Person(name, age);
                })
                .collect(Collectors.toList());

//        List<Person> people = new ArrayList<>();
//        while (n-- > 0) {
//            String[] tasks = sc.nextLine().split(",\\s+");
//            String name = tasks[0];
//            int age = Integer.parseInt(tasks[1]);
//            Person person = new Person(name, age);
//            people.add(person);
//        }

        String condition = sc.nextLine();
        int ageRequired = Integer.parseInt(sc.nextLine());
        Predicate<Person> predicate = getCondition(condition, ageRequired);
        String[] printInfo = sc.nextLine().split("\\s+");
        Consumer<Person> consumer = getPrintInfo(printInfo);
        people.stream().filter(predicate)
                .forEach(consumer);
    }

    private static Consumer<Person> getPrintInfo(String[] printInfo) {
        if (printInfo.length != 2 && printInfo[0].equals("name")) {
            return person -> System.out.println(person.getName());
        } else if (printInfo.length != 2 && printInfo[0].equals("age")) {
            return person -> System.out.println(person.getAge());
        } else {
            return person -> System.out.println(person.getName() + " - " + person.getAge());
        }
    }

    private static Predicate<Person> getCondition(String condition, int ageRequired) {
        if (condition.equals("younger")) {
            return person -> person.getAge() <= ageRequired;
        } else {
            return person -> person.getAge() >= ageRequired;
        }
    }
}
