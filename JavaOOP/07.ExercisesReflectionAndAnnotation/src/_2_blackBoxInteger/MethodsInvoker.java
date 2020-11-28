package _2_blackBoxInteger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodsInvoker {

    public static void invoke(Method[] declaredMethods, String wantedMethod, int methodParam, BlackBoxInt blackBoxInt) {
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals(wantedMethod)) {
                declaredMethod.setAccessible(true);
                try {
                    declaredMethod.invoke(blackBoxInt, methodParam);
                } catch (IllegalAccessException | InvocationTargetException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
