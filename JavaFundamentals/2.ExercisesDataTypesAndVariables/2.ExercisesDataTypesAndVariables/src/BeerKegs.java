import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int beerKegsCount = Integer.parseInt(sc.nextLine());
        String biggestKeg = "";
        double kegVolume = 0.0;
        for (int i = 0; i < beerKegsCount; i++) {
            String kegModel = sc.nextLine();
            double radius = Double.parseDouble(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());
            if (biggestKeg.isEmpty()) {
                kegVolume = Math.PI * radius * radius * height;
                biggestKeg = kegModel;
            } else {
                double currentKegVolume = Math.PI * radius * radius * height;
                if (currentKegVolume > kegVolume) {
                    biggestKeg = kegModel;
                    kegVolume = currentKegVolume;
                }
            }
        }

        System.out.println(biggestKeg);
    }
}
