import java.util.Scanner;

public class Bus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int peopleOnBoard = Integer.parseInt(sc.nextLine());
        int numberOfStops = Integer.parseInt(sc.nextLine());

        int currentPeopleOnBoard = peopleOnBoard;
        for (int i = 1; i <= numberOfStops; i++) {
            int peopleGettingOut = Integer.parseInt(sc.nextLine());
            int peopleGettingIn = Integer.parseInt(sc.nextLine());
            if (i % 2 == 0) {
                peopleGettingOut += 2;
            } else {
                peopleGettingIn += 2;
            }
            currentPeopleOnBoard = currentPeopleOnBoard + peopleGettingIn - peopleGettingOut;
        }
        System.out.printf("The final number of passengers is : %d", currentPeopleOnBoard);
    }
}
