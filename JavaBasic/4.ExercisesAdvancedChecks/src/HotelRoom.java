import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String month = sc.nextLine();
        int nights = Integer.parseInt(sc.nextLine());

        double apartmentRent;
        double studioRent;
        if (month.equals("May") || month.equals("October")){
            apartmentRent = nights * 65;
            studioRent = nights * 50;
            if (nights > 14){
                apartmentRent = apartmentRent * 0.9;
            }
            if (nights > 7 && nights <= 14){
                studioRent = studioRent * 0.95;
            }
            if (nights > 14){
                studioRent = studioRent * 0.70;
            }
            getRentPrices(apartmentRent, studioRent);
        }
        if (month.equals("June") || month.equals("September")){
            apartmentRent = nights * 68.70;
            studioRent = nights * 75.20;
            if (nights > 14){
                apartmentRent = apartmentRent * 0.9;
            }
            if (nights > 14){
                studioRent = studioRent * 0.80;
            }
            getRentPrices(apartmentRent, studioRent);
        }
        if (month.equals("July") || month.equals("August")){
            apartmentRent = nights * 77;
            studioRent = nights * 76;
            if (nights > 14){
                apartmentRent = apartmentRent * 0.9;
            }
            getRentPrices(apartmentRent, studioRent);
        }
    }

    private static void getRentPrices(double apartmentRent, double studioRent) {
        System.out.printf("Apartment: %.2f lv.%n", apartmentRent);
        System.out.printf("Studio: %.2f lv.", studioRent);
    }
}
