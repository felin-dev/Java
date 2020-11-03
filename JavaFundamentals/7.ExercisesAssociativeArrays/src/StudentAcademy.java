import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Double>> students = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String studentName = sc.nextLine();
            double studentGrade = Double.parseDouble(sc.nextLine());

            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).add(studentGrade);
        }

        students
                .entrySet()
                .stream()
                .filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0) >= 4.50)
                .sorted((s1, s2) -> {
                    double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
                    double second = s2.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
                    return Double.compare(second, first);
                })
                .forEach(s -> System.out.println(String.format("%s -> %.2f",
                        s.getKey(), s.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0)
                )));
    }
}
