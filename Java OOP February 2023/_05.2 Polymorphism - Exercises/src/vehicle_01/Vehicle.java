package vehicle_01;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance){
        double fuelNeeded = distance * getFuelConsumption();
        if(fuelNeeded > getFuelQuantity()) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        setFuelQuantity(getFuelQuantity() - fuelNeeded);

        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km",this.getClass().getSimpleName(), decimalFormat.format(distance));

    }
    public void refuel(double liters){
//        if (this instanceof Truck) {
//            liters = liters * 0.95;
//        }
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }
}
