package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        Pet wantedPet = null;
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                wantedPet = pet;
            }
        }

        return wantedPet;
    }

    public Pet getOldestPet() {
        Pet oldestPet = null;
        int maxAge = Integer.MIN_VALUE;
        for (Pet pet : this.data) {
            if (pet.getAge() > maxAge) {
                oldestPet = pet;
                maxAge = pet.getAge();
            }
        }

        return oldestPet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("The clinic has the following patients:%n"));
        for (Pet pet : data) {
            output.append(String.format("%s %s%n", pet.getName(), pet.getOwner()));
        }
        return output.toString().trim();
    }
}
