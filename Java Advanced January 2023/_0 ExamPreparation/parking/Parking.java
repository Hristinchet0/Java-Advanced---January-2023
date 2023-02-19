package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if(this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car s : this.data) {
            if (s.getManufacturer().equals(manufacturer) && s.getModel().equals(model)) {
                return this.data.remove(s);
            }
        }
        return this.data.remove(null);
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(s -> s.getManufacturer().equals(manufacturer) && s.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return "The cars are parked in " + this.type + ":" + System.lineSeparator() +
                this.data.stream().map(pet -> pet+ "").collect(Collectors.joining(System.lineSeparator()));
    }

}
