package _4_HotelReservation;

public class PriceCalculator {
    private final SeasonPriceMultiplier seasonPriceMultiplier;
    private final Discount discount;
    private final double pricePerDay;
    private final int daysStayed;

    public PriceCalculator(SeasonPriceMultiplier seasonPriceMultiplier, Discount discount,
                           double pricePerDay, int daysStayed) {
        this.seasonPriceMultiplier = seasonPriceMultiplier;
        this.discount = discount;
        this.pricePerDay = pricePerDay;
        this.daysStayed = daysStayed;
    }

    public double getTotalPricePerDay() {
        return this.daysStayed * this.pricePerDay * this.seasonPriceMultiplier.getMultiplier() *
                (1 - this.discount.getDiscount() / 100);
    }
}
