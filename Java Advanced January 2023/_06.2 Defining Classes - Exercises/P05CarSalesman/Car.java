package P05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.model).append(":").append(System.lineSeparator());
        stringBuilder.append(this.engine.getModel()).append(":").append(System.lineSeparator());
        stringBuilder.append("Power: ").append(this.engine.getPower()).append(System.lineSeparator());
        stringBuilder.append("Displacement: ");
        if(this.engine.getDisplacement() == 0) {
            stringBuilder.append("n/a").append(System.lineSeparator());
        } else {
            stringBuilder.append(this.engine.getDisplacement()).append(System.lineSeparator());
        }
        stringBuilder.append("Efficiency: ");
        if(this.engine.getEfficiency() ==  null) {
            stringBuilder.append("n/a").append(System.lineSeparator());
        } else {
            stringBuilder.append(this.engine.getEfficiency()).append(System.lineSeparator());
        }
        stringBuilder.append("Weight: ");
        if(this.weight == 0) {
            stringBuilder.append("n/a").append(System.lineSeparator());
        } else {
            stringBuilder.append(this.weight).append(System.lineSeparator());
        }
        stringBuilder.append("Color: ");
        if(this.color ==  null) {
            stringBuilder.append("n/a");
        } else {
            stringBuilder.append(this.color);
        }
        return stringBuilder.toString();
    }
}
