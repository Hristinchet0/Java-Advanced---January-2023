package robots;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {
    @Test
    public void testServiceValidName() {
        Service service = new Service("valid", 10);
        Assert.assertEquals("valid",service.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testServiceShouldThrowWhenNullName() {
        Service service = new Service(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testServiceShouldThrowWhenWhiteSpaceName() {
        Service service = new Service("      ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testServiceShouldThrowWhenNegativeCapacity() {
        Service service = new Service("valid", -10);
    }

    @Test
    public void testServiceValidCapacity() {
        Service service = new Service("valid", 10);
        Assert.assertEquals(10, service.getCapacity());
    }

    @Test
    public void testAddRobotoSuccessfully() {
        Robot robot = new Robot("Robotcho");
        Robot robot1 = new Robot("Robotcho1");
        Service service = new Service("valid", 10);
        service.add(robot);
        service.add(robot1);
        Assert.assertEquals(2, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenCapacityEqualsToSize() {
        Robot robot = new Robot("Robotcho");
        Robot robot1 = new Robot("Robotcho1");
        Service service = new Service("valid", 1);
        service.add(robot);
        service.add(robot1);
    }

    @Test
    public void testRemoveSuccessfully() {
        Robot robot = new Robot("Softuni");
        Service service = new Service("valid", 10);
        service.add(robot);
        service.remove("Softuni");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowWhenIsNull() {
        Robot robot = new Robot("Softuni");
        Robot robot1 = new Robot("Robotcho1");
        Service service = new Service("valid", 10);
        service.add(robot);
        service.add(robot1);
        service.remove("Robotcho");
        Assert.assertEquals(1, service.getCount());
    }

    @Test
    public void testForSale() {
        Robot robot = new Robot("Robotcho");
        Robot robot1 = new Robot("Robotcho1");
        Service service = new Service("valid", 10);
        service.add(robot);
        service.add(robot1);
        Robot returnedRobot = service.forSale("Robotcho");
        Assert.assertFalse(returnedRobot.isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleShouldThrowWhenIsNull() {
        Robot robot = new Robot("Robotcho");
        Robot robot1 = new Robot("Robotcho1");
        Service service = new Service("valid", 10);
        service.add(robot);
        service.add(robot1);
        service.forSale("invalid");
    }

    @Test
    public void testReport() {
        Service service = new Service("valid", 10);
        Robot robot = new Robot("Robotcho");
        Robot robot1 = new Robot("Robotcho1");
        service.add(robot);
        service.add(robot1);
        Assert.assertEquals("The robot Robotcho, Robotcho1 is in the service valid!", service.report());

    }

}
