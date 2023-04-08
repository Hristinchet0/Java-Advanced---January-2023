package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {

    @Test
    public void testConstructorCreateFarmSuccessfully() {
        Farm farm = new Farm("Cow Farm", 5);
        String expectedName = "Cow Farm";
        Assert.assertEquals(expectedName, farm.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowIfNameIsNull() {
        Farm farm = new Farm(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowIfCapacityIsNegative() {
        Farm farm = new Farm("Cow Farm", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenNoCapacity() {
        Farm farm = new Farm("Cow Farm", 1);
        Animal animal = new Animal("Cow", 5);
        farm.add(animal);
        Animal animal2 = new Animal("Cow2", 10);
        farm.add(animal2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfAnimalExist() {
        Farm farm = new Farm("Cow Farm", 2);
        Animal animal = new Animal("Cow", 5);
        farm.add(animal);
        farm.add(new Animal("Cow", 5));
    }

    @Test
    public void testAddSuccessfully() {
        Farm farm = new Farm("Cow Farm", 3);
        Animal animal = new Animal("Cow", 5);
        farm.add(animal);
        Assert.assertEquals(1, farm.getCount());
        Animal animal2 = new Animal("Cow2", 10);
        farm.add(animal2);
        Assert.assertEquals(2, farm.getCount());
    }

    @Test
    public void testRemoveSuccessfully() {
        Farm farm = new Farm("Cow Farm", 3);
        Animal animal = new Animal("Cow", 5);
        farm.add(animal);
        boolean removedAnimal = farm.remove("Cow");
        Assert.assertTrue(removedAnimal);
    }
}
