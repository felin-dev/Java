package _5_JediGalaxy;

public class Main {
    public static void main(String[] args) {
        ProcessGalaxyFromScanner galaxyProcessor = new ProcessGalaxyFromScanner();
        galaxyProcessor.processCommands();
        ProcessGalaxyFromScanner.printTotalStarsCollected();
    }
}
