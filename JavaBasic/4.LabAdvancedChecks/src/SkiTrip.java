import java.util.Scanner;

public class SkiTrip {
    public static final double ROOM_FOR_ONE_PERSON = 18.00;
    public static final double APARTMENT = 25.00;
    public static final double PRESIDENT_APARTMENT = 35.00;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  days = Integer.parseInt(sc.nextLine());
        String roomType = sc.nextLine();
        String rating = sc.nextLine();

        double ratingDiscount;
        if (rating.equals("positive")){
            ratingDiscount = 1.25;
        } else {
            ratingDiscount = 0.90;
        }

        days = days - 1;
        double totalPrice;
        switch (roomType) {
            case "room for one person": {
                    totalPrice = days * ROOM_FOR_ONE_PERSON * ratingDiscount;
                break;
            }
            case "apartment": {
                if (days < 10) {
                    totalPrice = days * APARTMENT * 0.70 * ratingDiscount;
                } else if (days >15) {
                    totalPrice = days * APARTMENT * 0.50 * ratingDiscount;
                } else {
                    totalPrice = days * APARTMENT * 0.65 * ratingDiscount;
                }
                break;
            }
            case "president apartment": {
                if (days < 10) {
                    totalPrice = days * PRESIDENT_APARTMENT * 0.9 * ratingDiscount;
                } else if (days > 15) {
                    totalPrice = days * PRESIDENT_APARTMENT * 0.80 * ratingDiscount;
                } else {
                    totalPrice = days * PRESIDENT_APARTMENT * 0.85 * ratingDiscount;
                }
                break;
            }
            default:
                totalPrice = 0;
        }
        System.out.printf("%.2f", totalPrice);
    }
}
