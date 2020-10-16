import java.util.Scanner;

public class PrintPartOfTheASCIITable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int startingPrint = Integer.parseInt(sc.nextLine());
        int endingPrint = Integer.parseInt(sc.nextLine());

        for (int i = startingPrint; i <= endingPrint; i++) {
            System.out.printf("%c ", i);
        }
    }
}
