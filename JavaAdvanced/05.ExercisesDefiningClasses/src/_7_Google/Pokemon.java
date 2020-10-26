package _7_Google;

public class Pokemon {
    private final String pokemonName;
    private final String element;

    public Pokemon(String pokemonName, String element) {
        this.pokemonName = pokemonName;
        this.element = element;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getElement() {
        return element;
    }
}
