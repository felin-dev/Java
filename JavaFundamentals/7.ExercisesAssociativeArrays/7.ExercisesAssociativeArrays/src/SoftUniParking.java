import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int registers = Integer.parseInt(sc.nextLine());
        Map<String, String> users = new LinkedHashMap<>();
        for (int i = 0; i < registers; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String command = tokens[0];
            String user = tokens[1];
            switch (command) {
                case "register":
                    String licensePlate = tokens[2];
                    if (users.containsKey(user)) {
                        String existingLicensePlate = users.get(user);
                        System.out.printf("ERROR: already registered with plate number %s%n", existingLicensePlate);
                    } else {
                        users.putIfAbsent(user, licensePlate);
                        System.out.printf("%s registered %s successfully%n", user, licensePlate);
                    }
                    break;
                    case "unregister":
                        if (users.containsKey(user)) {
                            users.remove(user);
                            System.out.printf("%s unregistered successfully%n", user);
                        } else {
                            System.out.printf("ERROR: user %s not found%n", user);
                        }
                    break;
            }
        }

        users
                .forEach((u, p)-> System.out.println(String.format("%s => %s", u, p)));
    }
}
