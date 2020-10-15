import java.util.Scanner;

public class BachelorParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int moneyForSinger = Integer.parseInt(sc.nextLine());

        String guest = "";
        int numberOfGuests = 0;
        int totalMoney = 0;
        while (!guest.equals("The restaurant is full")) {
            guest = sc.nextLine();

            if (!guest.equals("The restaurant is full")) {
                int currentNumberOfGuests = Integer.parseInt(guest);
                if (currentNumberOfGuests < 5) {
                    totalMoney = totalMoney + currentNumberOfGuests * 100;
                } else {
                    totalMoney = totalMoney + currentNumberOfGuests * 70;
                }
                numberOfGuests += currentNumberOfGuests;

            }
        }

        if (totalMoney >= moneyForSinger) {
            totalMoney -= moneyForSinger;
            System.out.printf("You have %d guests and %d leva left.", numberOfGuests, totalMoney);
        } else {
            System.out.printf("You have %d guests and %d leva income, but no singer.", numberOfGuests, totalMoney);
        }
    }
}
