package _4_HotelReservation;

public enum Discount {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);

    double discount;

    Discount(int discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
