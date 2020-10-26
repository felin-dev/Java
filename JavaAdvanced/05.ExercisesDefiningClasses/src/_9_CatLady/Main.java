package _9_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> cats = new HashMap<>();
        String input = reader.readLine();
        while (!input.equals("End")) {
            String breeds = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            switch (breeds) {
                case "Siamese": {
                    Double earSize = Double.parseDouble(input.split("\\s+")[2]);
                    Siamese siameseCat = new Siamese(name, earSize);
                    cats.putIfAbsent(name, siameseCat);
                    break;
                }
                case "Cymric": {
                    Double furLength = Double.parseDouble(input.split("\\s+")[2]);
                    Cymric cymricCat = new Cymric(name, furLength);
                    cats.putIfAbsent(name, cymricCat);
                    break;
                }
                case "StreetExtraordinaire": {
                    Double decibelsOfMeows = Double.parseDouble(input.split("\\s+")[2]);
                    StreetExtraordinaire streetExtraordinaireCat  = new StreetExtraordinaire(name, decibelsOfMeows);
                    cats.putIfAbsent(name, streetExtraordinaireCat);
                    break;
                }
                default: throw new IllegalArgumentException("Unknown cat breed.");
            }

            input = reader.readLine();
        }

        String wantedCat = reader.readLine();

        System.out.println(cats.get(wantedCat).toString());
    }
}
