import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] symbols = line.split(" ");
        String[] reverseSymbols = new String[symbols.length];
        int j = 0;
        for (int i = symbols.length - 1; i >= 0; i--) {
            reverseSymbols[j] = symbols[i];
            j++;
        }

        for (String reverseSymbol : reverseSymbols) {
            System.out.print(reverseSymbol + " ");
        }
    }
}
