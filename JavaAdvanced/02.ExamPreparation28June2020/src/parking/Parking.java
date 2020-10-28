package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        Car latestCar = null;
        int maxYear = Integer.MIN_VALUE;
        if (!data.isEmpty()) {
            for (Car car : data) {
                if (maxYear < car.getYear()) {
                    latestCar = car;
                    maxYear = car.getYear();
                }
            }
        }

        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        Car wantedCar = null;
        if (!data.isEmpty()) {
            for (Car car : data) {
                if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                    wantedCar = car;
                }
            }
        }

        return wantedCar;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("The cars are parked in %s:%n", this.type));
        for (Car car : data) {
            output.append(car).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
    //Parking
    //Next, write a Java class Parking that has data (Collection, which stores the entity Car).
    // All entities inside the repository have the same fields. Also, the Parking class should have those fields:
    //•	type: String
    //•	capacity: int
    //The class constructor should receive type and capacity, also it should initialize the data
    // with a new instance of the collection. Implement the following features:
    //•	Field data – Collection that holds added cars

    //•	Method add(Car car) – adds an entity to the data if there is an empty cell for the car.
    //•	Method remove(String manufacturer, String model) – removes the car by given manufacturer and model,
    // if such exists, and returns boolean.
    //•	Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    //•	Method getCar(String manufacturer, String model) – returns the car with the given manufacturer and
    // model or null if there is no such car.
    //•	Getter getCount() – returns the number of cars.
    //•	getStatistics() – returns a String in the following format:
    //o	"The cars are parked in {parking type}:
    //{Car1}
}
