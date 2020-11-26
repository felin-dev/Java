package _3_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> reflectionClass = Class.forName("_3_HighQualityMistakes.Reflection");

        Field[] declaredFields = reflectionClass.getDeclaredFields();

        StringBuilder output = new StringBuilder();

        WrongDataFiller.fillWrongFields(declaredFields, output);

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();

        WrongDataFiller.fillWrongGetterMethods(declaredMethods, output);

        WrongDataFiller.fillWrongSetterMethods(declaredMethods, output);

        System.out.println(output.toString().trim());
    }
}
