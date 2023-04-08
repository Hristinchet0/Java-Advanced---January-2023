package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }
    @Override
    public void addFish(Fish fish) {
        if (this.capacity < this.fish.size()) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }
    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);

    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);

    }

    @Override
    public void feed() {
        for (Fish fish : fish) {
            fish.eat();
        }

    }

    @Override
    public String getInfo() {
        StringBuilder message = new StringBuilder();
        message.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName())).append(System.lineSeparator());
        message.append("Fish: ");
        String fishNames = this.fish
                .stream()
                .map(Fish::getName)
                .collect(Collectors.joining(" "));
        if (!this.fish.isEmpty()) {
            message.append(String.format("%s", fishNames));
        } else {
            message.append("none").append(System.lineSeparator());
        }
        message.append(System.lineSeparator());
        message.append(String.format("Decorations: %d", this.decorations.size())).append(System.lineSeparator());
        message.append(String.format("Comfort: %d", calculateComfort())).append(System.lineSeparator());

        return message.toString().trim();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
