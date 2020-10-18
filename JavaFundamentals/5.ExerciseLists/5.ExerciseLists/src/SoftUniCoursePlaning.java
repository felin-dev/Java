import java.util.*;

public class SoftUniCoursePlaning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> coursesList = getArray(sc);
        String input = sc.nextLine();
        while (!"course start".equals(input)) {
            String[] commands = input.split(":");
            switch (commands[0]) {
                case "Add":
                    if (!coursesList.contains(commands[1])) {
                        coursesList.add(commands[1]);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[2]);
                    if (!coursesList.contains(commands[1])) {
                        coursesList.add(index, commands[1]);
                    }
                    break;
                case "Remove":
                    coursesList.remove(commands[1]);
                    if (coursesList.contains(commands[1] + "-Exercise")) {
                        String exercise = commands[1] + "-Exercise";
                        coursesList.remove(exercise);
                    }
                    break;
                case "Swap":
                    if ((coursesList.contains(commands[1])) && (coursesList.contains(commands[2]))) {
                        int firstIndex = coursesList.indexOf(commands[1]);
                        int secondIndex = coursesList.indexOf(commands[2]);
                        Collections.swap(coursesList, firstIndex, secondIndex);
                        if (coursesList.contains(commands[1] + "-Exercise")) {
                            index = coursesList.indexOf(commands[1]);
                            String exercise = commands[1] + "-Exercise";
                            coursesList.remove(exercise);
                            coursesList.add(index + 1, exercise);
                        }

                        if (coursesList.contains(commands[2] + "-Exercise")) {
                            index = coursesList.indexOf(commands[2]);
                            String exercise = commands[2] + "-Exercise";
                            coursesList.remove(exercise);
                            coursesList.add(index + 1, exercise);
                        }
                    }
                    break;
                case "Exercise" :
                    String exercise = commands[1] + "-Exercise";
                    if (coursesList.contains(commands[1]) && !coursesList.contains(exercise)) {
                        index = coursesList.indexOf(commands[1]);
                        coursesList.add(index + 1, exercise);
                    } else if (!coursesList.contains(commands[1])) {
                        coursesList.add(commands[1]);
                        coursesList.add(exercise);
                    }
                    break;
                default: throw new IllegalArgumentException(commands[0]);
            }

            input = sc.nextLine();
        }

        printCourses(coursesList);
    }

    private static void printCourses(List<String> coursesList) {
        for (int i = 0; i < coursesList.size(); i++) {
            int numberOfCourse = i + 1;
            System.out.println(numberOfCourse + "." + coursesList.get(i));
        }
    }

    private static List<String> getArray(Scanner sc) {
        String[] temp = sc.nextLine().split(",\\s+");
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(temp));

        return list;
    }
}
