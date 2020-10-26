package _7_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private final List<Pokemon> pokemons;
    private final List<Parent> parents;
    private final List<Child> children;

    public Person(String name) {
        this.name = name;
        this.company = new Company();
        this.car = new Car();
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addCompany(String name, String companyName, String department, Double salary) {
        this.name = name;
        this.company = new Company(companyName, department, salary);
    }

    public void addCar(String name, String carModel, Integer carPower) {
        this.name = name;
        this.car = new Car(carModel, carPower);
    }

    public void addPokemon(String name, String pokemonName, String pokemonType) {
        this.name = name;
        this.pokemons.add(new Pokemon(pokemonName, pokemonType));
    }

    public void addParents(String name, String parentName, String parentBirthDate) {
        this.name = name;
        this.parents.add(new Parent(parentName, parentBirthDate));
    }

    public void addChildren(String name, String childName, String childBirthDate) {
        this.name = name;
        this.children.add(new Child(childName, childBirthDate));
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s%n", this.name));
        output.append(String.format("Company:%n"));
        if (!this.company.getName().equals("")) {
            output.append(String.format("%s %s %.2f%n", this.company.getName(),
                    this.company.getDepartment(), this.company.getSalary()));
        }
        output.append(String.format("Car:%n"));
        if (!this.car.getModel().equals("")) {
            output.append(String.format("%s %d%n", this.car.getModel(), this.car.getPower()));
        }
        output.append(String.format("Pokemon:%n"));
        if (!this.pokemons.isEmpty()) {
            this.pokemons.forEach(pokemon -> output.append(String.format("%s %s%n", pokemon.getPokemonName()
                    , pokemon.getElement())));
        }
        output.append(String.format("Parents:%n"));
        if (!this.parents.isEmpty()) {
            this.parents.forEach(parent -> output.append(String.format("%s %s%n", parent.getName(),
                    parent.getBirthDate())));
        }
        output.append(String.format("Children:%n"));
        if (!this.children.isEmpty()) {
            this.children.forEach(child -> output.append(String.format("%s %s%n", child.getName(),
                    child.getBirthDate())));
        }

        return output.toString();
    }
}
