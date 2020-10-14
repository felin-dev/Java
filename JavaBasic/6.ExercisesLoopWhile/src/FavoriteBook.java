import java.util.Scanner;

public class FavoriteBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String favoriteBook = sc.nextLine();
        int librarySize = Integer.parseInt(sc.nextLine());
        String currentBook = sc.nextLine();

        int i = 0;
        boolean isFound = true;
        while (!currentBook.equals(favoriteBook)) {
            i++;
            if (i == librarySize) {
                isFound = false;
                break;
            }
            currentBook = sc.nextLine();
        }

        if (isFound) {
            System.out.printf("You checked %d books and found it.", i);
        } else {
            System.out.printf("The book you search is not here!%n" +
                    "You checked %d books.", i);
        }
    }
}
