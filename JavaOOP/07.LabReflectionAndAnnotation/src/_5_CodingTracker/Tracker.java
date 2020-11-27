package _5_CodingTracker;

import java.lang.reflect.Method;
import java.util.*;

public class Tracker {

    @Author(name = "Felin")
    public static void printMethodsByAuthor(Class<?> clazz) {
        Map<String, List<String>> methodsByAuthor = new LinkedHashMap<>();
        Method[] methods = clazz.getDeclaredMethods().clone();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {
                methodsByAuthor
                        .putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor
                        .get(annotation.name()).add(method.getName() + "()");
            }
        }

        StringBuilder output = new StringBuilder();

        methodsByAuthor.forEach((a, m) -> {
            output.append(String.format("%s:", a));
            m.forEach(method -> {
                output.append(System.lineSeparator());
                output.append(String.format("%s", method));
            });
            output.append(System.lineSeparator());
        });

        System.out.println(output.toString().trim());
    }
}
