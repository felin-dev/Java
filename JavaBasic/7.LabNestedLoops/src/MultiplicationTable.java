public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%nMultiplication with %d:%n%n", i);
            for (int j = 1; j <= 10; j++) {
                int multiplication = i * j;
                System.out.printf("%d * %d = %d%n", i, j, multiplication);
            }
        }
    }
}
