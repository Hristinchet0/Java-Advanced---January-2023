package spaceStation.models.planets;

import spaceStation.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlanetImpl implements Planet {
    private String name;
    private List<String> items;

    public PlanetImpl(String name) {
        this.setName(name);
        this.items = new ArrayList<>();
    }

    @Override
    public List<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            String msg = String.format(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
            throw new NullPointerException(msg);
        }
        this.name = name;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
