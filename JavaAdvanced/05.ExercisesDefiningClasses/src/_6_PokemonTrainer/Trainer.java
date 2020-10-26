package _6_PokemonTrainer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Trainer {
    private final String trainerName;
    private int badges;
    private final List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.trainerName = name;
        this.pokemonList = new LinkedList<>();
    }

    public int getBadges() {
        return this.badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public boolean hasPokemonElement(String element) {
        for (Pokemon pokemon : this.pokemonList) {
            if (pokemon.getType().equals(element)) {
                return true;
            }
        }

        return false;
    }

    public void pokemonsTakeDamage(){
        Iterator<Pokemon> iter = this.pokemonList.iterator();
        while (iter.hasNext()) {
            Pokemon pokemon = iter.next();
            pokemon.setHealth(pokemon.getHealth() - 10);
            if (pokemon.getHealth() <= 0) {
                iter.remove();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.trainerName, this.badges, this.pokemonList.size());
    }
}