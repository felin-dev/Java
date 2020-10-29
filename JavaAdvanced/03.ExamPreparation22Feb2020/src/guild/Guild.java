package guild;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Guild {
    private String name;
    private int capacity;
    private Set<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashSet<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> playersToKick = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                playersToKick.add(player);
            }
        }

        this.roster.removeAll(playersToKick);

        Player[] kickedPlayers = new Player[playersToKick.size()];
        for (int i = 0; i < kickedPlayers.length; i++) {
            kickedPlayers[i] = playersToKick.get(i);
        }

        return kickedPlayers;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Players in the guild: %s:%n", this.name));
        for (Player player : this.roster) {
            output.append(player);
            output.append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
