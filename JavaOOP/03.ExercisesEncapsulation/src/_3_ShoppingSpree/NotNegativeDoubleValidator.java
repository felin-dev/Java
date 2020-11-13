package _3_ShoppingSpree;

public class NotNegativeDoubleValidator {
    public static void validate(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }
}
