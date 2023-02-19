package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> pets;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.pets = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.pets.size()) {
            this.pets.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                this.pets.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.pets) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        List<Pet> list = new ArrayList<>();
        for (Pet pet : this.pets) {
            list.add(pet);
        }
        list.sort((a, b) -> Integer.compare(b.getAge(), a.getAge()));
        return list.get(0);
    }

    public int getCount() {
        return this.pets.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("The clinic has the following patients:").append(System.lineSeparator());

        for (Pet pet : this.pets) {
            sb.append(String.format("%s %s", pet.getName(), pet.getOwner()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

