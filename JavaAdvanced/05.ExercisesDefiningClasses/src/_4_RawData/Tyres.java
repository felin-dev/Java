package _4_RawData;

import java.util.Map;

public class Tyres {
    private final Map<Double, Integer> tyreInfo;

    Tyres(Map<Double, Integer> tyreInfo) {
        this.tyreInfo = tyreInfo;
    }

    public Map<Double, Integer> getTyreInfo() {
        return this.tyreInfo;
    }
}