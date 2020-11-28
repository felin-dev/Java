package _1_HarvestingFields;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Class<?> clazz;
        try {
            clazz = Class.forName("_1_HarvestingFields.RichSoilLand");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Class not found", e);
        }

        Field[] declaredFields = clazz.getDeclaredFields();

        Reader reader = new Reader();

        String input;
        while (!(input = reader.readLine()).equals("HARVEST")) {
            if (Modifiers.contains(input)) {
                Modifiers wantedModifier = Modifiers.valueOf(input.toUpperCase());
                FieldsPrinter.printWantedFieldsData(declaredFields,
                        wantedModifier);
            }
        }
    }
}
