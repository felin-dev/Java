package _6_PokemonTrainer;

public class Pokemon {
    private final String name;
    private final String type;
    private int health;

    public Pokemon(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
    }

    public String getType() {
        return this.type;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}