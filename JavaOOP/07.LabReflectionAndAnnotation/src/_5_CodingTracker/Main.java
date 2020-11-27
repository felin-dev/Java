package _5_CodingTracker;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("_5_CodingTracker.Tracker");

        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
