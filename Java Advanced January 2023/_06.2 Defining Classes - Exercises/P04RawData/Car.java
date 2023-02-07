package P04RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine Engine;
    private Cargo Cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        Engine = engine;
        Cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return Engine;
    }

    public Cargo getCargo() {
        return Cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }
}
