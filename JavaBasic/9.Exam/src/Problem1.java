import java.util.Scanner;

public class Problem1 {
    public static final double MIDI_PRICE = 7.50;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double skumriaPrice = Double.parseDouble(sc.nextLine());
        double cacaPrice = Double.parseDouble(sc.nextLine());
        double palamudQuantity = Double.parseDouble(sc.nextLine());
        double safridQuantity = Double.parseDouble(sc.nextLine());
        double midiQuantity = Double.parseDouble(sc.nextLine());

        double palamudPrice = skumriaPrice * 1.60;
        double safridPrice = cacaPrice * 1.80;

        double cenaPalamudTotal = palamudQuantity * palamudPrice;
        double cenaSafridTotal = safridQuantity * safridPrice;
        double cenaMidiTotal = midiQuantity * MIDI_PRICE;
        double totalPrice = cenaMidiTotal + cenaPalamudTotal + cenaSafridTotal;
        System.out.printf("%.2f", totalPrice);
    }
}
