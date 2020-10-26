package _7_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();
        String input = reader.readLine();
        while (!input.equals("End")) {
            String name = input.split("\\s+")[0];
            String command = input.split("\\s+")[1];
            switch (command) {
                case "company": {
                    String companyName = input.split("\\s+")[2];
                    String department = input.split("\\s+")[3];
                    Double salary = Double.parseDouble(input.split("\\s+")[4]);
                    people.putIfAbsent(name, new Person(name));
                    people.get(name).addCompany(name, companyName, department, salary);
                    break;
                }
                case "car": {
                    String carModel = input.split("\\s+")[2];
                    Integer carPower = Integer.parseInt(input.split("\\s+")[3]);
                    people.putIfAbsent(name, new Person(name));
                    people.get(name).addCar(name, carModel, carPower);
                    break;
                }
                case "pokemon": {
                    String pokemonName = input.split("\\s+")[2];
                    String pokemonElement = input.split("\\s+")[3];
                    Person person = new Person(name);
                    people.putIfAbsent(name, person);
                    people.get(name).addPokemon(name, pokemonName, pokemonElement);
                    break;
                }
                case "parents": {
                    String parentName = input.split("\\s+")[2];
                    String parentBirthDate = input.split("\\s+")[3];
                    people.putIfAbsent(name, new Person(name));
                    people.get(name).addParents(name, parentName, parentBirthDate);
                    break;
                }
                case "children": {
                    String childName = input.split("\\s+")[2];
                    String childBirthDate = input.split("\\s+")[3];
                    people.putIfAbsent(name, new Person(name));
                    people.get(name).addChildren(name, childName, childBirthDate);
                    break;
                }

                default: throw new IllegalArgumentException("Wrong input, please try again.");
            }

            input = reader.readLine();
        }

        String searchedPerson = reader.readLine();

        System.out.println(people.get(searchedPerson).toString());
    }
}
