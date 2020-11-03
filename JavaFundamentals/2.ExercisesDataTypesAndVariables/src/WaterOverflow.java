import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int waterFillTimes = Integer.parseInt(sc.nextLine());
        int tankCapacity = 255;
        int sumOfWaterInTheTank = 0;
        for (int i = 0; i < waterFillTimes; i++) {
            int currentLittersFilled = Integer.parseInt(sc.nextLine());
            if (currentLittersFilled <= tankCapacity) {
                tankCapacity -= currentLittersFilled;
                sumOfWaterInTheTank += currentLittersFilled;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(sumOfWaterInTheTank);
    }
}
