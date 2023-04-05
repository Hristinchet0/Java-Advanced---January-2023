package vehicleExtends_02;

public class Truck extends Vehicle {
    private final static double AC_ADDITIONAL_CONSUMPTION  = 1.6;
    private final static double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, AC_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * FUEL_AFTER_DRIVER_DEDUCTION);
    }
}
