import java.util.Scanner;

public class Cinema {
    public static final double PREMIERE = 12;
    public static final double NORMAL = 7.5;
    public static final double DISCOUNT = 5;
    public static double INCOME = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String projection = sc.nextLine();
        int rows = Integer.parseInt(sc.nextLine());
        int columns = Integer.parseInt(sc.nextLine());

        switch (projection){
            case "Premiere":
                INCOME = rows * columns * PREMIERE;
                break;
            case "Normal":
                INCOME = rows * columns * NORMAL;
                break;
            case "Discount":
                INCOME = rows * columns * DISCOUNT;
                break;
        }

        System.out.printf("%.2f", INCOME);
    }
}
