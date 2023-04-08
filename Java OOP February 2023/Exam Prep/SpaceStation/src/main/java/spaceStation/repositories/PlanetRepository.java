package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlanetRepository implements Repository<Planet> {

    private List<Planet> planets;

    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }


    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableList(this.planets);
    }

    @Override
    public void add(Planet model) {
        this.planets.add(model);

    }
    @Override
    public boolean remove(Planet model) {
        return this.planets.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);
    }
}
