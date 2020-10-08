import java.text.DecimalFormat;
import java.util.*;

public class _8_StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> studentInfo = new TreeMap<>();
        int count = Integer.parseInt(sc.nextLine());
        while (count-- > 0) {
            String student = sc.nextLine();
            double[] grade = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double sum = 0.0;
            for (Double aDouble : grade) {
                sum += aDouble;
            }
            Double average = sum / grade.length;
            DecimalFormat df = new DecimalFormat("0.#####################");
            String averageStr = df.format(average);
            studentInfo.putIfAbsent(student, averageStr);
        }

        StringBuilder output = new StringBuilder();
        studentInfo.forEach((student, average) ->
                output.append(String.format("%s is graduated with %s%n", student, average)));

        System.out.println(output);
    }
}