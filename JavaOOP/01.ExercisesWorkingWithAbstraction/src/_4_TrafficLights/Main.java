package _4_TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Light> lights = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Light::valueOf)
                .collect(Collectors.toList());
        TrafficLight trafficLight = new TrafficLight(lights);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            trafficLight.update();

            System.out.println(trafficLight);
        }
    }
}
