package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public boolean remove(String name) {
        int index = findPetIndex(name);
        if (index != -1) {
            data.remove(index);
            return true;
        }

        return false;
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    private int findPetIndex(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Pet getPet(String name, String owner) {
        Pet currentPet = this.data.stream()
                .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findFirst().orElse(null);
        return currentPet;


    }

    public int getCount() {
        return this.data.size();
    }


    public String getStatistics() {
        StringBuilder builder = new StringBuilder("The grooming salon has the following clients:" + System.lineSeparator());
        for (Pet pet : data) {
            builder.append(pet.getName().toString());
            builder.append(" ").append(pet.getOwner().toString());
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();

    }
}
