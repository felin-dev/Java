public class DemoDice {
    public static void main(String[] args) {
        Dice dice = new Dice();
        Dice d2 = new Dice();


        dice.setSides(6);
        d2.setSides(7);

        System.out.println(dice.roll());
        System.out.println(d2.roll());
    }
}
