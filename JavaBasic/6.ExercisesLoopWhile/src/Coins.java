import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double change = Double.parseDouble(sc.nextLine());

        int coinsCount = 0;
        int coinsTwoLv = 0;
        int coinsOneLv = 0;
        int coinsFifty = 0;
        int coinsTwenty = 0;
        int coinsTen = 0;
        int coinsFive = 0;
        int coinsTwo = 0;
        int coinsOne = 0;
        change *= 100;
        while (change > 0) {
            if (change % 200 == 0) {
                change -= 200;
                coinsCount++;
                coinsTwoLv++;
            } else if (change % 100 == 0) {
                change -= 100;
                coinsCount++;
                coinsOneLv++;
            } else {
                double moneyLeft = change;
                if (moneyLeft % 50 == 0) {
                    change -= 50;
                    coinsCount++;
                    coinsFifty++;
                } else {
                    moneyLeft %= 20;
                    if (moneyLeft == 0) {
                        change -= 20;
                        coinsCount++;
                        coinsTwenty++;
                    } else {
                        moneyLeft %= 10;
                        if (moneyLeft == 0) {
                            change -= 10;
                            coinsCount++;
                            coinsTen++;
                        } else {
                            moneyLeft %= 5;
                            if (moneyLeft == 0) {
                                change -= 5;
                                coinsCount++;
                                coinsFive++;
                            } else {
                                moneyLeft %= 2;
                                if (moneyLeft == 0) {
                                    change -= 2;
                                    coinsCount++;
                                    coinsTwo++;
                                } else {
                                    if (moneyLeft % 1 == 0) {
                                        change -= 1;
                                        coinsCount++;
                                        coinsOne++;
                                    } else {
                                        System.out.printf("%.2f lol %n", moneyLeft);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//        System.out.println(coinsCount);
        System.out.printf("Coins needed: %d%nCoins two " +
                        "leva used: %d,%ncoins one lev used: %d," +
                        "%ncoins fifty used: %d," +
                        "%ncoins twenty used: %d," +
                        "%ncoins ten used: %d," +
                        "%ncoins five used: %d," +
                        "%ncoins two used: %d" +
                        "%ncoins one used: %d",
                coinsCount, coinsTwoLv, coinsOneLv, coinsFifty, coinsTwenty, coinsTen, coinsFive, coinsTwo, coinsOne);
    }
}
