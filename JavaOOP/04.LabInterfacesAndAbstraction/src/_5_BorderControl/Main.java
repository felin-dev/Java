package _5_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        List<Citizen> citizens = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();
        while (!(input = reader.readLine()).equals("End")) {
            String[] entryInfo = input.split("\\s+");
            if (entryInfo.length == 3) {
                citizens.add(new Citizen(entryInfo[0], Integer.parseInt(entryInfo[1]), entryInfo[2]));
            } else if (entryInfo.length == 2) {
                robots.add(new Robot(entryInfo[0], entryInfo[1]));
            }
        }

        String wantedIdPostfix = reader.readLine();

        for (Citizen citizen : citizens) {
            if (citizen.getId().endsWith(wantedIdPostfix)) {
                System.out.println(citizen.getId());
            }
        }

        for (Robot robot : robots) {
            if (robot.getId().endsWith(wantedIdPostfix)) {
                System.out.println(robot.getId());
            }
        }
    }
}
