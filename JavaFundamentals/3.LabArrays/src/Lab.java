import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
        int[] nums = new int[10];

        nums[0] = 14;
        nums[6] = 111;

        System.out.println(nums[0]);
        System.out.println(nums[5]);

        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        int[] nums2 = new int[size];

        nums2[1] = 75;
        System.out.println(nums2[1]);
    }
}
