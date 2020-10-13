import java.util.Scanner;

public class ConvertUnits {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double value = Double.parseDouble(sc.nextLine());
        String fromUnits = sc.nextLine();
        String toUnits = sc.nextLine();

        double result = convertDistance(fromUnits, toUnits, value);
        System.out.printf("%.3f", result);
    }

    private static double convertDistance(String fromUnits, String toUnits, double value) {
        switch (fromUnits) {
            case "mm":
                switch (toUnits) {
                    case "mm":
                        return value;
                    case "cm":
                        return value / 10;
                    case "m":
                        return value / 1000;
                }
            case "cm":
                switch (toUnits) {
                    case "mm":
                        return value * 10;
                    case "cm":
                        return value;
                    case "m":
                        return value / 100;
                }
            case "m":
                switch (toUnits) {
                    case "mm":
                        return value * 1000;
                    case "cm":
                        return value * 100;
                    case "m":
                        return value;
                }
        }

        throw new IllegalArgumentException("Only metric units are allowed!");
    }
}
