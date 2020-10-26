package _6_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!input.equals("Tournament")) {
            String[] tasks = input.split("\\s+");
            String trainerName = tasks[0];
            String pokemonName = tasks[1];
            String pokemonType = tasks[2];
            int pokemonHealth = Integer.parseInt(tasks[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonType, pokemonHealth);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).addPokemon(pokemon);

            input = reader.readLine();
        }

        input = reader.readLine();
        while (!input.equals("End")) {
            String elementType = input;
            for (Trainer trainer : trainers.values()) {
                if (trainer.hasPokemonElement(elementType)) {
                    trainer.setBadges(trainer.getBadges() + 1);
                } else {
                    trainer.pokemonsTakeDamage();
                }
            }

            input = reader.readLine();
        }

        trainers
                .values()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(System.out::println);
    }
}