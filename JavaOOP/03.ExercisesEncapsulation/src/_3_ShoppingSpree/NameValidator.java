package _3_ShoppingSpree;

public class NameValidator {
    public static void validate(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
}
