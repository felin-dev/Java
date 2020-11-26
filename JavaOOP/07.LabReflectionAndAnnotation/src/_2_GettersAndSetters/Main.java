package _2_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static class ComparatorMethod implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> reflectionClass = Class.forName("_2_GettersAndSetters.Reflection");

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();

        Set<Method> getters = new TreeSet<>(new ComparatorMethod());
        Arrays
                .stream(declaredMethods)
                .filter(m -> m.getName().startsWith("get") && m.getReturnType() != void.class)
                .forEach(getters::add);

        Set<Method> setters = new TreeSet<>(new ComparatorMethod());
        Arrays
                .stream(declaredMethods)
                .filter(m -> m.getName().startsWith("set") && m.getReturnType() == void.class)
                .forEach(setters::add);

        getters.forEach(g -> System.out.printf("%s will return class %s%n",
                g.getName(), g.getReturnType().toString().replaceAll("class ", "")));

        setters.forEach(s -> System.out.printf("%s and will set field of class %s%n",
                s.getName(), s.getParameterTypes()[0].toString().replaceAll("class ", "")));
    }
}
