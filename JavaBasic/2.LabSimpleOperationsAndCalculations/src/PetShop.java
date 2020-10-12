import java.util.Scanner;

public class PetShop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int dogs = Integer.parseInt(sc.nextLine());
        int otherAnimals = Integer.parseInt(sc.nextLine());
        double dogFoodPrice = 2.50;
        double otherFoodPrice = 4;
        double toltalPricePaid = dogs * dogFoodPrice
                + otherAnimals * otherFoodPrice;
        System.out.printf("%.2f", toltalPricePaid);
        System.out.println(" lv.");
    }
}
