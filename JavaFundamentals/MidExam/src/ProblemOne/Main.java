package ProblemOne;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstEmployee = Integer.parseInt(sc.nextLine());
        int secondEmployee = Integer.parseInt(sc.nextLine());
        int thirdEmployee = Integer.parseInt(sc.nextLine());
        int studentsCount = Integer.parseInt(sc.nextLine());

        int studentsPerHour = firstEmployee + secondEmployee + thirdEmployee;
        int hoursNeeded = 0;
        while (studentsCount > 0) {
            hoursNeeded ++;
            if (hoursNeeded % 4 == 0) {
            } else {
                studentsCount -= studentsPerHour;
            }
        }

        System.out.printf("Time needed: %dh.", hoursNeeded);
    }
}
