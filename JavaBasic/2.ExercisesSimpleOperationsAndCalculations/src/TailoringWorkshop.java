import java.util.Scanner;

public class TailoringWorkshop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tables = Integer.parseInt(sc.nextLine());
        double tableLength = Double.parseDouble(sc.nextLine());
        double tableWidth = Double.parseDouble(sc.nextLine());
        double tablesArea = tables * (tableLength + 0.6) * (tableWidth + 0.6);
        double quadsArea = tables * (tableLength / 2) * (tableLength / 2);
        double resultUSD = tablesArea * 7 + quadsArea * 9;
        System.out.printf("%.2f", resultUSD);
        System.out.println(" USD");
        double resultBGN = resultUSD * 1.85;
        System.out.printf("%.2f", resultBGN);
        System.out.println(" BGN");
    }
}
