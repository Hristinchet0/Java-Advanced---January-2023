package vehicle_01;

public class Truck extends Vehicle {
    private final static double ADDITIONAL_AC_CONSUMPTION = 1.6;
    private final static double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_AC_CONSUMPTION);
//        super.setFuelConsumption(super.getFuelConsumption() + ADDITIONAL_AC_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * FUEL_AFTER_DRIVER_DEDUCTION);
    }
}
