import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        int width = Integer.parseInt(sc.nextLine());
        int height = Integer.parseInt(sc.nextLine());

        int volume = length * width * height;

        String input = sc.nextLine();
        while (!input.equals("Done")) {
            int boxes = Integer.parseInt(input);
            volume -= boxes;
            if (volume < 0) {
                break;
            }
            input = sc.nextLine();
        }

        if (volume < 0) {
            int spaceNeeded = Math.abs(volume);
            System.out.printf("No more free space! You need %d Cubic meters more.", spaceNeeded);
        } else {
            System.out.printf("%d Cubic meters left.", volume);
        }
    }
}
