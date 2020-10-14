import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filmName = sc.nextLine();

        int studentCounter = 0;
        int standardCounter = 0;
        int kidCounter = 0;
        while (!"Finish".equals(filmName)) {
            int capacity = Integer.parseInt(sc.nextLine());
            int counter = 0;
            for (int i = 0; i < capacity; i++) {
                String ticketType = sc.nextLine();
                if ("End".equals(ticketType)) {
                    break;
                }
                counter++;
                switch (ticketType) {
                    case "student":
                        studentCounter++;
                        break;
                    case "standard":
                        standardCounter++;
                        break;
                    case "kid":
                        kidCounter++;
                        break;
                }
            }
            double percent = counter * 1.0 / capacity * 100;
            System.out.printf("%s - %.2f%% full.%n", filmName, percent);
            filmName = sc.nextLine();
        }
        int totalTickets = studentCounter + standardCounter + kidCounter;
        System.out.printf("Total tickets: %d%n", totalTickets);
        double studentPercent = studentCounter * 1.0 / totalTickets * 100;
        System.out.printf("%.2f%% student tickets.%n", studentPercent);
        double standardPercent = standardCounter * 1.0 / totalTickets * 100;
        System.out.printf("%.2f%% standard tickets.%n", standardPercent);
        double kidPercent = kidCounter * 1.0 / totalTickets * 100;
        System.out.printf("%.2f%% kids tickets.%n", kidPercent);
    }
}

