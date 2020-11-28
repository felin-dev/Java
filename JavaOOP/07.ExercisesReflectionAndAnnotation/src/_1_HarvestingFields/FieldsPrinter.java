package _1_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldsPrinter {

    public static void printWantedFieldsData(Field[] declaredFields, Modifiers modifierTarget) {
        System.out.println(getWantedFields(declaredFields, modifierTarget));
    }

    private static String getWantedFields(Field[] declaredFields, Modifiers modifierTarget) {
        StringBuilder output = new StringBuilder();
        for (Field declaredField : declaredFields) {
            if (!modifierTarget.getModifier().equals("all")) {
                if (Modifier.toString(declaredField.getModifiers())
                        .equals(modifierTarget.getModifier())) {
                    getPrinterOutputString(output, declaredField);
                }
            } else {
                getPrinterOutputString(output, declaredField);
            }
        }

        return output.toString().trim();
    }

    private static void getPrinterOutputString(StringBuilder output, Field declaredField) {
        output.append(String.format("%s %s %s%n",
                Modifier.toString(declaredField.getModifiers()),
                declaredField.getType().getSimpleName(),
                declaredField.getName()));
    }
}
