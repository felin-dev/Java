package _4_CreateAnnotation;

import java.lang.reflect.Method;
import java.util.Comparator;

public class ComparatorMethod implements Comparator<Method> {

    @Override
    public int compare(Method f, Method s) {
        return f.getName().compareTo(s.getName());
    }
}
