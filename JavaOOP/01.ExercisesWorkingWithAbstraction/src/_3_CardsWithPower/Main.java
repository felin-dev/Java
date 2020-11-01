package _3_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rankPower = sc.nextLine();
        String suitPower = sc.nextLine();
        Card card = new Card(RankPowers.valueOf(rankPower), SuitPowers.valueOf(suitPower));
        System.out.println(card);
    }
}
