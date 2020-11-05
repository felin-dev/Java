package _6_GreedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private final long capacity;
    private long currentWeight;
    private long totalGold;
    private long totalGems;
    private final Map<String, Long> gems;
    private long totalCash;
    private final Map<String, Long> cash;
    private boolean addedGold;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
        this.addedGold = false;
    }

    public void addGold(long quantity) {
        if (hasFreeSpace(quantity)) {
            this.totalGold += quantity;
            this.currentWeight += quantity;
            this.addedGold = true;
        }
    }

    public void addGems(String gem, long quantity) {
        if (hasFreeSpace(quantity) && this.totalGems + quantity <=
                this.totalGold) {
            if (!this.gems.containsKey(gem)) {
                this.gems.put(gem, quantity);
            } else {
                this.gems.put(gem, this.gems.get(gem) + quantity);
            }
            this.totalGems += quantity;
            this.currentWeight += quantity;
        }
    }

    public void addCash(String currency, long quantity) {
        if (hasFreeSpace(quantity) && this.totalGems >=
                this.totalCash + quantity) {
            if (!this.cash.containsKey(currency)) {
                this.cash.put(currency, quantity);
            } else {
                this.cash.put(currency, this.cash.get(currency) + quantity);
            }
            this.totalCash += quantity;
            this.currentWeight += quantity;
        }
    }

    private boolean hasFreeSpace(long quantity) {
        return this.currentWeight + quantity <= this.capacity;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (this.addedGold) {
            output.append(String.format("<Gold> $%d%n", this.totalGold));
            output.append(String.format("##Gold - %d%n", this.totalGold));
        }

        if (this.gems.size() > 0) {
            output.append(String.format("<Gem> $%d%n", this.totalGems));
            this.gems.entrySet().stream()
                    .sorted((f, s) -> {
                        int result = s.getKey().compareTo(f.getKey());
                        if (result == 0) {
                            result = f.getValue().compareTo(s.getValue());
                        }

                        return result;
                    })
                    .forEach(entry -> output.append(String.format("##%s - %d%n", entry.getKey(),
                            entry.getValue())));
        }

        if (this.cash.size() > 0) {
            output.append(String.format("<Cash> $%d%n", this.totalCash));
            this.cash.entrySet().stream()
                    .sorted((f, s) -> {
                        int result = s.getKey().compareTo(f.getKey());
                        if (result == 0) {
                            result = f.getValue().compareTo(s.getValue());
                        }

                        return result;
                    })
                    .forEach(entry -> output.append(String.format("##%s - %d%n", entry.getKey(),
                            entry.getValue())));
        }

        return output.toString().trim();
    }
}
