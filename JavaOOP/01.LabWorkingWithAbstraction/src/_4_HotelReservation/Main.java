package _4_HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PriceCalculator priceCalculator = getTripInformation(reader);
        System.out.printf("%.2f", priceCalculator.getTotalPricePerDay());
        //50.25 5 Summer VIP
    }

    private static PriceCalculator getTripInformation(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int daysStayed = Integer.parseInt(input[1]);
        SeasonPriceMultiplier seasonPriceMultiplier = SeasonPriceMultiplier.valueOf(input[2].toUpperCase());

        String discountType = input[3];
        if (discountType.equals("SecondVisit")) {
            discountType = "SECOND_VISIT";
        }
        Discount discount = Discount.valueOf(discountType.toUpperCase());

        return new PriceCalculator
                (seasonPriceMultiplier, discount, pricePerDay, daysStayed);
    }
}
