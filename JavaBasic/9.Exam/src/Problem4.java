import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        int s = Integer.parseInt(sc.nextLine());

        for (int i = m; i >= n; i--) {
            if (i % 2 == 0 && i % 3 ==0 && i == s){
                break;
            }
            if (i % 2 == 0 && i % 3 ==0){
                System.out.printf("%d ", i);
            }
        }
    }
}
