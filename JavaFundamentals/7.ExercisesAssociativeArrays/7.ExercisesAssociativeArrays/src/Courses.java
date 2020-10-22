import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+:\\s+");
            String courseName = tokens[0];
            String studentName = tokens[1];

            courses.putIfAbsent(courseName, new ArrayList<>());
//            List<String> students = courses.get(courseName);
//            students.add(studentName);
            courses.get(courseName).add(studentName);

            input = sc.nextLine();
        }

        courses
                .entrySet()
                .stream()
                .sorted((c1, c2) -> Integer.compare(c2.getValue().size(), c1.getValue().size()))
                .forEach(entry -> {
                    System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()));
                    entry
                            .getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(s -> System.out.println(String.format("-- %s", s)));
                });
    }
}