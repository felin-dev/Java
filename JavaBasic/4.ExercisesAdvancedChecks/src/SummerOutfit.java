import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int degrees = Integer.parseInt(sc.nextLine());
        String timeOfDay = sc.nextLine();

        switch (timeOfDay){
            case "Morning":
                if (degrees >= 10 && degrees <= 18){
                    System.out.println("It's " + degrees + " degrees, get your Sweatshirt and Sneakers.");
                } else if (degrees > 18 && degrees <= 24){
                    System.out.println("It's " + degrees + " degrees, get your Shirt and Moccasins.");
                } else if (degrees > 24){
                    System.out.println("It's " + degrees + " degrees, get your T-Shirt and Sandals.");
                }
                break;
            case "Afternoon":
                if (degrees >= 10 && degrees <= 18){
                    System.out.println("It's " + degrees + " degrees, get your Shirt and Moccasins.");
                } else if (degrees > 18 && degrees <= 24){
                    System.out.println("It's " + degrees + " degrees, get your T-Shirt and Sandals.");
                } else if (degrees > 24){
                    System.out.println("It's " + degrees + " degrees, get your Swim Suit and Barefoot.");
                }
                break;
            case "Evening":
                if (degrees >= 10 && degrees <= 18){
                    System.out.println("It's " + degrees + " degrees, get your Shirt and Moccasins.");
                } else if (degrees > 18 && degrees <= 24){
                    System.out.println("It's " + degrees + " degrees, get your Shirt and Moccasins.");
                } else if (degrees > 24){
                    System.out.println("It's " + degrees + " degrees, get your Shirt and Moccasins.");
                }
                break;
        }
    }
}
