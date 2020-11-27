package _4_CreateAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.TreeSet;

public class WrongDataFiller {

    public static void fillWrongFields(Field[] declaredFields, StringBuilder output) {
        Set<Field> wrongFields = new TreeSet<>(new ComparatorField());

        for (Field field : declaredFields) {
            if (!Modifier.toString(field.getModifiers()).contains("private")) {
                wrongFields.add(field);
            }
        }

        for (Field wrongField : wrongFields) {
            output.append(String.format("%s must be private!%n", wrongField.getName()));
        }
    }

    public static void fillWrongGetterMethods(Method[] declaredMethods, StringBuilder output) {
        Set<Method> wrongGetters = new TreeSet<>(new ComparatorMethod());

        for (Method method : declaredMethods) {
            if (method.getName().contains("get")
                    && !method.getReturnType().equals(void.class)
                    && method.getParameterCount() == 0
                    && !Modifier.toString(method.getModifiers()).contains("public")) {
                wrongGetters.add(method);
            }
        }

        for (Method getter : wrongGetters) {
            output.append(String.format("%s have to be public!%n", getter.getName()));
        }
    }

    public static void fillWrongSetterMethods(Method[] declaredMethods, StringBuilder output) {
        Set<Method> wrongSetters = new TreeSet<>(new ComparatorMethod());

        for (Method method : declaredMethods) {
            if (method.getName().contains("set")
                    && method.getReturnType().equals(void.class)
                    && method.getParameterCount() != 0
                    && !Modifier.toString(method.getModifiers()).contains("private")) {
                wrongSetters.add(method);
            }
        }

        for (Method setter : wrongSetters) {
            output.append(String.format("%s have to be private!%n", setter.getName()));
        }
    }
}
