import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double yearsOld = Double.parseDouble(sc.nextLine());
        String gender = sc.nextLine();

        if (gender.equals("f")) {
            if (yearsOld < 16) {
                System.out.println("Miss");
            } else {
                System.out.println("Ms.");
            }
        }
        if (gender.equals("m")) {
            if (yearsOld < 16) {
                System.out.println("Master");
            } else {
                System.out.println("Mr.");
            }
        }
    }
}
