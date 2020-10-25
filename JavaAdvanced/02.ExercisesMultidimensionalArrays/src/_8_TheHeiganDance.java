import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _8_TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double playerHp = 18500;
        double heiganHp = 3000000;
        List<Integer> playerSpot = Arrays.asList(7, 7, 0);

        double damage = Double.parseDouble(sc.nextLine());
        boolean currentCloud = false;
        String spell = "";
        while (true) {
            if (playerHp > 0) {
                heiganHp -= damage;
            }

            if (currentCloud) {
                playerHp -= 3500;
                currentCloud = false;
            }

            if (playerHp <= 0 && heiganHp > 0) {
                System.out.printf("Heigan: %.2f%n", heiganHp);
                System.out.printf("Player: Killed by %s%n", spell.equals("Cloud") ? "Plague Cloud" : "Eruption");
                System.out.printf("Final position: %d, %d", playerSpot.get(0), playerSpot.get(1));
                break;
            }

            if (playerHp > 0 && heiganHp <= 0) {
                System.out.printf("Heigan: Defeated!%n");
                System.out.printf("Player: %.0f%n", playerHp);
                System.out.printf("Final position: %d, %d", playerSpot.get(0), playerSpot.get(1));
                break;
            }

            if (playerHp <= 0 && heiganHp <= 0) {
                System.out.printf("Heigan: Defeated!%n");
                System.out.printf("Player: Killed by %s%n", spell.equals("Cloud") ? "Plague Cloud" : "Eruption");
                System.out.printf("Final position: %d, %d", playerSpot.get(0), playerSpot.get(1));
                break;
            }

            String[] input = sc.nextLine().split("\\s+");
            spell = input[0];
            int rowHit = Integer.parseInt(input[1]);
            int colHit = Integer.parseInt(input[2]);

            switch (spell) {
                case "Cloud": {
                    hit(rowHit, colHit, playerSpot);
                    boolean damaged = playerSpot.get(2) == 1;
                    if (damaged) {
                        playerHp -= 3500;
                        currentCloud = true;
                        playerSpot.set(2, 0);
                    }
                    break;
                }
                case "Eruption": {
                    hit(rowHit, colHit, playerSpot);
                    boolean damaged = playerSpot.get(2) == 1;
                    if (damaged) {
                        playerHp -= 6000;
                        playerSpot.set(2, 0);
                    }
                    break;
                }
                default:
                    throw new IllegalArgumentException("Wrong command!");
            }
        }
    }

    private static void hit(int rowHit, int colHit, List<Integer> playerSpot) {
        int fromRow = Math.min(Math.max(0, rowHit - 1), 15);
        int toRow = Math.max(0, Math.min(rowHit + 1, 15));
        int fromCol = Math.min(Math.max(0, colHit - 1), 15);
        int toCol = Math.max(0, Math.min(colHit + 1, 15));
        int playerAtRow = playerSpot.get(0);
        int playerAtCol = playerSpot.get(1);

        if (playerAtRow > fromRow && playerAtRow < toRow && playerAtCol > fromCol && playerAtCol < toCol) {
            isHit(playerSpot);
        } else if (playerAtRow >= fromRow && playerAtRow <= toRow && playerAtCol >= fromCol && playerAtCol <= toCol) {
            if (playerAtRow - 1 < fromRow && playerAtRow - 1 >= 0) {
                playerMoved(playerSpot, 0, --playerAtRow);
            } else if (playerAtCol + 1 > toCol && playerAtCol + 1 <= 15) {
                playerMoved(playerSpot, 1, ++playerAtCol);
            } else if (playerAtRow + 1 > toRow && playerAtRow + 1 <= 15) {
                playerMoved(playerSpot, 0, ++playerAtRow);
            } else if (playerAtCol - 1 < fromCol && playerAtCol - 1 >= 0) {
                playerMoved(playerSpot, 1, --playerAtCol);
            } else {
                isHit(playerSpot);
            }
        }
    }

    private static void isHit(List<Integer> playerSpot) {
        playerSpot.set(2, 1);
    }

    private static void playerMoved(List<Integer> playerSpot, int index, int at) {
        playerSpot.set(index, at);
    }
}