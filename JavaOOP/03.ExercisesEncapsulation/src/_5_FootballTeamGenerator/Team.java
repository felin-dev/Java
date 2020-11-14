package _5_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private final List<Player> players;

    public Team (String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (NameValidator.notValid(name)) {
            System.out.println("A name should not be empty.");
            return;
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        if (!players.removeIf(player -> player.getName().equals(playerName))) {
            System.out.printf("Player %s is not in %s team.%n", playerName, name);
        }
    }

    public Double getRating() {
        double totalTeamRating = 0D;
        for (Player player : players) {
            totalTeamRating += player.overallSkillLevel();
        }

        return totalTeamRating;
    }
}
