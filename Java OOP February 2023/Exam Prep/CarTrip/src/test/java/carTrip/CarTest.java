package carTrip;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void testCreateCarSuccessfully() {
        Car car = new Car("Mercedes", 80, 60, 12.2);
    }

    @Test
    public void testGetModel() {
        Car car = new Car("Mercedes", 80, 60, 12.2);
        String expected = car.getModel();
        Assert.assertEquals("Mercedes", expected);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetModelShouldThrowWhenIsNull() {
        Car car = new Car(null, 80, 60, 12.2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetModelShouldThrowWhenIsEmpty() {
        Car car = new Car("", 80, 60, 12.2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelConsumptionPerKmShouldThrowWhenIsLessThenZero() {
        Car car = new Car("Mercedes", 80, 60, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelAmountShouldThrowWhenIsLessThenTankCapacity() {
        Car car = new Car("Mercedes", 80, 90, 12.2);
    }

    @Test(expected = IllegalStateException.class)
    public void testDriveShouldThrowIfNotEnoughFuel() {
        Car car = new Car("Mercedes", 80, 5, 12.2);
        car.drive(2);
    }

    @Test(expected = IllegalStateException.class)
    public void testDriveShouldUseFuel() {
        Car car = new Car("Mercedes", 80, 50, 9.0);
        car.drive(52);
    }

    @Test
    public void testDriveShouldCorrectResult() {
        Car car = new Car("Mercedes", 80, 50, 9.0);
        String result = car.drive(1);
        Assert.assertEquals("Have a nice trip", result);
    }

    @Test(expected = IllegalStateException.class)
    public void testRefuelShouldThrowIfFuelIsMoreThenEnough() {
        Car car = new Car("Mercedes", 80, 50, 9.0);
        car.refuel(50);
    }

    @Test
    public void testRefuelSuccessfully() {
        Car car = new Car("Mercedes", 80, 50, 9.0);
        car.refuel(10);
        Assert.assertEquals(60, car.getFuelAmount(), 0.0);
    }




}