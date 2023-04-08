package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.*;

public class DiscovererRepository implements Repository<Discoverer> {

    private Map<String, Discoverer> discoverers;

    public DiscovererRepository() {
        this.discoverers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(this.discoverers.values());
    }

    @Override
    public void add(Discoverer entity) {
        this.discoverers.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Discoverer entity) {
        Discoverer removed = this.discoverers.remove(entity.getName());

        return removed != null;
    }

    @Override
    public Discoverer byName(String name) {
        return this.discoverers.get(name);
    }
}
