package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;


public abstract class BaseAstronaut implements Astronaut{
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        this.setOxygen(this.getOxygen() - 10);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            String msg = String.format(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
            throw new IllegalArgumentException(msg);
        }
        this.name = name;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            String msg = String.format(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
            throw new IllegalArgumentException(msg);
        }
        this.oxygen = oxygen;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}
