package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowWhenNegativeNumber() {
        Aquarium aquarium = new Aquarium("Softuni", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWhenNameIsNull() {
        Aquarium aquarium = new Aquarium(null, 5);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWhenNameIsWhitespace() {
        Aquarium aquarium = new Aquarium("     ", 5);
    }

    @Test
    public void testSetNameSuccessfully() {
        Aquarium aquarium = new Aquarium("Softuni", 5);
        Assert.assertEquals("Softuni", aquarium.getName());
    }

    @Test
    public void testCreateAquariumSuccessfully() {
        Aquarium aquarium = new Aquarium("Softuni", 5);
        Assert.assertEquals("Softuni", aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWithoutCapacity() {
        Aquarium aquarium = new Aquarium("Softuni", 1);
        Fish fish = new Fish("Max");
        aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCapacity());

        Fish fish1 = new Fish("Tom");
        aquarium.add(fish);
    }

    @Test
    public void testAddSuccessfully() {
        Aquarium aquarium = new Aquarium("Softuni", 5);
        Fish fish = new Fish("Max");
        aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());
        Fish fish1 = new Fish("Tom");
        aquarium.add(fish);
        Assert.assertEquals(2, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowWhenAquariumIsNull() {
        Aquarium aquarium = new Aquarium("Softuni", 5);
        aquarium.remove("Max");
    }

    @Test
    public void testRemoveSuccessfully() {
        Aquarium aquarium = new Aquarium("Softuni", 5);
        Fish fish = new Fish("Max");
        aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());
        Fish fish1 = new Fish("Tom");
        aquarium.add(fish1);
        Assert.assertEquals(2, aquarium.getCount());
        aquarium.remove("Tom");
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test
    public void testSellFishSuccessfully() {
        Aquarium aquarium = new Aquarium("Softuni", 5);
        Fish fish = new Fish("Max");
        aquarium.add(fish);
        Fish fish1 = new Fish("Tom");
        aquarium.add(fish1);

        Fish returnedFish = aquarium.sellFish("Tom");
        Assert.assertFalse(returnedFish.isAvailable());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishThrowWhenIsNull() {
        Aquarium aquarium = new Aquarium("Softuni", 5);
        aquarium.sellFish("Tom");
    }

    @Test
    public void testReport() {
        Aquarium aquarium = new Aquarium("Softuni", 5);
        Fish fish = new Fish("Max");
        aquarium.add(fish);
        Fish fish1 = new Fish("Tom");
        aquarium.add(fish1);
        Assert.assertEquals("Fish available at Softuni: Max, Tom", aquarium.report());
    }
}

