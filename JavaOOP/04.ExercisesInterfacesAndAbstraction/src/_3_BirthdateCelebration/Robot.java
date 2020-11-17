package _3_BirthdateCelebration;

public class Robot implements Identifiable, Machine {

    private final String id;
    private final String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getModel() {
        return model;
    }
}
