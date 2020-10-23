import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tickets = sc.nextLine().split("\\s+,\\s+");
        for (String currentTicket : tickets) {
            getTicketScore(currentTicket);
        }
    }

    private static void getTicketScore(String currentTicket) {
        int leftSideSymbols = 0;
        int rightSideSymbols = 0;
        char leftChar = 0;
        char rightChar = 0;

        if (currentTicket.length() == 20) {
            for (int i = 0; i < currentTicket.length() / 2; i++) {
                char currentChar = currentTicket.charAt(i);
                if (currentChar == '@' || currentChar == '#' || currentChar == '$' || currentChar == '^') {
                    if (leftChar == 0) {
                        leftChar = currentChar;
                    } else if (leftChar == currentChar){
                        leftSideSymbols++;
                    }
                }
            }
            for (int i = currentTicket.length() / 2; i < currentTicket.length(); i++) {
                char currentChar = currentTicket.charAt(i);
                if (currentChar == '@' || currentChar == '#' || currentChar == '$' || currentChar == '^') {
                    if (rightChar == 0) {
                        rightChar = currentChar;
                    } else if (rightChar == currentChar){
                        rightSideSymbols++;
                    }
                }
            }
            if (leftSideSymbols >= 5 && rightSideSymbols >= 5 && leftSideSymbols < 9
                    && rightSideSymbols < 9 && rightChar == leftChar) {
                System.out.println(String.format("ticket \"%s\" - %d%s",currentTicket, leftSideSymbols + 1, leftChar));
            } else if (leftSideSymbols == 9 && rightSideSymbols == 9 && leftChar == rightChar) {
                System.out.println(String.format("ticket \"%s\" - 10%s Jackpot!", currentTicket, leftChar));
            } else {
                System.out.println(String.format("ticket \"%s\" - no match", currentTicket));
            }
        } else {
            System.out.println("invalid ticket");
        }
    }
}
