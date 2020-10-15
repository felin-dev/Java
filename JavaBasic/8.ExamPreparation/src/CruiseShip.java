import java.util.Scanner;

public class CruiseShip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sea = sc.nextLine();
        String cabin = sc.nextLine();
        int nightsCount = Integer.parseInt(sc.nextLine());

        double price = 0.0;
        switch (cabin) {
            case "standard cabin":
                switch (sea) {
                    case "Mediterranean": {
                        price = 27.50;
                        break;
                    }
                    case "Adriatic": {
                        price = 22.99;
                        break;
                    }
                    case "Aegean": {
                        price = 23;
                        break;
                    }
                }
                break;
            case "cabin with balcony":
                switch (sea) {
                    case "Mediterranean": {
                        price = 30.20;
                        break;
                    }
                    case "Adriatic": {
                        price = 25.00;
                        break;
                    }
                    case "Aegean": {
                        price = 26.60;
                        break;
                    }
                }
                break;
            case "apartment":
                switch (sea) {
                    case "Mediterranean": {
                        price = 40.50;
                        break;
                    }
                    case "Adriatic": {
                        price = 34.99;
                        break;
                    }
                    case "Aegean": {
                        price = 39.80;
                        break;
                    }
                }
                break;
        }

        price = price * 4 * nightsCount;
        if (nightsCount > 7) {
            price *= 0.75;
        }

        System.out.printf("Annie's holiday in the %s sea costs %.2f lv.", sea, price);
    }
}
