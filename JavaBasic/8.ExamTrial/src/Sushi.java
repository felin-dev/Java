import java.util.Scanner;

public class Sushi {
    public static final double delivery = 1.2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sushiType = sc.nextLine();
        String restaurantName = sc.nextLine();
        int numberOfPortions = Integer.parseInt(sc.nextLine());
        String orderSymbol = sc.nextLine();

        double sushiPrice = 0;
        switch (sushiType) {
            case "sashimi": {
                switch (restaurantName) {
                    case "Sushi Zone": {
                        sushiPrice += 4.99;
                        break;
                    }
                    case "Sushi Time": {
                        sushiPrice += 5.49;
                        break;
                    }
                    case "Sushi Bar": {
                        sushiPrice += 5.25;
                        break;
                    }
                    case "Asian Pub": {
                        sushiPrice += 4.50;
                        break;
                    }
                    default:
                        System.out.printf("%s is invalid restaurant!", restaurantName);
                }
                break;
            }
            case "maki": {
                switch (restaurantName) {
                    case "Sushi Zone": {
                        sushiPrice += 5.29;
                        break;
                    }
                    case "Sushi Time": {
                        sushiPrice += 4.69;
                        break;
                    }
                    case "Sushi Bar": {
                        sushiPrice += 5.55;
                        break;
                    }
                    case "Asian Pub": {
                        sushiPrice += 4.80;
                        break;
                    }
                    default:
                        System.out.printf("%s is invalid restaurant!", restaurantName);
                }
                break;
            }
            case "uramaki": {
                switch (restaurantName) {
                    case "Sushi Zone": {
                        sushiPrice += 5.99;
                        break;
                    }
                    case "Sushi Time": {
                        sushiPrice += 4.49;
                        break;
                    }
                    case "Sushi Bar": {
                        sushiPrice += 6.25;
                        break;
                    }
                    case "Asian Pub": {
                        sushiPrice += 5.50;
                        break;
                    }
                    default:
                        System.out.printf("%s is invalid restaurant!", restaurantName);
                }
                break;
            }
            case "temaki": {
                switch (restaurantName) {
                    case "Sushi Zone": {
                        sushiPrice += 4.29;
                        break;
                    }
                    case "Sushi Time": {
                        sushiPrice += 5.19;
                        break;
                    }
                    case "Sushi Bar": {
                        sushiPrice += 4.75;
                        break;
                    }
                    case "Asian Pub": {
                        sushiPrice += 5.50;
                        break;
                    }
                    default:
                        System.out.printf("%s is invalid restaurant!", restaurantName);
                }
                break;
            }
        }

        double totalPrice = sushiPrice * numberOfPortions;
        if (orderSymbol.equals("Y")) {
            totalPrice *= delivery;
        }

        if (totalPrice != 0) {
            System.out.printf("Total price: %.0f lv.", Math.ceil(totalPrice));
        }
    }
}
