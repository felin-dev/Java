import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(sc.nextLine());
        String peopleOccupation = sc.nextLine();
        String dayOfTheWeek = sc.nextLine();

        double totalPrice = 0;
        double discount = 0;
        switch (peopleOccupation.toLowerCase()) {
            case ("students"):
                if (numberOfPeople >= 30) {
                    discount = 0.85;
                }
                switch (dayOfTheWeek.toLowerCase()) {
                    case ("friday"):
                        totalPrice = numberOfPeople * 8.45;
                        break;
                    case ("saturday"):
                        totalPrice = numberOfPeople * 9.80;
                        break;
                    case ("sunday"):
                        totalPrice = numberOfPeople * 10.46;
                        break;
                }
                break;
            case ("business"):
                if (numberOfPeople >= 100) {
                    numberOfPeople -= 10;
                }
                switch (dayOfTheWeek.toLowerCase()) {
                    case ("friday"):
                        totalPrice = numberOfPeople * 10.90;
                        break;
                    case ("saturday"):
                        totalPrice = numberOfPeople * 15.60;
                        break;
                    case ("sunday"):
                        totalPrice = numberOfPeople * 16;
                        break;
                }
                break;
            case ("regular"):
                if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                    discount = 0.95;
                }
                switch (dayOfTheWeek.toLowerCase()) {
                    case ("friday"):
                        totalPrice = numberOfPeople * 15;
                        break;
                    case ("saturday"):
                        totalPrice = numberOfPeople * 20;
                        break;
                    case ("sunday"):
                        totalPrice = numberOfPeople * 22.50;
                        break;
                }
                break;
        }
        if (discount != 0) {
            totalPrice *= discount;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
