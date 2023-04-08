package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {

    private final static int EXAMPLE_MAX_SPEED = 310;
    private Garage garage;
    private Car porsche;
    private Car audi;
    private Car mercedes;
    @Before
    public void setUp() {
        this.garage = new Garage();
        porsche = new Car("Porsche", 300, 120000);
        audi = new Car("Audi", 340, 110000);
        mercedes = new Car("Mercedes", 265, 115000);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddCarShouldThrow() {
        garage.addCar(null);
    }

    @Test
    public void testAddCarSuccessfully() {
        garage.addCar(porsche);
        Assert.assertEquals(1, garage.getCount());
        garage.addCar(mercedes);
        Assert.assertEquals(2, garage.getCount());

    }

    @Test
    public void testGetCarsSuccessfully() {
        garage.addCar(porsche);
        List<Car> carsInGarage = garage.getCars();
        Assert.assertEquals(1, garage.getCount());
        Assert.assertEquals(porsche.getBrand(), carsInGarage.get(0).getBrand());
    }

    @Test
    public void testGetFastestCar() {
        garage.addCar(porsche);
        garage.addCar(audi);
        garage.addCar(mercedes);
        List<Car> carWithSpeedAboveValue = garage.findAllCarsWithMaxSpeedAbove(EXAMPLE_MAX_SPEED);

        Assert.assertEquals(audi.getBrand(), carWithSpeedAboveValue.get(0).getBrand());
    }

    @Test
    public void testGetMostExpensiveCar() {
        garage.addCar(porsche);
        garage.addCar(audi);
        garage.addCar(mercedes);
        Car mostExpensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertEquals(porsche.getBrand(), mostExpensiveCar.getBrand());
    }

    @Test
    public void testFindAllCarsByBrand() {
        garage.addCar(porsche);
        garage.addCar(porsche);
        garage.addCar(audi);
        garage.addCar(mercedes);

        List<Car> cars = garage.findAllCarsByBrand(porsche.getBrand());
        Assert.assertEquals(2, cars.size());

    }

}