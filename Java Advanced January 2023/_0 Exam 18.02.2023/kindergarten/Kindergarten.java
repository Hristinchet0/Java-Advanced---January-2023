package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Child> getRegistry() {
        return registry;
    }

    public void setRegistry(List<Child> registry) {
        this.registry = registry;
    }

    public boolean addChild(Child child)  {
        if (this.registry.size() < this.capacity) {
            this.registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        if (registry.removeIf(child -> child.getFirstName().equals(firstName))) return true;
        else return false;
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {

        Child searchedChild = null;

        for (Child c : registry) {
            if (c.getFirstName().equals(firstName)) {
                searchedChild = c;
            }
        }

        return searchedChild;
    }

    public String registryReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:%n", this.name));
        List<Child> sortedList = new ArrayList<>();
        for (Child c : registry) {
            sortedList.add(c);
        }
        sortedList.sort(Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));


        for (Child child : sortedList) {
            sb.append("--");
            sb.append(System.lineSeparator());
            sb.append(child);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
