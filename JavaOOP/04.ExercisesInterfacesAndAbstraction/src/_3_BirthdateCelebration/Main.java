package _3_BirthdateCelebration;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet("John", "20");
        String name = pet.getName();

        Robot robot = new Robot("DD", "KML");
        String model = robot.getModel();

        Citizen citizen = new Citizen("Toto", 21, "24", "32");
        String name1 = citizen.getName();
    }
}
