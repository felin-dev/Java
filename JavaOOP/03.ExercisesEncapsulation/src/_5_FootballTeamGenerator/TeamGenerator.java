package _5_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class TeamGenerator {
    private final List<Team> teams;

    public TeamGenerator() {
        this.teams = new ArrayList<>();
    }

    public void createTeam(String teamName) {
        if (NameValidator.notValid(teamName)) {
            System.out.println("A name should not be empty.");
            return;
        }

        teams.add(new Team(teamName));
    }

    public void addPlayer(String teamName, String playerName, int endurance,
                          int sprint, int dribble, int passing, int shooting) {

        try {
            for (Team team : teams) {
                if (team.getName().equals(teamName)) {
                    team.addPlayer(new Player(playerName, endurance,
                            sprint, dribble, passing, shooting));
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        if (!contains(teamName)) {
            System.out.printf("Team %s does not exist.%n", teamName);
        }
    }

    public void removePlayer(String teamName, String playerName) {

        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                team.removePlayer(playerName);
            }
        }
    }

    public void printTeamRating(String teamName) {

        boolean ratingShowed = false;
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                System.out.printf("%s - %.0f%n", teamName, team.getRating());
                ratingShowed = true;
            }
        }

        if (!ratingShowed) {
            System.out.printf("Team %s does not exist.%n", teamName);
        }
    }

    private boolean contains(String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return true;
            }
        }

        return false;
    }
}
