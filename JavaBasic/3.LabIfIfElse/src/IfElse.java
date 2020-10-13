import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double grade = Double.parseDouble(sc.nextLine());
        if (grade > 6 || grade < 2){
            System.out.println("Invalid Number!");
        } else {
            if (grade >= 5.50) {
                System.out.println("Excellent!");
            } else {
                System.out.println("Good luck next time!");
            }
        }
    }
}
