import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _6_HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> kids = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        int timesToJump = Integer.parseInt(sc.nextLine());

        //Резултат = (Начален индекс + timesToJump%size - 1)%size
        int startingIndex = 0;
        while (kids.size() != 1) {
            int kidToRemove = (startingIndex + timesToJump % kids.size() - 1 + kids.size()) % kids.size();
            startingIndex = kidToRemove;
            System.out.println("Removed " + kids.remove(kidToRemove));
        }

        System.out.print("Last is " + kids.get(0));
    }
}