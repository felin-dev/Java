import java.util.Scanner;

public class ClassExercises {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        System.out.println(a < b);
        System.out.println(a > 0);
        System.out.println(a > 100);
        System.out.println(a >= b);
        System.out.println(a <= b);
        Scanner sc = new Scanner(System.in);
        String aa = sc.nextLine();
        String bb = sc.nextLine();
        System.out.println("equals");
        System.out.println(aa.equals(bb));
    }
}
