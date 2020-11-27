package _4_CreateAnnotation;

import java.lang.reflect.Field;
import java.util.Comparator;

public class ComparatorField implements Comparator<Field> {

    @Override
    public int compare(Field f, Field s) {
        return f.getName().compareTo(s.getName());
    }
}
