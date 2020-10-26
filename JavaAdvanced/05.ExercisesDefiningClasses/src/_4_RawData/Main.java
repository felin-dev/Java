package _4_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> cars = new LinkedHashMap<>();
        Map<String, Engine> engines = new LinkedHashMap<>();
        Map<String, Cargo> cargo = new LinkedHashMap<>();
        Map<String, Tyres> tyres = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] input = reader.readLine().split("\\s+");
            String model = input[0];
            Car car = new Car(model);
            cars.put(model, car);
            Engine engine = new Engine(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            engines.put(model, engine);
            Cargo newCargo = new Cargo(Integer.parseInt(input[3]), input[4]);
            cargo.put(model, newCargo);
            Map<Double, Integer> tyreInfo = getTyres(input);
            Tyres newTyres = new Tyres(tyreInfo);
            tyres.put(model, newTyres);
        }

        Set<String> validCars = new LinkedHashSet<>();
        String cargoType = reader.readLine();
        if (cargoType.equals("fragile")) {
            cars.values().forEach(car -> {
                if (cargo.get(car.getModel()).getCargoType().equals(cargoType)) {
                    tyres.get(car.getModel()).getTyreInfo().keySet().forEach(pressure -> {
                        if (pressure < 1) {
                            validCars.add(car.getModel());
                        }
                    });
                }
            });
        } else if (cargoType.equals("flamable")) {
            cars.values().forEach(car -> {
                if (cargo.get(car.getModel()).getCargoType().equals(cargoType)) {
                    if (engines.get(car.getModel()).getEnginePower() > 250) {
                        validCars.add(car.getModel());
                    }
                }
            });
        }

        validCars.forEach(System.out::println);
    }

    private static Map<Double, Integer> getTyres(String[] input) {
        Map<Double, Integer> tyreInfo = new LinkedHashMap<>();
        tyreInfo.put(Double.parseDouble(input[5]), Integer.parseInt(input[6]));
        tyreInfo.put(Double.parseDouble(input[7]), Integer.parseInt(input[8]));
        tyreInfo.put(Double.parseDouble(input[9]), Integer.parseInt(input[10]));
        tyreInfo.put(Double.parseDouble(input[11]), Integer.parseInt(input[12]));
        return tyreInfo;
    }
}