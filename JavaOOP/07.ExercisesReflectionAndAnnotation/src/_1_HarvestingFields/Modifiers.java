package _1_HarvestingFields;

public enum Modifiers {
    PRIVATE("private"),
    PROTECTED("protected"),
    PUBLIC("public"),
    ALL("all");

    private final String modifier;

    Modifiers(String modifier) {
        this.modifier = modifier;
    }

    public String getModifier() {
        return modifier;
    }

    public static Boolean contains(String wantedModifier) {
        Modifiers[] values = Modifiers.values();
        for (Modifiers value : values) {
            if (value.name().equals(wantedModifier.toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}
