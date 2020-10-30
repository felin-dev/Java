package _4_HotelReservation;

public enum SeasonPriceMultiplier {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private final int multiplier;

    SeasonPriceMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
