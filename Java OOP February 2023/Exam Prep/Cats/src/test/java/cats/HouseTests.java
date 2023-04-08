package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHouseWithInvalidCapacity() {
        new House("House1", -4);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHouseWithInvalidName() {
        new House(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHouseWithInvalidNameEmpty() {
        new House("", 5);
    }

    @Test
    public void testCreateHouse() {
        House house = new House("House1", 10);
        Assert.assertEquals("House1", house.getName());
        Assert.assertEquals(10, house.getCapacity());
    }

    @Test
    public void testAddCatSuccessfully() {
        House house = new House("House1", 10);
        Cat cat = new Cat("Mike");
        Assert.assertEquals(0, house.getCount());
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatThrowWhenHouseIsFull() {
        House house = new House("House1", 1);
        Cat cat = new Cat("Mike");
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());

        Cat cat1 = new Cat("Tom");
        house.addCat(cat1);
    }

    @Test
    public void testRemoveCatSuccessfully() {
        House house = new House("House1", 10);
        Cat cat = new Cat("Mike");
        house.addCat(cat);
        Cat cat1 = new Cat("Tom");
        house.addCat(cat1);
        Assert.assertEquals(2, house.getCount());

        house.removeCat("Tom");
        Assert.assertEquals(1, house.getCount());
        house.removeCat("Mike");
        Assert.assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatShouldThrowWhenIsNull() {
        House house = new House("House1", 10);
        house.removeCat("Tom");
    }

    @Test
    public void testCatForSaleSuccessfully() {
        House house = new House("House1", 10);
        Cat cat = new Cat("Mike");
        house.addCat(cat);
        Cat cat1 = new Cat("Tom");
        house.addCat(cat1);

        Cat returnedCat = house.catForSale("Mike");
        Assert.assertFalse(returnedCat.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleShouldThrowWhenIsNull() {
        House house = new House("House1", 10);
        house.catForSale("Tom");
    }

    @Test
    public void testStatistics() {
        House house = new House("House1", 10);
        Cat cat = new Cat("Mike");
        house.addCat(cat);
        Cat cat1 = new Cat("Tom");
        house.addCat(cat1);
        Cat cat2 = new Cat("Max");
        house.addCat(cat2);

        Assert.assertEquals("The cat Mike, Tom, Max is in the house House1!", house.statistics());
    }






}
