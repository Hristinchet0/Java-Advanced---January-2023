package carShopExtended_02;

public class CarImpl implements Car{
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public String getCountryProduced() {
        return countryProduced;
    }

    public void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %s tires", this.getModel(), this.countryProduced, Car.TIERS);
    }
}
