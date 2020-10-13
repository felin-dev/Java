public class test {
    public static final int MONTHLY_TAX = 30;
    public static final int TV_BOX = 160;
    public static int PAID_IN;

    public static void main(String[] args) {
        PAID_IN = TV_BOX / MONTHLY_TAX;
        System.out.println(PAID_IN);
    }
}
