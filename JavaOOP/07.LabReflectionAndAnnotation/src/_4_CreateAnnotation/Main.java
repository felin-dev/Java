package _4_CreateAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> reflectionClass = Class.forName("_4_CreateAnnotation.Reflection");

        Field[] declaredFields = reflectionClass.getDeclaredFields();

        StringBuilder output = new StringBuilder();

        WrongDataFiller.fillWrongFields(declaredFields, output);

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();

        WrongDataFiller.fillWrongGetterMethods(declaredMethods, output);

        WrongDataFiller.fillWrongSetterMethods(declaredMethods, output);

        System.out.println(output.toString().trim());
    }
}
