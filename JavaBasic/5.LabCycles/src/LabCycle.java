public class LabCycle {
    public static void main(String[] args) {
        String[] daysOfTheWeek = {"Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday"};
        for (int i = 0; i < 7; i++) {
            System.out.println("Today is " + (i + 1) + " " + daysOfTheWeek[i]);
        }
    }
}
