import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double squareMetersForGreening = Double.parseDouble(sc.nextLine());
        double pricePerSquare = 7.61;
        double totalPrice = squareMetersForGreening * pricePerSquare;
        double discount = totalPrice * 0.18;
        double finalPrice = totalPrice - discount;
        System.out.print("The final price is: ");
        System.out.printf("%.2f", finalPrice);
        System.out.println(" lv.");
        System.out.print("The discount is: ");
        System.out.printf("%.2f", discount);
        System.out.println(" lv.");
    }
}
