import java.util.*;

public class _5_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Double>> studentGrades = new TreeMap<>();
        int count = Integer.parseInt(sc.nextLine());
        while (count-- > 0) {
            String[] studentInfo = sc.nextLine().split("\\s+");
            String studentName = studentInfo[0];
            Double studentGrade = Double.valueOf(studentInfo[1]);

            studentGrades.putIfAbsent(studentName, new ArrayList<>());
            studentGrades.get(studentName).add(studentGrade);
        }

        studentGrades.forEach((student, grades) -> {
            System.out.printf("%s -> ", student);
            double sum = 0;
            for (Double grade : grades) {
                System.out.printf("%.2f ", grade);
                sum += grade;
            }
            double average = sum / grades.size();
            System.out.printf("(avg: %.2f)%n", average);
        });
    }
}