package _4_TrafficLights;

import java.util.List;
import java.util.stream.Collectors;

public class TrafficLight {
    private final List<Light> lights;

    public TrafficLight(List<Light> lights) {
        this.lights = lights;
    }

    public void update() {
        for (int i = 0; i < lights.size(); i++) {
            Light light = lights.get(i);
            switch (light) {
                case RED: {
                    this.lights.set(i, Light.GREEN);
                    break;
                }
                case GREEN: {
                    this.lights.set(i, Light.YELLOW);
                    break;
                }
                case YELLOW: {
                    this.lights.set(i, Light.RED);
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.lights.stream().map(String::valueOf).collect(Collectors.joining(" ")).trim();
    }
}
