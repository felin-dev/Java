package _2_blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?> clazz = BlackBoxInt.class;

        Constructor<?> ctor;
        BlackBoxInt blackBoxInt;
        try {
            ctor = clazz.getDeclaredConstructor();
            ctor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) ctor.newInstance();
        } catch (NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }

        Method[] declaredMethods = clazz.getDeclaredMethods();
        Reader reader = new Reader();

        while (true) {
            String input = reader.readLine();
            if (input.equals("END")) {
                break;
            }

            String[] methodInfo = input.split("_");
            String methodName = methodInfo[0];
            int methodParam = Integer.parseInt(methodInfo[1]);
            MethodsInvoker.invoke(declaredMethods, methodName, methodParam, blackBoxInt);
            try {
                Field innerValue = clazz.getDeclaredField("innerValue");
                innerValue.setAccessible(true);
                System.out.println(innerValue.getInt(blackBoxInt));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
