package _5_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TeamGenerator teamGenerator = new TeamGenerator();
        String input;
        while (!(input = reader.readLine()).equals("END")) {
            teamProcessor(input, teamGenerator);
        }
    }

    public static void teamProcessor(String processInfoString, TeamGenerator teamGenerator) {
        String[] processInfo = processInfoString.split(";");
        String method = processInfo[0];
        switch (method) {
            case "Team": {
                String teamName = processInfo[1];
                teamGenerator.createTeam(teamName);
                break;
            }
            case "Add": {
                String teamName = processInfo[1];
                String playerName = processInfo[2];
                int endurance = Integer.parseInt(processInfo[3]);
                int sprint = Integer.parseInt(processInfo[4]);
                int dribble = Integer.parseInt(processInfo[5]);
                int passing = Integer.parseInt(processInfo[6]);
                int shooting = Integer.parseInt(processInfo[7]);

                teamGenerator.addPlayer(teamName, playerName, endurance,
                        sprint, dribble, passing, shooting);
                break;
            }
            case "Remove": {
                String teamName = processInfo[1];
                String playerName = processInfo[2];
                teamGenerator.removePlayer(teamName, playerName);
                break;
            }
            case "Rating": {
                String teamName = processInfo[1];
                teamGenerator.printTeamRating(teamName);
                break;
            }
        }
    }
}
